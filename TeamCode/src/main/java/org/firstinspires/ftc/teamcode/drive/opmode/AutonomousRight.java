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

@Autonomous(name="Autonomie warehouse", group = "autonomous")
public class AutonomousRight extends LinearOpMode {

    private Robot robot = null;
    private ElapsedTime timer;
    private static final double FOAM_TILE_INCH = 23.6;
    private double startAngle, wobbleSpeed;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH,-2.3 * FOAM_TILE_INCH);

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

            timer = new ElapsedTime();
            timer.startTime();



            switch(finalLocation) {
                case LEFT:
                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.drive.turn(Math.toRadians(55));

                    robot.sweeper.levelOne();

                    mergi(300, new Pose2d(-0.7, 0, 0));

                    mergi(1000, new Pose2d(0, 0, 0));

                    robot.sweeper.outtake();

                    mergi(2000, new Pose2d(0, 0, 0));

                    robot.sweeper.stopSweep();

                    robot.sweeper.resetCuva();

                    robot.drive.turn(Math.toRadians(-160));

                    mergi(750, new Pose2d(-1, 0, 0));
                    break;
                case CENTER:
                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.drive.turn(Math.toRadians(55));

                    robot.sweeper.levelTwo();

                    mergi(300, new Pose2d(-0.7, 0, 0));

                    mergi(1000, new Pose2d(0, 0, 0));

                    robot.sweeper.outtake();

                    mergi(2000, new Pose2d(0, 0, 0));

                    robot.sweeper.stopSweep();

                    robot.sweeper.resetCuva();

                    robot.drive.turn(Math.toRadians(-160));

                    mergi(750, new Pose2d(-1, 0, 0));
                    break;
                case RIGHT:
                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.drive.turn(Math.toRadians(55));

                    mergi(100, new Pose2d(-0.7, 0, 0));

                    robot.drive.turn(Math.toRadians(200));

                    robot.sweeper.levelThree();

                    mergi(600, new Pose2d(0.5, 0, 0));

                    mergi(2000, new Pose2d(0, 0, 0));

                    robot.sweeper.intake();

                    mergi(2000, new Pose2d(0, 0, 0));

                    robot.sweeper.stopSweep();

                    mergi(300, new Pose2d(-0.7, 0, 0));

                    robot.drive.turn(Math.toRadians(80));

                    robot.sweeper.resetCuva();

                    mergi(1000, new Pose2d(0, 0, 0));

                    mergi(700, new Pose2d(-1, 0, 0));
                    break;
            }

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
//
//          todo  task 1: plasat obiect pe shipping hub DONE
//          todo  task 2: dat jos ratusca de pe carusel
//          todo  task 3: parcat in patrat/warehouse DONE
}