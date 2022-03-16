package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.drive.subsystems.BobociDrone;

public class RobotBoboci {
    private boolean initialize;
    public BobociDrone drone;

    public RobotBoboci(HardwareMap hardwareMap) {
        initialize = true;
        drone = new BobociDrone(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}