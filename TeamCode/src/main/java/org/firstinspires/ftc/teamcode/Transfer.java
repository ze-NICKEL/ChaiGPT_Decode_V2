package org.firstinspires.ftc.teamcode;



import androidx.annotation.NonNull;

import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ShooterSystems.ExtremeNikhilFlywheel;
import org.firstinspires.ftc.teamcode.Util.Constants.TransferConstants;
import org.firstinspires.ftc.teamcode.Util.NikhilFunctions;

import dev.nextftc.core.commands.delays.WaitUntil;

public class Transfer {

    DcMotorEx transfer;

    Gamepad gamepad = new Gamepad();

    double transferTargetVelocity = 0;

    ElapsedTime timer = new ElapsedTime();

    NikhilFunctions customFunctions = new NikhilFunctions();



    ExtremeNikhilFlywheel flywheel;

    Pose initialPose;
    public Transfer(@NonNull HardwareMap hardwareMap, Pose initialPose) {
        this.transfer = hardwareMap.get(DcMotorEx.class, TransferConstants.transfer_name);

        flywheel = new ExtremeNikhilFlywheel(hardwareMap, initialPose);

    }




    double p=0,i=0,d=0;

    double kp=0,ki=0,kd=0;

    double currError=0,prevError=0,dT=0,currTime=0,prevTime=0, errorSum = 0;


    ///  PID FUNCTION ISN'T USED ANYMORE
    public void updatePID() {

        prevError = currError;
        currError = transferTargetVelocity - transfer.getVelocity();

        p=kp*currError;

        errorSum = currError * dT;

        i= ki*errorSum;

        d = kd * ((currError-prevError) / dT);


        transfer.setPower(customFunctions.clamp(p+i+d));
    }

    public void threeTransfer() {
        transfer.setVelocity(TransferConstants.transfer_velocity);
        new WaitUntil(() -> flywheel.isAtTargetVelocity());

        transfer.setVelocity(TransferConstants.transfer_velocity);
        new WaitUntil(() -> flywheel.isAtTargetVelocity());

        transfer.setVelocity(TransferConstants.transfer_velocity);
        new WaitUntil(() -> flywheel.isAtTargetVelocity());


    }

    public void singleTransfer() {

        new WaitUntil(() -> flywheel.isAtTargetVelocity());
        transfer.setVelocity(TransferConstants.transfer_velocity);
    }

    public void update() {
        if (gamepad.right_bumper) {

            //transferTargetVelocity = TransferConstants.transfer_velocity;

            threeTransfer();

        }

        else {
            //transferTargetVelocity = TransferConstants.anti_transfer_velocity;

            transfer.setVelocity(TransferConstants.anti_transfer_velocity);
        }
    }
}
