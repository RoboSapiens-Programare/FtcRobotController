package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.RobotBoboci;

@TeleOp(group = "driver")

public class BobociTest extends LinearOpMode {
    private RobotBoboci robot = null;
    private final double STICK_TRESHOLD = 0.1;
    int isGoingForward = 1;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new RobotBoboci(hardwareMap);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()){
            //Key bindings:

//todo        STICK MOVEMENT:

//            if(gamepad1.left_stick_y >= STICK_TRESHOLD || gamepad1.left_stick_y <= -STICK_TRESHOLD) robot.drone.gogogo(gamepad1.left_stick_y);
//            else robot.drone.stop();
//            if(gamepad1.right_stick_x >= STICK_TRESHOLD || gamepad1.right_stick_x <= -STICK_TRESHOLD) robot.drone.turn(gamepad1.right_stick_x);
//            else robot.drone.stop();

//            telemetry.addData("Left stick value:", gamepad1.left_stick_y);
//            telemetry.addData("Right stick value:", gamepad1.right_stick_x);
//            telemetry.update();


//todo        DPAD MOVEMENT:

//            if(gamepad1.dpad_up) robot.drone.forward();
//            else if(gamepad1.dpad_down) robot.drone.backward();
//            else if(gamepad1.dpad_left) robot.drone.left();
//            else if(gamepad1.dpad_right) robot.drone.right();
//            else robot.drone.stop();


//todo        STICK MOVEMENT++:
//            if(gamepad1.left_stick_y > 0){
//                isGoingForward = 1;
//
//            }
//            if(gamepad1.left_stick_y < 0){
//                isGoingForward = -1;
//            }
//
//            if(gamepad1.right_stick_x > STICK_TRESHOLD){
//                robot.drone.setMotorPowers(-gamepad1.right_stick_x, -0.5 + gamepad1.right_stick_x);
//            }
//            else if(gamepad1.right_stick_x < STICK_TRESHOLD){
//                robot.drone.setMotorPowers(gamepad1.right_stick_x, 0.5 - gamepad1.right_stick_x);
//            }else robot.drone.stop();

            if(gamepad1.left_stick_y < -0.2 || gamepad1.left_stick_y > 0.2) robot.drone.putereStanga(gamepad1.left_stick_y);
            if(gamepad1.right_stick_y < -0.2 || gamepad1.right_stick_y > 0.2) robot.drone. putereDreapta(gamepad1.right_stick_y);
            else if(gamepad1.left_stick_y >= -0.2 && gamepad1.left_stick_y <= 0.2 && gamepad1.right_stick_y >= -0.2 && gamepad1.right_stick_y <= 0.2)   robot.drone.stop();


        }
    }
}
