package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BobociCh {
    private DcMotor motorStanga, motorDreapta;

    public BobociCh(HardwareMap hardwareMap) {
        this.motorStanga = hardwareMap.dcMotor.get("motorStanga");
        this.motorDreapta = hardwareMap.dcMotor.get("motorDreapta");

        motorStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorStanga.setDirection(DcMotorSimple.Direction.FORWARD);

        motorDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorDreapta.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setMotorPowers(double speedStanga, double speedDreapta){
        motorStanga.setPower(speedStanga);
        motorDreapta.setPower(speedDreapta);
    }
}
