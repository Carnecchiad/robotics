package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Autonomous")
public class Auto extends LinearOpMode {

    private DcMotor motorRight;
    private DcMotor motorLeft;

    private GoldDetector goldDetector = null;

    @Override
    public void runOpMode() throws InterruptedException
    {

    }

    public void forward(double power)
    {
        motorLeft.setPower(power);
        motorRight.setPower(power);
    }
}
