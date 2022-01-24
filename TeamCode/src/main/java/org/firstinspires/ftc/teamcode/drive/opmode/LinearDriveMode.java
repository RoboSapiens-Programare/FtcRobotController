package org.firstinspires.ftc.teamcode.drive.opmode;

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

            if(gamepad2.a){
                robot.prototipSweeper.autoRidicare();
            }

            if(gamepad2.dpad_up){
                robot.prototipSweeper.ridicaLevel();
            }

            if(gamepad2.dpad_down){
                robot.prototipSweeper.coboaraLevel();
            }

            if(gamepad2.b){
                robot.prototipSweeper.autoCoborare();
            }

            if(gamepad1.left_bumper){
                robot.prototipSweeper.sweepIn();
            }

            if(gamepad1.right_bumper){
                robot.prototipSweeper.sweepOut();
            }

//            Carousel:
//
//            if(gamepad2.dpad) robot.prototipCarousel.spin();
//            else robot.prototipCarousel.stopSpin();
//
//            Drive:
//
//            robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x));
        }
    }
}
