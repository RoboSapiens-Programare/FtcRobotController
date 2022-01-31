package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;

public class Sweeper {
    public DcMotor motorBrat;
    public DcMotor motorSweeper;
    public Servo servoBrat;
    public Servo servoBrat2;

    public Sweeper(HardwareMap hardwareMap){
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        servoBrat = hardwareMap.servo.get("servoBrat");
        servoBrat2 = hardwareMap.servo.get("servoBrat2");

        motorBrat.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorSweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorSweeper.setDirection(DcMotorSimple.Direction.FORWARD);
        motorSweeper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBrat.setPosition(0);
        servoBrat2.setPosition(1);
    }

    public void sweep(){
        motorSweeper.setPower(1);
    }
    public void stopSweep(){
        motorSweeper.setPower(0);
    }

    public void ridicaCuva(){
        servoBrat.setPosition(0.7);
        servoBrat2.setPosition(0.3);
    }
    public void stopServo(){
        servoBrat.setPosition(0);
        servoBrat2.setPosition(1);
    }


    public void ridicaBrat(double speed){
        motorBrat.setPower(Math.min(speed, 0.5));
    }

    public void coboaraBrat(double speed){
        motorBrat.setPower(Math.max(-speed, -0.5));
    }

    public void stopBrat(){
        motorBrat.setPower(0);
    }





    public void autoRidicare(){
        motorBrat.setTargetPosition(420 * 1);
        servoBrat.setPosition(0.7);
        servoBrat2.setPosition(0.3);
    }

    public void  coboaraLevel(){
        servoBrat.setPosition(Math.max(servoBrat.getPosition() + 0.2, 1));
        servoBrat2.setPosition(Math.max(servoBrat2.getPosition() - 0.2, 0));
    }

    public void ridicaLevel(){
        servoBrat.setPosition(Math.max(servoBrat.getPosition() - 0.2, 0));
        servoBrat2.setPosition(Math.max(servoBrat2.getPosition() + 0.2, 1));
    }

    public void autoCoborare(){
        motorBrat.setTargetPosition(0);
        servoBrat.setPosition(0);
        servoBrat2.setPosition(1);
    }
}
