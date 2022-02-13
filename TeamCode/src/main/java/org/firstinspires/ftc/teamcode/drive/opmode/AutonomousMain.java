package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.teamcode.drive.PoseStorage;
//import org.firstinspires.ftc.teamcode.drive.Subsystem;
import org.firstinspires.ftc.teamcode.drive.Robot;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name="Autonomie Help me", group = "autonomous")
public class AutonomousMain extends LinearOpMode {

    private Robot robot = null;
    public static int parkingDeltaTime = 700;
    public static int turningDeltaTime = 500;
    private ElapsedTime timer;
    private static final double FOAM_TILE_INCH = 23.6;
    private double startAngle, wobbleSpeed;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH,-2.3 * FOAM_TILE_INCH);
    //TODO Modificat aceste obiecte
    private final Vector2d secondWobble = new Vector2d(-1.3 * FOAM_TILE_INCH, -2.4 * FOAM_TILE_INCH);
    private Pose2d wobbleDropPose = new Pose2d(0.2 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH);
    private static double endTargetTangent = Math.toRadians(-180);
    private static double startTargetTangent = Math.toRadians(60);

    private final Pose2d throwWobble = new Pose2d(-0.2*FOAM_TILE_INCH, -1.3 * FOAM_TILE_INCH, Math.toRadians(0));

    //OpenCvCamera webCam;


    public void initAutonomous(){
        telemetry.addData(">", "Initializing...");
        telemetry.update();
        robot = new Robot(hardwareMap);

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

    @Override
    public void runOpMode() throws InterruptedException {
        initAutonomous();
        waitForStart();

        timer = new ElapsedTime();
        timer.startTime();

        while (timer.milliseconds() < turningDeltaTime){
            telemetry.addData("Se misca pe beat", timer.milliseconds());
            telemetry.update();
            robot.drive.setDrivePower(new Pose2d(0.7, 0, 0));
        }
        robot.drive.setDrivePower(new Pose2d(0, 0, 0));

        robot.drive.turn(Math.toRadians(90));

        timer.reset();
        timer.startTime();

        while (timer.milliseconds() < parkingDeltaTime){
            telemetry.addData("Se misca pe beat", timer.milliseconds());
            telemetry.update();
            robot.drive.setDrivePower(new Pose2d(1, 0, 0));
        }
        robot.drive.setDrivePower(new Pose2d(0, 0, 0));

//        robot.sweeper.motorCuva.setTargetPosition(200);
//        robot.sweeper.motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.sweeper.motorCuva.setPower(-0.75);
//        robot.sweeper.motorCuva.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER );
    }

        /*
            TODO task 1: plasat obiect pe shipping hub
            task 2: dat jos ratusca de pe carusel
            task 3: parcat in patrat/warehouse
            aaaaaa
        */


}