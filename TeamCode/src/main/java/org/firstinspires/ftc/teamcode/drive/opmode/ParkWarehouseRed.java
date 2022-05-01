package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Ratoi;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.drive.localization.OpenCVThread;

//import org.firstinspires.ftc.teamcode.drive.PoseStorage;
//import org.firstinspires.ftc.teamcode.drive.Subsystem;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name="ParkWarehouse Red", group = "autonomous")
public class ParkWarehouseRed extends LinearOpMode {

    private Robot robot = null;
    private ElapsedTime timer;
    private static final double FOAM_TILE_INCH = 23.6;
    private double startAngle, wobbleSpeed;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH,-2.3 * FOAM_TILE_INCH);

    public static int MAX_MILISECONDS = 5000;
    private Ratoi.Location finalLocation;

    //OpenCvCamera webCam;


    public void initAutonomous(){
        telemetry.addData(">", "Initializing...");
        telemetry.update();
        robot = new Robot(hardwareMap);

        timer = new ElapsedTime();
        telemetry.addData("has initialised", "yes");
        telemetry.update();

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

        try {
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

        timer = new ElapsedTime();
        timer.startTime();

        mergi(400, new Pose2d(-0.7, 0, 0));

        robot.drive.turn(Math.toRadians(-120));

        mergi(800, new Pose2d(-1, 0, 0));
        }
    }