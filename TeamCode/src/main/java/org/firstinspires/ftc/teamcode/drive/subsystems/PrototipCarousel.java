package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrototipCarousel {
    private Servo servo;

    public PrototipCarousel(HardwareMap hardwareMap){
        servo = hardwareMap.servo.get("carousel");
        servo.setPosition(0);
    }
}
