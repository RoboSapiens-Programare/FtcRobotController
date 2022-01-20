//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.imgproc.Imgproc;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraFactory;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//import org.openftc.easyopencv.OpenCvPipeline;
//
//@TeleOp
//public class CoiSauCub extends LinearOpMode {
//    OpenCvCamera webcam;
//    SamplePipeline pipeline;
//
//    @Override
//    public void runOpMode() {
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
//
//        pipeline = new SamplePipeline();
//        webcam.setPipeline(pipeline);
//
//
//        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
//        {
//            @Override
//            public void onOpened()
//            {
//                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
//            }
//
//            @Override
//            public void onError(int errorCode)
//            {
//
//            }
//        });
//        waitForStart();
//
//        while (opModeIsActive()) {
//            telemetry.addData("Type", pipeline.getType());
//            telemetry.addData("Average", pipeline.getAverage());
//            telemetry.update();
//            sleep(50);
//        }
//    }
//
//    public static class SamplePipeline extends OpenCvPipeline {
//        private static final Scalar BLUE = new Scalar(0, 0, 255);
//        Point topLeft = new Point(50, 50);
//        Point bottomRight = new Point(100, 100);
//
//        private static final int THRESHHOLD = 107;
//        Mat region;
//        Mat YCrCb;
//        Mat Cb = new Mat();
//        private volatile int average;
//
//        private void inputToCb(Mat input){
//            Impgroc.cvtColor(input, YCrCb, Imgproc)
//        }
//        @Override
//        public Mat processFrame(Mat input) {
//
//        }
//    }
//}