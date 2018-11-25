package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoTest extends OpMode {

    private CRServo servo;

    @Override
    public void init() {

        servo = hardwareMap.get(CRServo.class, "servo");

        telemetry.addData("status", "initialized");
        telemetry.update();


    }

    @Override
    public void loop() {

        if(gamepad1.right_trigger > 0 && gamepad1.left_trigger == 0) {
            servo.setPower(gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger > 0 && gamepad1.right_trigger == 0){
            servo.setPower(-gamepad1.left_trigger);
        }

        telemetry.addData("status", "running");
        telemetry.update();
    }
}
