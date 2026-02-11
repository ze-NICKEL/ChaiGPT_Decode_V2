package org.firstinspires.ftc.teamcode.ShooterTuners;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ShooterSystems.ExtremeNikhilFlywheel;


@Config

@TeleOp(name = "FLYWHEEL PID TUNER", group = "tuning")
public class FlywheelPID extends OpMode {
    ExtremeNikhilFlywheel flywheel;


    Pose initialPose = new Pose(0,0,Math.toRadians(270));


    @Override
    public void init() {

        flywheel = new ExtremeNikhilFlywheel(hardwareMap, initialPose);

    }

    @Override
    public void loop() {

        flywheel.update();

    }
}
