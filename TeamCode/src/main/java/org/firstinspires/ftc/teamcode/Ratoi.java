package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
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
        //TODO de aflat valoarea minima de galben dintr-un dreptunghi, fara ratoi
        private static final double PERCENT_COLOR_THRESHOLD = 0.2;

        public enum Location {
            LEFT,
            CENTER,
            RIGHT,
            NOT_FOUND
        }

        private Location location;

        //TODO de gasit punctele pentru dreptunghiuri
        static final Rect LEFT_ROI = new Rect(
            new Point(0, 0),
            new Point(426.6, 720)
        );

        static final Rect CENTER_ROI = new Rect(
            new Point(426.6, 0),
            new Point(853.2, 720)
        );

        static final Rect RIGHT_ROI = new Rect(
            new Point (853.2, 0),
            new Point(1280, 720)
        );

        public Ratoi(Telemetry t) { telemetry = t; }

        @Override
        public Mat processFrame(Mat input){
            Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
            Scalar lowHSV = new Scalar(23, 50, 70);
            Scalar highHSV = new Scalar(32, 255, 255);

            Core.inRange(mat, lowHSV, highHSV, mat);
            Mat left = mat.submat(LEFT_ROI);
            Mat center = mat.submat(CENTER_ROI);
            Mat right = mat.submat(RIGHT_ROI);

            double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
            double centerValue = Core.sumElems(center).val[0] / CENTER_ROI.area() / 255;
            double rightValue = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 255;

            left.release();
            center.release();
            right.release();

            telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]);
            telemetry.addData("Center raw value", (int) Core.sumElems(left).val[0]);
            telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
            telemetry.addData("Left percentage", Math.round(leftValue * 100) + "%");
            telemetry.addData("Center percentage", Math.round(centerValue * 100) + "%");
            telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

            boolean duckLeft = leftValue > PERCENT_COLOR_THRESHOLD;
            boolean duckCenter = centerValue > PERCENT_COLOR_THRESHOLD;
            boolean duckRight = rightValue > PERCENT_COLOR_THRESHOLD;

            if(duckLeft) {
                location = Location.LEFT;
                telemetry.addData("Duck Location", "left");
            }
            else if(duckCenter) {
                location = Location.CENTER;
                telemetry.addData("Duck Location", "center");
            }
            else if(duckRight) {
                location = Location.RIGHT;
                telemetry.addData("Duck Location", "right");
            }
            else {
                location = Location.NOT_FOUND;
                telemetry.addData("Duck Location", "not found");
            }
            telemetry.update();

            Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

            Scalar notRata = new Scalar(255, 0, 0);
            Scalar rata = new Scalar(0, 255, 0);

            Imgproc.rectangle(mat, LEFT_ROI, location == Location.LEFT? rata:notRata);
            Imgproc.rectangle(mat, CENTER_ROI, location == Location.CENTER? rata:notRata);
            Imgproc.rectangle(mat, RIGHT_ROI, location == Location.RIGHT? rata:notRata);

            return mat;
        }
        public Location getLocation() {
            return location;
        }

}