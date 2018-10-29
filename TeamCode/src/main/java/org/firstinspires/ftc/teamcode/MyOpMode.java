package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class MyOpMode extends OpMode {

    //Hardware declaration
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor pullMotor;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {

        //Hardware mapping
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        pullMotor = hardwareMap.get(DcMotor.class, "pullMotor");

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
        if(gamepad1.right_trigger > 0 && gamepad1.left_trigger == 0){
            pullMotor.setPower(gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger > 0 && gamepad1.right_trigger == 0){
            pullMotor.setPower(-gamepad1.left_trigger);
        }

        telemetry.addData("status", "Run Time: " + runtime);
        telemetry.update();
    }
}

