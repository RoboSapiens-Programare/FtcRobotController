package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipSweeper {
//    private DcMotor motorBrat;
//    private DcMotor motorSweeper;
    private Servo servoBrat;
    private Servo servoBrat2;

    public PrototipSweeper(HardwareMap hardwareMap){
//        motorBrat = hardwareMap.dcMotor.get("motorBrat");
//        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        servoBrat = hardwareMap.servo.get("servoBrat");
        servoBrat2 = hardwareMap.servo.get("servoBrat2");

//        motorBrat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
//        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        motorSweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        motorSweeper.setDirection(DcMotorSimple.Direction.FORWARD);
//        motorSweeper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBrat.setPosition(0.1);
        servoBrat2.setPosition(0.9);
    }

//    public void sweepFata(){
//        motorSweeper.setPower(0.9);
//    }
//    public void sweepSpate(){
//        motorSweeper.setPower(-0.9);
//    }
//    public void stopSweep(){
//        motorSweeper.setPower(0);
//    }

    public void ridicaBrat(){
        servoBrat.setPosition(0.7);
        servoBrat2.setPosition(0.3);
    }
    public void stopServo(){
        servoBrat.setPosition(0.1);
        servoBrat2.setPosition(0.9);
    }


//    public void bratFata(double speed){
//        motorBrat.setPower(Math.min(speed, 0.9));
//    }public void bratSpate(double speed){
//        motorBrat.setPower(Math.min(-speed, 0.9));
//    }public void stopBrat(){
//        motorBrat.setPower(0);
//    }
}
