package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.hardware.motors.GoBILDA5202Series;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Carousel {
    private DcMotor carousel;
    public Carousel(HardwareMap hardwareMap){
        carousel = hardwareMap.dcMotor.get("carousel");

        carousel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        carousel.setDirection(DcMotorSimple.Direction.FORWARD);
        carousel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void spin(){
        carousel.setPower(-1);
    }

    public void stopSpin(){
        carousel.setPower(0);
    }
}
