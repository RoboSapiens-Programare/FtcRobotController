package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Carousel {
    private DcMotor carousel;
    public Carousel(HardwareMap hardwareMap){
        carousel = hardwareMap.dcMotor.get("carousel");

        //Motor initialization
        carousel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        carousel.setDirection(DcMotorSimple.Direction.FORWARD);
        carousel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void spin(){
        carousel.setPower(-0.55);
    }

    public void reverseSpin(){
        carousel.setPower(0.55);
    }

    public void stopSpin(){
        carousel.setPower(0);
    }
}
