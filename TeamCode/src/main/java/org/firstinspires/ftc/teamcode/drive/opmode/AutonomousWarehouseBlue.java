package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Ratoi;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.drive.localization.OpenCVThread;

@Autonomous(name="Autonomie warehouse blue", group = "autonomous")
public class AutonomousWarehouseBlue extends LinearOpMode {

    private Robot robot = null;
    private ElapsedTime timer;
    private static final double FOAM_TILE_INCH = 23.6;
    private double startAngle, wobbleSpeed;

    private final Pose2d startPose = new Pose2d(-2.6 * FOAM_TILE_INCH, -1 * FOAM_TILE_INCH, Math.toRadians(-90));
    private final Vector2d parkingVector = new Vector2d(0.5 * FOAM_TILE_INCH, -2.3 * FOAM_TILE_INCH);

    public OpenCVThread openCV;
    public ElapsedTime opencvTimer;
    public static int MAX_MILISECONDS = 5000;
    private Ratoi.Location finalLocation;

    //OpenCvCamera webCam;

    public void initAutonomous() {
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

    private void mergi(int maxTime, Pose2d pose2d) {
        ElapsedTime elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        elapsedTime.startTime();

        while (elapsedTime.milliseconds() < maxTime) {
            robot.drive.setDrivePower(pose2d);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initAutonomous();

        opencvTimer = new ElapsedTime();
        opencvTimer.startTime();
        timer.startTime();

        while (opencvTimer.milliseconds() < MAX_MILISECONDS) {
            telemetry.addData("Location: ", openCV.getLocation());
            telemetry.update();
            finalLocation = openCV.getLocation();
        }

        try {
            openCV.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        waitForStart();

        switch (finalLocation) {
            case LEFT:
                //Initial movement:
                mergi(100, new Pose2d(0.7, 0, 0));
                robot.drive.turn(Math.toRadians(-55));
                robot.sweeper.levelOne();
                mergi(300, new Pose2d(0.7, 0, 0));
                mergi(1000, new Pose2d(0, 0, 0));

                //Deploy freight:
                robot.sweeper.outtake();
                mergi(2000, new Pose2d(0, 0, 0));
                robot.sweeper.stopSweep();
                robot.sweeper.resetCuva();

                //Parking:
                robot.drive.turn(Math.toRadians(160));
                mergi(750, new Pose2d(1, 0, 0));
                break;
            case CENTER:
                //Initial movement:
                mergi(100, new Pose2d(0.7, 0, 0));
                robot.drive.turn(Math.toRadians(-55));
                robot.sweeper.levelTwo();
                mergi(300, new Pose2d(0.7, 0, 0));
                mergi(1000, new Pose2d(0, 0, 0));

                //Deploy freight:
                robot.sweeper.outtake();
                mergi(2000, new Pose2d(0, 0, 0));
                robot.sweeper.stopSweep();
                robot.sweeper.resetCuva();

                //Parking:
                robot.drive.turn(Math.toRadians(160));
                mergi(750, new Pose2d(1, 0, 0));
                break;
            case RIGHT:
                //Initial movement:
                mergi(100, new Pose2d(0.7, 0, 0));
                robot.drive.turn(Math.toRadians(-55));
                mergi(100, new Pose2d(0.7, 0, 0));
                robot.drive.turn(Math.toRadians(-200));
                robot.sweeper.levelThree();
                mergi(600, new Pose2d(-0.5, 0, 0));
                mergi(2000, new Pose2d(0, 0, 0));

                //Deploy freight:
                robot.sweeper.intake();
                mergi(2000, new Pose2d(0, 0, 0));
                robot.sweeper.stopSweep();
                mergi(300, new Pose2d(0.7, 0, 0));
                robot.drive.turn(Math.toRadians(-80));
                robot.sweeper.resetCuva();
                mergi(1000, new Pose2d(0, 0, 0));

                //Parking:
                mergi(700, new Pose2d(1, 0, 0));
                break;
        }
    }
}