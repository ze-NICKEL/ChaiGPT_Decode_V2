package org.firstinspires.ftc.teamcode.ShooterSystems.ShooterTuners;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ShooterSystems.Goal;
import org.firstinspires.ftc.teamcode.ShooterSystems.Turret;


@TeleOp(name="TURRET PID", group="tuners")
@Config
public class TurretPID extends OpMode {


    double kp, ki, kd;

    Turret turret;

    Pose initialPose = new Pose(0,0,0);

    Pose targetPose = new Pose(50, 50);

    Telemetry telemetry;

    Goal.ALLIANCE alliance = Goal.ALLIANCE.BLUE;


    Goal goal = new Goal(alliance);




    @Override
    public void init() {

        turret = new Turret(hardwareMap, initialPose,goal );

        telemetry = new MultipleTelemetry(super.telemetry, FtcDashboard.getInstance().getTelemetry());

    }

    @Override
    public void loop() {

        turret.setPIDFCoefficients(kp, ki, kd);
        turret.update();

        telemetry.addData("X: ", turret.currentX);

        telemetry.addData("Y: ", turret.currentY);

        telemetry.addData("TargetX: ", turret.targetX);
        telemetry.addData("targetY: ", turret.targetY);




    }
}
