package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TestCollector extends OpMode {

    private DcMotor rightMotor;
    private DcMotor leftMotor;

    @Override
    public void init() {

        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");

        telemetry.addData("status", "initialized");
        telemetry.update();


    }

    @Override
    public void loop() {

        if(gamepad1.right_trigger > 0 && gamepad1.left_trigger == 0) {
            rightMotor.setPower(-gamepad1.right_trigger);
            leftMotor.setPower(-gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger > 0 && gamepad1.right_trigger == 0){
            rightMotor.setPower(gamepad1.left_trigger);
            leftMotor.setPower(gamepad1.left_trigger);
        }

        telemetry.addData("status", "running");
        telemetry.update();
    }
}
