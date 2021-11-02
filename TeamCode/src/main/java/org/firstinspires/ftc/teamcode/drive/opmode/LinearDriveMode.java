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

//            Prototip Brat:

//            if (gamepad1.a) {
//                robot.prototipBrat.ridicaBrat();
//            }
//
//            if (gamepad1.y) {
//                robot.prototipBrat.coboaraBrat();
//            }
//
//            if (gamepad1.left_trigger > 0)
//                robot.prototipBrat.miscaFata(gamepad1.left_trigger);
//            else if (gamepad1.right_trigger > 0)
//                robot.prototipBrat.miscaSpate(gamepad1.right_trigger);
//            else {
//                robot.prototipBrat.stop();
//            }
//
//            if(gamepad1.x) {
//                robot.prototipBrat.inchideGheara();
//            }
//            if(gamepad1.b) {
//                robot.prototipBrat.deschideGheara();
//            }
//
            if(gamepad2.left_trigger > 0) robot.prototipSweeper.miscaFata(gamepad2.left_trigger);
            else if (gamepad2.right_trigger > 0) robot.prototipSweeper.miscaSpate(gamepad2.right_trigger);
            else robot.prototipSweeper.stop();

            if(gamepad2.left_bumper) robot.prototipSweeper.sweepFata();
            else if(gamepad2.right_bumper) robot.prototipSweeper.stopSweep();
            else robot.prototipSweeper.stopSweep();

            if (gamepad1.a) robot.prototipSweeper.ridicaBrat();
            if (gamepad1.y) robot.prototipSweeper.coboaraBrat();
            else robot.prototipSweeper.stopServo();

            robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x));
        }
    }
}
