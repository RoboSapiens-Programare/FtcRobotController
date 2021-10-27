package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsAnalogOpticalDistanceSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cCompassSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cIrSeekerSensorV3;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "tewt encodewr")
public class TestEncoderMotorTetrix extends LinearOpMode {
//    private ModernRoboticsTouchSensor touchSensor;
//    private DistanceSensor distanceSensor;
//    private ColorSensor colorSensor;
//    private ModernRoboticsI2cIrSeekerSensorV3 modernRoboticsI2cIrSeekerSensorV3;
//    private ModernRoboticsI2cGyro gyroSensor;
//    private ModernRoboticsAnalogOpticalDistanceSensor ods;
//    private ModernRoboticsI2cCompassSensor compassSensor;
    private ModernRoboticsI2cRangeSensor range;
    @Override
    public void runOpMode() throws InterruptedException {
        //distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
//        touchSensor = hardwareMap.get(ModernRoboticsTouchSensor.class, "touchSensor");
        //colorSensor = hardwareMap.get(ColorSensor.class, "coloSensor");
        //modernRoboticsI2cIrSeekerSensorV3 = hardwareMap.get(ModernRoboticsI2cIrSeekerSensorV3.class, "irSeeker");
        //gyroSensor = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyroSensor");
        //ods = hardwareMap.get(ModernRoboticsAnalogOpticalDistanceSensor.class, "ods");
//        compassSensor = hardwareMap.get(ModernRoboticsI2cCompassSensor.class, "compass");
        range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "range");

        waitForStart();
            if (isStopRequested()) return;

        while (opModeIsActive()){
            //telemetry.addData("range sensor: ", distanceSensor.getDistance(DistanceUnit.CM));
            //telemetry.addData("range sensor: ", touchSensor.getValue());
            //telemetry.addData("color", colorSensor.red());
//            telemetry.addData("Ma atingi Costica?", touchSensor.isPressed());
            //telemetry.addData("ir: ", modernRoboticsI2cIrSeekerSensorV3.getStrength());
            //telemetry.addData("gyro: ", gyroSensor.getHeading());
//            telemetry.addData("ods light: ", ods.getLightDetected());
//            telemetry.addData("ods raw light: ", ods.getRawLightDetected());
//            telemetry.addData("ods maxvoltage: ", ods.getMaxVoltage());
//            telemetry.addData("ods raw light max: ", ods.getRawLightDetectedMax());
//              telemetry.addData("compass: ", compassSensor.getMagneticFlux());

            telemetry.addData("range ultrasonic: ", range.rawUltrasonic());
            telemetry.addData("range ultrasonic cm : ", range.cmUltrasonic());
            telemetry.addData("range light: ", range.rawOptical());
            telemetry.addData("range light cm: ", range.cmOptical());

            telemetry.update();
        }
    }
}
