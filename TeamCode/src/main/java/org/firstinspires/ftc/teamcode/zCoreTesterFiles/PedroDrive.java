package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import static org.firstinspires.ftc.teamcode.Util.Constants.CoreTesterConstants.blueDriveCoords;
import static org.firstinspires.ftc.teamcode.Util.Constants.CoreTesterConstants.redDriveCoords;

import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.BezierPoint;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.HeadingInterpolator;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
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



    public PedroDrive(@NonNull HardwareMap hardwareMap, Pose initialPose, Goal.ALLIANCE alliance) {

        this.alliance = alliance;

        follower = PPConstants.createTeleOpFollower(hardwareMap);

        if (alliance == Goal.ALLIANCE.BLUE) {

            this.x = blueDriveCoords.get("x");
            this.y = blueDriveCoords.get("y");
        }
        else {
            this.x = redDriveCoords.get("x");
            this.y = redDriveCoords.get("y");
        }

        follower.setStartingPose(initialPose);
    }

    PathChain pedroDrive;


    public boolean driverOverride = false;

    public void update() {

        currentPose = follower.getPose();

        pedroDrive = follower.pathBuilder().addPath(
                new BezierLine(
                        new Pose(currentPose.getX(),currentPose.getY()),
                        new Pose(x,y)
                )
        ).build();





    }


}
