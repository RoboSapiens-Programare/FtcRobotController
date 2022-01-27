package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.subsystems.PrototipSweeper;

public class Robot {
    private  boolean initialize;
    public PrototipSweeper prototipSweeper;
//    public PrototipCarousel prototipCarousel;
//    public PrototipBrat prototipBrat;
//    public MecanumDriveCh drive;
//    public SweeperBoboci sweeperBoboci;

    public Robot (HardwareMap hardwareMap){
        initialize = true;
        prototipSweeper = new PrototipSweeper(hardwareMap);
//        prototipCarousel = new PrototipCarousel(hardwareMap);
//        prototipBrat = new PrototipBrat(hardwareMap);
//        drive = new MecanumDriveCh(hardwareMap);
//        sweeperBoboci = new SweeperBoboci(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}

