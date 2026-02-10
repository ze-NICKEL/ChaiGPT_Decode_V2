package org.firstinspires.ftc.teamcode.pedroPathing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutonTuner extends OpMode {
        Pose currentPose;

        Telemetry telemetry;

Follower follower;

PathChain normalPath;
double currX = 0, currY = 0;
public static double goToX = 0;

public static double goToY = 0;


    @Override
    public void init() {
        follower = PPConstants.createAutoFollower(hardwareMap);

        telemetry = new MultipleTelemetry(super.telemetry, FtcDashboard.getInstance().getTelemetry());
        follower.update();
    }

    @Override
    public void loop() {

        currentPose = follower.getPose();
        currX = currentPose.getX();
        currY = currentPose.getY();


        normalPath = follower.pathBuilder().addPath(
                new BezierLine(
                        new Pose(currX, currY),
                        new Pose(goToX, goToY)

                )
        ).build();


        follower.followPath(normalPath);

    }
}
