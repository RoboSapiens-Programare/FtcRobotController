package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipSweeper {
    private DcMotor motorBrat;
    private DcMotor motorSweeper;
    private Servo servoBrat;

    public PrototipSweeper(HardwareMap hardwareMap){
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        servoBrat = hardwareMap.servo.get("servoBrat");

        motorBrat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorSweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorSweeper.setDirection(DcMotorSimple.Direction.FORWARD);
        motorSweeper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBrat.setPosition(1);
    }

    public void sweepFata(){
        motorSweeper.setPower(0.9);
    }public void sweepSpate(){
        motorSweeper.setPower(-0.9);
    }public void stopSweep(){
        motorSweeper.setPower(0);
    }

    public void ridicaBrat(){
        servoBrat.setDirection(Servo.Direction.FORWARD);
    }public void coboaraBrat(){
        servoBrat.setDirection(Servo.Direction.REVERSE);
    }public void stopServo(){
        servoBrat.setPosition(servoBrat.getPosition());
    }

    public void miscaFata(double speed){
        motorBrat.setPower(Math.min(speed, 0.9));
    }public void miscaSpate(double speed){
        motorBrat.setPower(Math.min(-speed, 0.9));
    }public void stop(){
        motorBrat.setPower(0);
    }
}
