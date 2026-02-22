package org.firstinspires.ftc.teamcode.zCoreTesterFiles.IronCladCore;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class CustomOpModeTeleOp extends CustomOpMode{

Telemetry telemetry;
    @Override
    public void init() {
        telemetry = new MultipleTelemetry(super.telemetry, FtcDashboard.getInstance().getTelemetry());
        initializeDevices();
    }

    @Override
    public void loop() {
        loopertron();

        telemetry.addData("goal y: ", super.goal.y);
        telemetry.addData("turret target: ", super.turret.turretTurnTicks);
        telemetry.addData("flywheel target: ", super.flywheel.flywheelTargetVel);
        telemetry.addData("flywheel actual: ", super.flywheel.flywheel_current_velocity);
    }
}
