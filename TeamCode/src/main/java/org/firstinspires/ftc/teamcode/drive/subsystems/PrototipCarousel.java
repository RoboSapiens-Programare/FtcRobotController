package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipCarousel {
//    private Servo servo;
//    private Servo servoTest;
    private CRServo servo;
    private CRServo servoTest;
    public PrototipCarousel(HardwareMap hardwareMap){
        servo = hardwareMap.crservo.get("carousel");
        servoTest = hardwareMap.crservo.get("test");
        servo.setPower(0.5); //supposed to stop the servo
        servoTest.setPower(0.5);

//        servo = hardwareMap.servo.get("carousel");
//        servo.setPosition(0);

//        servoTest = hardwareMap.servo.get("test");
//        servoTest.setPosition(0.5);
    }

    public void spin(){
//        servo.setPosition(1);
//        servoTest.setPosition(1);
        servo.setPower(1);
        servoTest.setPower(1);
    }

    public void stopSpin(){
//        servo.setPosition(0);
//        servoTest.setPosition(0);
        servo.setPower(0);
        servoTest.setPower(0);
    }
}
