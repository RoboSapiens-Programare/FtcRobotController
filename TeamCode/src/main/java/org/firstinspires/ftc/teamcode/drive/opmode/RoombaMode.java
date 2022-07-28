package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.Roomba;

@TeleOp(group = "driver")
public class RoombaMode extends LinearOpMode {
    private Roomba robot = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Roomba(hardwareMap);
        robot.drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            if (gamepad1.y) robot.bratAspirator.aspiratorJos();
            if (gamepad1.a) robot.bratAspirator.aspiratorSus();
            if(gamepad1.right_bumper) robot.bratAspirator.stopBratAspirator();
//            Drive:
            if(gamepad1.left_bumper)
                robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y / 3,
                        -gamepad1.left_stick_x / 3, -gamepad1.right_stick_x / 4));
            else robot.drive.setDrivePower(new Pose2d(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x));
        }
    }
}
