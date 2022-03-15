package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.RobotBoboci;

@TeleOp(group = "driver")
public class BobociTest extends LinearOpMode {
    private RobotBoboci robotBoboci = null;
    private final double STICK_TRESHOLD = 0.1;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robotBoboci = new RobotBoboci(hardwareMap);

        while (robotBoboci.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
//            if(gamepad1.left_stick_y >= STICK_TRESHOLD || gamepad1.left_stick_y <= -STICK_TRESHOLD)
//                robotBoboci.drive.setMotorPowers(gamepad1.left_stick_y, -gamepad1.left_stick_y);
//
//            if(gamepad1.right_stick_x >= STICK_TRESHOLD)
//                robotBoboci.drive.setMotorPowers(gamepad1.right_stick_x, 2 * (-0.5 + gamepad1.right_stick_x));
//            else if(gamepad1.right_stick_x <= STICK_TRESHOLD)
//                robotBoboci.drive.setMotorPowers(2 * (0.5 + gamepad1.right_stick_x), gamepad1.right_stick_x);
//            else robotBoboci.drive.setMotorPowers(0, 0);

            robotBoboci.drive.setMotorPowers(
                    (gamepad1.left_stick_y + ((Math.abs(gamepad1.right_stick_x) - 0.5) * 2)) / 2,
                    (gamepad1.left_stick_y + ((Math.abs(gamepad1.right_stick_x) - 0.5) * 2)) / 2);

        }
    }
}
