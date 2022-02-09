package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.drive.Robot;


@TeleOp(group = "driver")
public class LinearDriveMode extends LinearOpMode {
    private Robot robot = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
//            Prototip Sweeper:

            if(gamepad2.dpad_left) robot.sweeper.autoRidicare();
            if(gamepad2.dpad_right) robot.sweeper.autoCoborare();

//            if(gamepad2.y) robot.sweeper.defaultPosition();
//            else if(gamepad2.a) robot.sweeper.pickupPosition();
//            else if(gamepad2.b) robot.sweeper.midPosition();

            if(gamepad2.left_bumper) robot.sweeper.sweep(); 
            else if(gamepad2.right_bumper) robot.sweeper.reverseSweep();
            else robot.sweeper.stopSweep();

            if(gamepad2.right_trigger>0)
            {
                robot.sweeper.ridicaBrat(gamepad2.right_trigger);
            }
            else if(gamepad2.left_trigger>0)
            {
                robot.sweeper.coboaraBrat(gamepad2.left_trigger);
            }
            else
                robot.sweeper.stopBrat();

            if(gamepad2.y) robot.sweeper.ridicareCuva();
            else if(gamepad2.a) robot.sweeper.coborareCuva();
            else robot.sweeper.stopCuva();

//            Carousel:

            if(gamepad1.left_bumper) robot.carousel.spin();
            else robot.carousel.stopSpin();

//            Drive:

             robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x));
        }
    }
}
