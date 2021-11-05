package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipCarousel {
    private CRServo servo;
    public PrototipCarousel(HardwareMap hardwareMap){
        servo = hardwareMap.crservo.get("carousel");
        servo.setPower(0);
    }

    public void spin(){
        servo.setPower(1);
    }

    public void stopSpin(){
        servo.setPower(0);
    }
}
