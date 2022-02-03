package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//import org.firstinspires.ftc.teamcode.drive.PoseStorage;
//import org.firstinspires.ftc.teamcode.drive.Subsystem;
import org.firstinspires.ftc.teamcode.Ratoi;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name="Autonomie Standard", group = "autonomous")
public class AutonomousMain extends LinearOpMode {

    private Robot robot;
    private Ratoi ratoi;
    public static int MAX_MILISECONDS = 2500;
    private static final double FOAM_TILE_INCH = 23.6;
    private double startAngle, wobbleSpeed;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH,-2.3 * FOAM_TILE_INCH);
    //Modificat aceste obiecte
    private final Vector2d secondWobble = new Vector2d(-1.3 * FOAM_TILE_INCH, -2.4 * FOAM_TILE_INCH);
    private Pose2d wobbleDropPose = new Pose2d(0.2 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH);
    private static double endTargetTangent = Math.toRadians(-180);
    private static double startTargetTangent = Math.toRadians(60);

    private final Pose2d throwWobble = new Pose2d(-0.2*FOAM_TILE_INCH, -1.3 * FOAM_TILE_INCH, Math.toRadians(0));

    OpenCvCamera webCam;


    public void initAutonomous(){
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);

        // initiazilare;

//        robot.sweeper.servoBrat.setPosition(0.3);
//
//        robot.sweeper.servoBrat2.setPosition(0.7);

//        robot.openCV.start();

           while (robot.isInitialize() && opModeIsActive()) {
                idle();
            }

            telemetry.addData(">", "Initialized");
            telemetry.update();
        }

    @Override
    public void runOpMode() throws InterruptedException {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId",
                "id", hardwareMap.appContext.getPackageName());
        webCam = OpenCvCameraFactory.getInstance()
                .createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        Ratoi detector = new Ratoi(telemetry);

        webCam.setPipeline(detector);
        webCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webCam.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        waitForStart();



        switch(ratoi.getLocation()) {
            case "LEFT":
            {
                telemetry.addData("Left:", "detecteaza");
                break;
            }
            case "CENTER":
            {
                telemetry.addData("Center:", "detecteaza");
                break;
            }
            case "RIGHT":
            {
                telemetry.addData("Right", "detecteaza");
                break;
            }
            case "NOT_FOUND":
            {
                telemetry.addData("NOT_FOUND", "Eroare");
                break;
            }
        }

    }

        /* TODO task 1: plasat obiect pe shipping hub
            task 2: dat jos ratusca de pe carusel
            task 3: parcat in patrat/warehouse
        */

}