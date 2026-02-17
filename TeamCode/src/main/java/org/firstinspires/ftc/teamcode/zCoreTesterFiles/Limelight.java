package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Util.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

import dev.nextftc.ftc.ActiveOpMode;

public class Limelight {
    Limelight3A limelight3A;

    LLResult result;


    Pose currentPose = new Pose(0,0,0);



    public Limelight(@NonNull HardwareMap hardwareMap) {
        this.limelight3A = hardwareMap.get(Limelight3A.class, Constants.CoreTesterConstants.LimelightCameraName);

    }



    public void updateLimelightResults() {
        result = limelight3A.getLatestResult();

        //currentPose = result.getBotPose();
    }
}