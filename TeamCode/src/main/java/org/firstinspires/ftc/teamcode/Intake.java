package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Util.Constants;
import org.firstinspires.ftc.teamcode.Util.Constants.IntakeConstants;

public class Intake {

    DcMotorEx intake;
    
    Gamepad gamepad1;

    Gamepad gamepad2;

    Servo PTOServo;





    public Intake(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {

        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;

        intake = hardwareMap.get(DcMotorEx.class, IntakeConstants.intake_motor);

        PTOServo = hardwareMap.get(Servo.class, Constants.LiftConstants.liftServoMotorName);


    }


    public void update() {
        if (gamepad1.right_bumper) {

            intake.setPower(IntakeConstants.intake_power);

        }
        else if (gamepad1.left_bumper) {
            intake.setPower(IntakeConstants.outtake_power);
        }

        else {
            intake.setPower(0);

        }
    }
}
