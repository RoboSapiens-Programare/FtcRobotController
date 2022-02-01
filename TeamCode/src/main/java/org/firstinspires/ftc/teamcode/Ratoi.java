package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

public class Ratoi extends OpenCvPipeline {
        Telemetry telemetry;
        Mat mat = new Mat();
        public enum Location {
            LEFT,
            CENTER,
            RIGHT,
            NOT_FOUND
        }
        private Location location;

        static final Rect LEFT_ROI = new Rect(
            new Point(0, 0),
            new Point()
        )

        @Override
        public Mat processFrame(Mat input) {

        }
    }
}