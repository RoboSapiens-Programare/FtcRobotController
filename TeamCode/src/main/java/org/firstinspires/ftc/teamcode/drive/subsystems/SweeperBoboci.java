package org.firstinspires.ftc.teamcode.drive.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SweeperBoboci {
    private Servo servoBrat;
    private Servo servoBrat2;
    private DcMotor motorBrat;
    private DcMotor motorSweeper;
    private int ticks;

    public SweeperBoboci(HardwareMap hardwareMap){
        servoBrat = hardwareMap.servo.get("servoBrat");
        servoBrat2 = hardwareMap.servo.get("servoBrat2");
        motorBrat = hardwareMap.dcMotor.get("motorBrat");
        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");

        motorBrat.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBrat.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBrat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorSweeper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorSweeper.setDirection(DcMotorSimple.Direction.FORWARD);
        motorSweeper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoBrat.setPosition(0.7);
        servoBrat2.setPosition(0.3);
    }

    public void ridicaBrat() {
        servoBrat.setPosition(0.9);
        servoBrat2.setPosition(0.1);
    }

    public void coboaraBrat() {
        if(servoBrat.getPosition()==0.7) {
            servoBrat.setPosition(0.1);
            servoBrat2.setPosition(0.9);
        }
        else{
            servoBrat.setPosition(0.7);
            servoBrat2.setPosition(0.3);
        }
    }

    // TODO: AFLAT NR TICK-URI PT RIDICARE
    public void ridicaAutomat(){
        ticks = motorBrat.getCurrentPosition();
        while(ticks <=  ) {
            motorBrat.setPower(0.5);
            ticks = motorBrat.getCurrentPosition();
        }
        ridicaBrat();

    }
    public void aspirare(double speed){
        motorSweeper.setPower(0.9);
    }
    public void evacuare(double speed){
        motorSweeper.setPower(-0.9);
    }
}
