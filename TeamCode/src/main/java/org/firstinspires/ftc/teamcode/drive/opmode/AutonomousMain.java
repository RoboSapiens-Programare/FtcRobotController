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

@Autonomous(name="Autonomie Help me", group = "autonomous")
public class AutonomousMain extends LinearOpMode {

    private Robot robot = null;
    private static final int TURNING_ANGLE = 120;
    public static int parkingDeltaTime = /*700*/2600;
    public static int turningDeltaTime = 110;
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

            mergi(turningDeltaTime, new Pose2d(0.7, 0, 0));

            robot.drive.turn(Math.toRadians(-TURNING_ANGLE));

            timer = new ElapsedTime();
            timer.startTime();

            mergi(750, new Pose2d(0.7, 0, 0));

            switch(finalLocation) {
                case LEFT: //o da
                    robot.drive.turn(Math.toRadians(TURNING_ANGLE - 10));

                    mergi(100, new Pose2d(0.7, 0, 0));

                    robot.sweeper.levelOne();

                    mergi(1500, new Pose2d(0, 0, 0));

                    timer = new ElapsedTime();
                    timer.startTime();
                    while(timer.milliseconds() < 2500)
                        robot.sweeper.outtake();
                    robot.sweeper.stopSweep();

                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.sweeper.resetCuva();

                    mergi(1500, new Pose2d(0, 0, 0));

                    robot.drive.turn(Math.toRadians(-TURNING_ANGLE - 10));

                    break;
                case CENTER: //yaaaa
                    robot.drive.turn(Math.toRadians(TURNING_ANGLE - 10));

                    timer = new ElapsedTime();
                    timer.startTime();

                    mergi(170, new Pose2d(0.7, 0, 0));

                    robot.sweeper.levelTwo();

                    mergi(600, new Pose2d(0, 0, 0));

                    while(timer.milliseconds() < 3000)
                        robot.sweeper.outtake();
                    robot.sweeper.stopSweep();

                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.sweeper.resetCuva();

                    mergi(1000, new Pose2d(0, 0, 0));

                    robot.drive.turn(Math.toRadians(-TURNING_ANGLE - 10));

                    break;
                case RIGHT: //ok
                    robot.drive.turn(Math.toRadians(-TURNING_ANGLE - 50));

                    timer = new ElapsedTime();
                    timer.startTime();

                    mergi(400, new Pose2d(-0.6, 0, 0));

                    robot.sweeper.levelThree();

                    mergi(500, new Pose2d(0, 0, 0));

                    while(timer.milliseconds() < 2500)
                        robot.sweeper.sweepIn();
                    robot.sweeper.stopSweep();

                    mergi(300, new Pose2d(0.7, 0, 0));

                    robot.sweeper.resetCuva();

                    mergi(3000, new Pose2d(0, 0, 0));

                    robot.drive.turn(Math.toRadians(TURNING_ANGLE + 45));

                    break;
            }

            mergi(2000, new Pose2d(1, 0, 0));
            mergi(1000, new Pose2d(0, 0, 0));

 //sau 90

        /*timer.reset();
        timer.startTime();

        while(timer.milliseconds() < parkingDeltaTime / 4){
            robot.drive.setDrivePower(new Pose2d(-0.7, 0, 0));
        }robot.drive.setDrivePower(new Pose2d(0, 0, 0));

        timer.reset();
        timer.startTime();

        while(timer.milliseconds() < 2500){
            robot.carousel.spin();
        }robot.carousel.stopSpin();

        robot.drive.turn(Math.toRadians(-10));

        timer.reset();
        timer.startTime();

        while (timer.milliseconds() < parkingDeltaTime + parkingDeltaTime / 4){
            telemetry.addData("Se misca pe beat", timer.milliseconds());
            telemetry.update();
            robot.drive.setDrivePower(new Pose2d(1, 0, 0));
        }robot.drive.setDrivePower(new Pose2d(0, 0, 0));*/

//        robot.sweeper.motorCuva.setTargetPosition(200);
//        robot.sweeper.motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.sweeper.motorCuva.setPower(-0.75);
//        robot.sweeper.motorCuva.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER );
//        timer.reset();
//        timer.startTime();

//        robot.drive.turn(Math.toRadians(-180));
//        while(timer.milliseconds() < parkingDeltaTime){
//            telemetry.addData("ho", "matelot");
//        }

    }

//          todo  task 1: plasat obiect pe shipping hub DONE
//          todo  task 2: dat jos ratusca de pe carusel
//          todo  task 3: parcat in patrat/warehouse
}