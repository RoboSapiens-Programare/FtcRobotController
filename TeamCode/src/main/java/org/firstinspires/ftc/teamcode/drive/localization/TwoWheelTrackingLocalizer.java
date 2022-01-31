//package org.firstinspires.ftc.teamcode.drive.localization;
//
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.acmerobotics.roadrunner.localization.TwoTrackingWheelLocalizer;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.util.Encoder;
//import org.jetbrains.annotations.NotNull;
//
//import java.sql.Array;
//import java.util.Arrays;
//import java.util.List;
//
//public class TwoWheelTrackingLocalizer extends TwoTrackingWheelLocalizer {
//    public static double TICKS_PER_REV = 1024;
//    public static double WHEEL_RADIUS = 0.8; // in
//    public static double GEAR_RATIO = 1; // output (wheel) speed / input (encoder) speed
//
//    public static double LATERAL_DISTANCE = 10; // in; distance between the left and right wheels
//    public static double FORWARD_OFFSET = 4; // in; offset of the lateral wheel
//    public static double PARALLEL_X = 0; // X is the forward and back direction
//    public static double PARALLEL_Y = 0; // Y is the strafe direction
//
//    public static double PERPENDICULAR_X = 0; // X is the forward and back direction
//    public static double PERPENDICULAR_Y = 0; // Y is the strafe direction
//
//    private Encoder leftEncoder, frontEncoder;
//
//    public TwoWheelTrackingLocalizer(HardwareMap hardwareMap) {
//        super(Arrays.asList(
//                new Pose2d(PARALLEL_X, PARALLEL_Y, 0);              //leftEncoder
//                new Pose2d(PERPENDICULAR_X, PERPENDICULAR_Y, 0);    //frontEncoder
//        ));
//        leftEncoder = new Encoder(hardwareMap.get(DcMotorEx.class, "leftEncoder"));
//        frontEncoder = new Encoder((hardwareMap.get(DcMotorEx.class, "frontEncoder")));
//    }
//
//    @Override
//    public double getHeading() {
//        return 0;
//    }
//
//    @NotNull
//    @Override
//    public List<Double> getWheelPositions() {
//        return null;
//    }
//}
