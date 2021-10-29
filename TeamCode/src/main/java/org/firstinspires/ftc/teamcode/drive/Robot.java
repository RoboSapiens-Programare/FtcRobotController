package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.subsystems.MecanumDriveCh;
import org.firstinspires.ftc.teamcode.drive.subsystems.PrototipBrat;

public class Robot {
    private  boolean initialize;
    //public PrototipBrat prototipBrat;
    public MecanumDriveCh drive;

    public Robot (HardwareMap hardwareMap){
        initialize = true;
        //prototipBrat = new PrototipBrat(hardwareMap);
        drive = new MecanumDriveCh(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}

