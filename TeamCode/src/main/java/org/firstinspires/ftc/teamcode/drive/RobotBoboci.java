package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.subsystems.BobociCh;

public class RobotBoboci {
    private  boolean initialize;
    public BobociCh drive;

    public RobotBoboci (HardwareMap hardwareMap){
        initialize = true;
        drive = new BobociCh(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}
