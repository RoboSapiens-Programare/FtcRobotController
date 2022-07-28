package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.subsystems.BratAspirator;
import org.firstinspires.ftc.teamcode.drive.subsystems.MecanumDriveCh;
import org.firstinspires.ftc.teamcode.drive.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.drive.subsystems.Sweeper;

public class Roomba {
    private  boolean initialize;
    public MecanumDriveCh drive;
    public BratAspirator bratAspirator;

    public Roomba (HardwareMap hardwareMap){
        initialize = true;
        drive = new MecanumDriveCh(hardwareMap);
        bratAspirator = new BratAspirator(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}

