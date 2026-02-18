package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import org.firstinspires.ftc.teamcode.Intake;

public class CustomOpModeTeleOp extends CustomOpMode{

Intake intake;


    @Override
    public void init() {

        intake = new Intake(hardwareMap, gamepad1, gamepad2);

    }

    @Override
    public void loop() {

    }
}
