package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;

public class Sweeper {
    public DcMotor motorBrat;
    public DcMotor motorSweeper;
    public DcMotor motorCuva;

    public Sweeper(HardwareMap hardwareMap){
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        motorCuva = hardwareMap.dcMotor.get("motorCuva");


        motorBrat.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBrat.setTargetPosition(0);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorBrat.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorCuva.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorCuva.setTargetPosition(0);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setDirection(DcMotorSimple.Direction.FORWARD);
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
    public void stopSweep(){
        motorSweeper.setPower(0);
    }

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

    public void levelOne(){
        motorCuva.setTargetPosition(200);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setPower(-0.75);

        motorBrat.setTargetPosition(0);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.75);
    }

    public void levelTwo(){
        motorCuva.setTargetPosition(400);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(motorCuva.getCurrentPosition() > 400)
            motorCuva.setPower(-0.75);
        else motorCuva.setPower(0.75);

        motorBrat.setTargetPosition(0);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(-0.75);
    }

    public void levelThree(){
        motorCuva.setTargetPosition(200);
        motorCuva.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorCuva.setPower(0.75);

        motorBrat.setTargetPosition(1000);
        motorBrat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBrat.setPower(0.75);
    }
}