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

        servoBrat.setPosition(0.125);
    }

    public void sweepFata(){
        motorSweeper.setPower(0.9);
    }
    public void sweepSpate(){
        motorSweeper.setPower(-0.9);
    }
    public void stopSweep(){
        motorSweeper.setPower(0);
    }

    public void coboaraBrat(){
        servoBrat.setPosition(0.125);
    }
    public void ridicaBrat(){
        servoBrat.setPosition(0.95);
    }
    public void stopServo(){
        servoBrat.setPosition(servoBrat.getPosition());
    }

    public void bratFata(double speed){
        motorBrat.setPower(Math.min(speed, 0.9));
    }public void bratSpate(double speed){
        motorBrat.setPower(Math.min(-speed, 0.9));
    }public void stopBrat(){
        motorBrat.setPower(0);
    }
}
