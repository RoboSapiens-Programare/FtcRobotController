package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.subsystems.MecanumDriveCh;
import org.firstinspires.ftc.teamcode.drive.subsystems.PrototipCarousel;
import org.firstinspires.ftc.teamcode.drive.subsystems.PrototipSweeper;

public class Robot {
    private  boolean initialize;
    public PrototipSweeper prototipSweeper;
    public PrototipCarousel prototipCarousel;
    public MecanumDriveCh drive;

    public Robot (HardwareMap hardwareMap){
        initialize = true;
        prototipSweeper = new PrototipSweeper(hardwareMap);
        prototipCarousel = new PrototipCarousel(hardwareMap);
        drive = new MecanumDriveCh(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}

