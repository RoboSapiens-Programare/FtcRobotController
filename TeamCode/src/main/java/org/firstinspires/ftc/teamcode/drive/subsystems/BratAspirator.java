package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BratAspirator {
    private DcMotor motorAspirator;

    public BratAspirator(HardwareMap hardwareMap) {
        motorAspirator = hardwareMap.dcMotor.get("motorBrat");

        //Motor initialization
        motorAspirator.setTargetPosition(0);
        motorAspirator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorAspirator.setDirection(DcMotorSimple.Direction.FORWARD);
        motorAspirator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void aspiratorJos() {
        motorAspirator.setTargetPosition(1232);
        motorAspirator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorAspirator.setPower(0.5);
//        while(motorAspirator.isBusy());
//        motorAspirator.setPower(0);
//        motorAspirator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void aspiratorSus() {
        motorAspirator.setTargetPosition(0);
        motorAspirator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorAspirator.setPower(-0.5);
    }

    public void stopBratAspirator(){
        motorAspirator.setPower(0);
    }
}