package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipBrat {
    private DcMotor motorBrat;
    private Servo servoBrat;
    private Servo servoGheara;

    public PrototipBrat(HardwareMap hardwareMap) {
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        servoBrat = hardwareMap.servo.get("servoBrat");
        servoGheara = hardwareMap.servo.get("servoGheara");

        motorBrat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBrat.setPosition(1);

        servoGheara.setPosition(1);
    }

    public void miscaFata(double speed) {
        motorBrat.setPower(Math.min(speed, 0.9));
    }

    public void miscaSpate(double speed) {
        motorBrat.setPower(Math.max(-speed, -0.9));
    }

    public void stop() {
        motorBrat.setPower(0);
    }

    public void ridicaBrat() {
        servoBrat.setPosition(0);
    }

    public void coboaraBrat() {
        if(servoBrat.getPosition()==0.5) {
            servoBrat.setPosition(1);
        }
        else
            servoBrat.setPosition(0.5);
    }

    public void inchideGheara() {
        servoGheara.setPosition(1);
    }

    public void deschideGheara() {
        servoGheara.setPosition(0);
    }
}