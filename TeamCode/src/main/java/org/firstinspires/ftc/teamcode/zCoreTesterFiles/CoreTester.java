package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import androidx.annotation.NonNull;

import com.bylazar.panels.Panels;
import com.pedropathing.follower.Follower;
import com.pedropathing.ftc.localization.localizers.PinpointLocalizer;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

public class CoreTester {

    Follower follower;

    Pose initialPose = new Pose(10,10,10);

    Telemetry telemetry;

    public CoreTester(@NonNull HardwareMap hardwareMap, Pose initialPose, @NonNull Telemetry telemetry) {
        this.follower = PPConstants.createTeleOpFollower(hardwareMap);

        this.initialPose = initialPose;
        this.telemetry = telemetry;
    }



    public Pose testUnaryMinus() {
          telemetry.addData("pose", initialPose.unaryMinus());
          return initialPose.unaryMinus();
    }






}
