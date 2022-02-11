package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.hardware.motors.TetrixMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;

public class Sweeper {
    public DcMotor motorBrat;
    public DcMotor motorSweeper;
    public DcMotorEx motorCuva;

    public Sweeper(HardwareMap hardwareMap){
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        motorCuva = hardwareMap.get(DcMotorEx.class, "motorCuva");


        motorBrat.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBrat.setTargetPosition(0);

        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorBrat.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        motorCuva.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorCuva.setTargetPosition(0);
//        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorCuva.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorCuva.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorCuva.setDirection(DcMotorSimple.Direction.REVERSE);
        motorCuva.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorSweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorSweeper.setDirection(DcMotorSimple.Direction.REVERSE);
        motorSweeper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void intake(){
        motorSweeper.setPower(1);
    }
    public void outtake(){
        motorSweeper.setPower(-1);
    }
    public void sweepIn() { motorSweeper.setPower(0.7); }
    public void sweepOut() { motorSweeper.setPower(-0.5); }
    public void stopSweep(){ motorSweeper.setPower(0); }

//    public void ridicaBrat(double speed){
//        motorBrat.setPower(Math.min(speed, 1));
//    }
//
//    public void coboaraBrat(double speed){
//        motorBrat.setPower(Math.max(-speed, -1));
//    }
//
//    public void stopBrat(){
//        motorBrat.setPower(0);
//    }

    public void bratUp(){
        motorBrat.setTargetPosition(1200);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(0.9);
    }

    public void bratDown(){
        motorBrat.setTargetPosition(10);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.2);
    }

    public void levelOne(){
        motorCuva.setTargetPosition(-130);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setPower(-0.5);

        motorBrat.setTargetPosition(15);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.2);
    }

    public void levelTwo(){
        motorCuva.setTargetPosition(-340);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(motorCuva.getCurrentPosition() > -340)
            motorCuva.setPower(-0.5);
        else motorCuva.setPower(0.5);

        motorBrat.setTargetPosition(15);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.2);
    }

    public void levelThree(){
        motorCuva.setTargetPosition(-450);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setPower(-0.5);

        motorBrat.setTargetPosition(1200);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(1);
    }

    public void resetCuva() {
        motorCuva.setTargetPosition(0);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setPower(0.5);

        motorBrat.setTargetPosition(0);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.2);
    }

    public void ridicaCuva() {
        motorCuva.setPower(0.5);
    }
    public void coboaraCuva() {
        motorCuva.setPower(-0.5);
    }
    public void stopCuva(){
        motorCuva.setPower(0);
    }
}