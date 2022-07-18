package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.opencv.core.Mat;

@Autonomous(name="ParkCarousel Blue", group = "autonomous")
public class ParkCarouselBlue extends LinearOpMode {

    private Robot robot = null;
    private ElapsedTime timer;

    public void initAutonomous() {
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
        waitForStart();

        timer = new ElapsedTime();
        timer.startTime();

        mergi(50, new Pose2d(0.4, 0, 0));

        robot.drive.turn(Math.toRadians(-5));

        mergi(800, new Pose2d(0, -0.5, 0));

        robot.carousel.startCarouselReverse();
        mergi(3000, new Pose2d(0, 0, 0));
        robot.carousel.stopCarousel();

        mergi(300, new Pose2d(0.5, 0, 0));
        mergi(400, new Pose2d(0, -0.5, 0));
    }
}
