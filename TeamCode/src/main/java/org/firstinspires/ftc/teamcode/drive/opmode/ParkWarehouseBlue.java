package org.firstinspires.ftc.teamcode.drive.opmode;

import android.widget.TableRow;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.teamcode.drive.PoseStorage;
//import org.firstinspires.ftc.teamcode.drive.Subsystem;
import org.firstinspires.ftc.teamcode.Ratoi;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.drive.localization.OpenCVThread;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name="ParkWarehouse Blue", group = "autonomous")
public class ParkWarehouseBlue extends LinearOpMode {

    private Robot robot = null;
    private static final int TURNING_ANGLE = 120;
    private ElapsedTime timer;
    private static final double FOAM_TILE_INCH = 23.6;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH,-2.3 * FOAM_TILE_INCH);
    //TODO Modificat aceste obiecte
    private final Vector2d secondWobble = new Vector2d(-1.3 * FOAM_TILE_INCH, -2.4 * FOAM_TILE_INCH);
    private Pose2d wobbleDropPose = new Pose2d(0.2 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH);
    private static double endTargetTangent = Math.toRadians(-180);
    private static double startTargetTangent = Math.toRadians(60);

    private final Pose2d throwWobble = new Pose2d(-0.2*FOAM_TILE_INCH, -1.3 * FOAM_TILE_INCH, Math.toRadians(0));

    public OpenCVThread openCV;
    public ElapsedTime opencvTimer;
    public static int MAX_MILISECONDS = 5000;
    private Ratoi.Location finalLocation;

    //OpenCvCamera webCam;


    public void initAutonomous(){
        telemetry.addData(">", "Initializing...");
        telemetry.update();
        robot = new Robot(hardwareMap);

        openCV = new OpenCVThread(hardwareMap);
        finalLocation = Ratoi.Location.RIGHT;

        openCV.start();

        timer = new ElapsedTime();
        telemetry.addData("has initialised", "yes");
        telemetry.update();

        // initiazilare;

//        robot.sweeper.servoBrat.setPosition(0.3);
//
//        robot.sweeper.servoBrat2.setPosition(0.7);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();
    }

    private void mergi(int maxTime, Pose2d pose2d){
        ElapsedTime elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        elapsedTime.startTime();

        while (elapsedTime.milliseconds() < maxTime){
            robot.drive.setDrivePower(pose2d);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initAutonomous();
        waitForStart();


        opencvTimer = new ElapsedTime();

        opencvTimer.startTime();

        timer.startTime();

        while (opencvTimer.milliseconds() < MAX_MILISECONDS){
            telemetry.addData("Location: ", openCV.getLocation());
            telemetry.update();
            finalLocation = openCV.getLocation();
        }

        try {
            openCV.finalize();
        }catch (Throwable throwable){
            throwable.printStackTrace();
            }

        //        while (){
        //            telemetry.addData("Location: ", openCV.getLocation());
        //            finalLocation = openCV.getLocation();
        //            telemetry.update();
        //        }
        timer = new ElapsedTime();
        timer.startTime();

        mergi(400 , new Pose2d(-0.7, 0, 0));
        robot.drive.turn(Math.toRadians(120));
        mergi(800 , new Pose2d(-1, 0, 0));
    }
}