package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Odometrie {
    public Servo servoPerpendicular;
    public Servo servoParalel;

    public Odometrie(HardwareMap hardwareMap) {
        servoParalel = hardwareMap.servo.get("servoParalel");
        servoPerpendicular = hardwareMap.servo.get("servoPerpendicular");

        servoParalel.setPosition(1);
        servoPerpendicular.setPosition(1);
    }

    public void ridicaRoti() {
        servoParalel.setPosition(0.7);
        servoPerpendicular.setPosition(0);
    }

    public void coboaraRoti() {
        servoParalel.setPosition(0);
        servoPerpendicular.setPosition(0.7);
    }

}
