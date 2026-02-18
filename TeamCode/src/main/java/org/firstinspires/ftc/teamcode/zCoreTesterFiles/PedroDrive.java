package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import static org.firstinspires.ftc.teamcode.Util.Constants.CoreTesterConstants.BLUE_DRIVE_POSE;
import static org.firstinspires.ftc.teamcode.Util.Constants.CoreTesterConstants.RED_DRIVE_POSE;


import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.BezierPoint;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.HeadingInterpolator;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ShooterSystems.Goal;
import org.firstinspires.ftc.teamcode.Util.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

import java.util.HashMap;

import dev.nextftc.extensions.pedro.PedroDriverControlled;

public class PedroDrive {


    public Goal.ALLIANCE alliance;

    Follower follower;


    double x;
    double y;

    Pose currentPose = new Pose(0,0);

    Gamepad gamepad1;

    Gamepad gamepad2;



    public PedroDrive(@NonNull HardwareMap hardwareMap, Pose initialPose, Goal.ALLIANCE alliance, Gamepad gamepad1, Gamepad gamepad2) {

        this.alliance = alliance;

        follower = PPConstants.createTeleOpFollower(hardwareMap);

        if (alliance == Goal.ALLIANCE.BLUE) {

            this.x = BLUE_DRIVE_POSE.getX();
            this.y = BLUE_DRIVE_POSE.getY();
        }
        else {
            this.x = RED_DRIVE_POSE.getY();
            this.y = RED_DRIVE_POSE.getY();
        }

        follower.setStartingPose(initialPose);

        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    PathChain pedroDrive;


    boolean drivingToBase = false;

    public boolean driverOverride = false;

    public void update() {

        currentPose = follower.getPose();

        pedroDrive = follower.pathBuilder().addPath(
                new BezierLine(
                        new Pose(currentPose.getX(),currentPose.getY()),
                        new Pose(x,y)
                )
        ).build();

        if (gamepad2.right_bumper) {
            driveToBase();
            drivingToBase = true;
        }

        if (drivingToBase &&
                gamepad1.left_stick_x > 0 ||
                gamepad1.right_stick_x > 0 ||
                gamepad1.left_stick_y > 0 ||
                gamepad1.right_stick_y > 0
        ) {
            follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);


        }


    }


    public void driveToBase() {
        follower.followPath(pedroDrive);
    }


}
