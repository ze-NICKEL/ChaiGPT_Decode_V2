package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.ftc.localization.localizers.PinpointLocalizer;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

public class CoreTester {

    PinpointLocalizer localizer;

    Follower follower;

    Pose initialPose = new Pose(10,10,10);


    public CoreTester(@NonNull HardwareMap hardwareMap) {
        this.localizer = new PinpointLocalizer(hardwareMap, PPConstants.localizerConstants, new Pose(0,0));

    }

    public CoreTester(@NonNull HardwareMap hardwareMap, Pose initialPose) {
        this.follower = PPConstants.createTeleOpFollower(hardwareMap);

        this.initialPose = initialPose;
    }



    public Pose testUnaryMinus() {
          return initialPose.unaryMinus();
    }




}
