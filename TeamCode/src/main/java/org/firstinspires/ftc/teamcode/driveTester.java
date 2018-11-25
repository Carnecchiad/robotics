package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class driveTester extends OpMode {

    //Hardware declaration
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private ElapsedTime runtime = new ElapsedTime();

    private GoldDetector goldDetector = null;

    @Override
    public void init() {

        //Hardware mapping
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        goldDetector = new GoldDetector();
        goldDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());

        goldDetector.enable();

        telemetry.addData("status","initialized");
        telemetry.update();

        //Wait for driver to press START

        runtime.reset();
        //Run until driver presses STOP
    }

    @Override
    public void loop() {
        rightMotor.setPower(gamepad1.right_stick_y);
        leftMotor.setPower(-gamepad1.left_stick_y);
        telemetry.addData("status", "Run Time: " + runtime);
        telemetry.update();
    }
}

