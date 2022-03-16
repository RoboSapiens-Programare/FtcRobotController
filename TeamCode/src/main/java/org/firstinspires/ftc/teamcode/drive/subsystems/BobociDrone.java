package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BobociDrone {
    private DcMotor motorStanga;
    private DcMotor motorDreapta;

    public BobociDrone(HardwareMap hardwareMap){
        motorStanga = hardwareMap.dcMotor.get("motorStanga");
        motorDreapta = hardwareMap.dcMotor.get("motorDreapta");

        motorStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorStanga.setDirection(DcMotorSimple.Direction.REVERSE);
        motorStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorDreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        motorDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//    public void gogogo(double speed){
//        motorStanga.setPower(-speed);
//        motorDreapta.setPower(speed);
//    }
//
//    public void turn(double speed){
//        motorStanga.setPower(speed);
//        motorDreapta.setPower(speed);
//    }
//
//    public void forward(){
//        motorStanga.setPower(-1);
//        motorDreapta.setPower(1);
//    }
//
//    public void backward(){
//        motorStanga.setPower(1);
//        motorDreapta.setPower(-1);
//    }
//
//    public void left(){
//        motorStanga.setPower(0);
//        motorDreapta.setPower(1);
//    }
//
//    public void right(){
//        motorStanga.setPower(-1);
//        motorDreapta.setPower(0);
//    }

    public void setMotorPowers(double speedStanga, double speedDreapta){
        motorStanga.setPower(speedStanga);
        motorDreapta.setPower(speedDreapta);
    }

    public void stop(){
        motorStanga.setPower(0);
        motorDreapta.setPower(0);
    }
}
