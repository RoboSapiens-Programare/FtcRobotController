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

//            if(gamepad2.a){
//                robot.sweeper.autoRidicare();
//            }
//
//            if(gamepad2.dpad_up){
//                robot.sweeper.ridicaLevel();
//            }
//
//            if(gamepad2.dpad_down){
//                robot.sweeper.coboaraLevel();
//            }
//
//            if(gamepad2.b){
//                robot.sweeper.autoCoborare();
//            }
//
//            if(gamepad1.left_bumper){
//                robot.sweeper.sweep();
//            }
//
//            if(gamepad1.right_bumper){
//                robot.sweeper.sweep();
//            }
//            if(gamepad2.right_trigger>0)
//            {
//                robot.sweeper.ridicaBrat(gamepad2.right_trigger);
//            }
//            else if(gamepad2.left_trigger>0)
//            {
//                robot.sweeper.coboaraBrat(gamepad2.left_trigger);
//            }
//            else
//                robot.sweeper.stopBrat();
//
//            Carousel:
//
//            if(gamepad1.right_bumper) robot.carousel.spin();
//            else robot.carousel.stopSpin();
//
//            Drive:
//
            robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x));
        }
    }
}
