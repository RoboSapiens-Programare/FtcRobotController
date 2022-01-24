package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipSweeper {
    private DcMotor motorBrat;
    private DcMotor motorSweeper;
    private Servo servoBrat;
    private Servo servoBrat2;

    public PrototipSweeper(HardwareMap hardwareMap){
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
//        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
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

    public void sweepIn(){
        motorSweeper.setPower(1);
    }
    public void sweepOut(){
        motorSweeper.setPower(-1);
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
        motorBrat.setPower(Math.min(speed, 0.9));
    }

    public void bratSpate(double speed){
        motorBrat.setPower(Math.min(-speed, 0.9));
    }

    public void stopBrat(){
        motorBrat.setPower(0);
    }





    public void autoRidicare(){
        motorBrat.setTargetPosition(420);
        servoBrat.setPosition(0.7);
        servoBrat2.setPosition(0.3);
    }

    public void  coboaraLevel(){
        servoBrat.setPosition(servoBrat.getPosition() + 0.2);
        servoBrat2.setPosition(servoBrat2.getPosition() - 0.2);
    }

    public void ridicaLevel(){
        servoBrat.setPosition(servoBrat.getPosition() - 0.2);
        servoBrat2.setPosition(servoBrat2.getPosition() + 0.2);
    }

    public void autoCoborare(){
        motorBrat.setTargetPosition(0);
        servoBrat.setPosition(0);
        servoBrat2.setPosition(1);
    }
}
