package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "FirstClass")
public class FirstClass extends OpMode {

    //stores the values of the speeds the motor has to move at in this order: LF, LB, RF, RB
    double[] motorSpeeds = new double[4];
    double maxSpeed = 1;
    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        rightBack = hardwareMap.get(DcMotor.class, "rb");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {

        motorSpeeds = MDT.Mecanum(maxSpeed, gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, 0);
        leftFront.setPower(motorSpeeds[0]);leftBack.setPower(motorSpeeds[1]);rightFront.setPower(motorSpeeds[2]);rightBack.setPower(motorSpeeds[3]);

    }
}
