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

//            Prototip Brat:
//
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

//            Prototip Sweeper:

//            if(gamepad2.left_trigger > 0) robot.prototipSweeper.bratFata(gamepad2.left_trigger);
//            else if (gamepad2.right_trigger > 0) robot.prototipSweeper.bratSpate(gamepad2.right_trigger);
//            else robot.prototipSweeper.stopBrat();
//
//            if(gamepad2.left_bumper) robot.prototipSweeper.sweepFata();
//            else if(gamepad2.right_bumper) robot.prototipSweeper.sweepSpate();
//            else robot.prototipSweeper.stopSweep();

//            if (gamepad2.a) robot.prototipSweeper.ridicaBrat();
//            else robot.prototipSweeper.stopServo();

//              Carousel:
//
//            if(gamepad2.b) robot.prototipCarousel.spin();
//            else robot.prototipCarousel.stopSpin();

//            Drive:

//            robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, gamepad1.left_stick_x, -gamepad1.right_stick_x));


//            Sweeeper boboci

//            if(gamepad2.y)
//                robot.sweeperBoboci.ridicaBrat();
//            if(gamepad2.a)
//                robot.sweeperBoboci.coboaraBrat();

        }
    }
}
