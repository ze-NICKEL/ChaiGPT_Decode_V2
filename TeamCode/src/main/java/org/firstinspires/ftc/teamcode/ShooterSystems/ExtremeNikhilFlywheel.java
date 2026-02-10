package org.firstinspires.ftc.teamcode.ShooterSystems;


import androidx.annotation.NonNull;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Util.Constants.MotorNames;
import org.firstinspires.ftc.teamcode.Util.Constants.ShooterConstants.FlywheelConstants;
import org.firstinspires.ftc.teamcode.Util.NikhilFunctions;
import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

public class ExtremeNikhilFlywheel {

    DcMotorEx left_flywheel, right_flywheel;
    public double flywheelTargetVel = 0;

    HardwareMap hardwareMap;

    Follower follower;

    Gamepad gamepad = new Gamepad();

    public double flywheel_current_velocity = 0;


    Pose currentPose = new Pose(0,0,0);

    double currX = 0;
    double currY = 0;

    ElapsedTime timer = new ElapsedTime();
    public ExtremeNikhilFlywheel(@NonNull HardwareMap hardwareMap, Pose initialPose) {

        left_flywheel = hardwareMap.get(DcMotorEx.class, MotorNames.left_flywheel);

        right_flywheel = hardwareMap.get(DcMotorEx.class, MotorNames.right_flywheel);

        this.hardwareMap = hardwareMap;

        follower = PPConstants.createTeleOpFollower(hardwareMap);

        follower.setStartingPose(initialPose);

    }

    double kp = 0, ki = 0, kd = 0;

    double p = 0, i = 0, d = 0;

    NikhilFunctions customFunctions = new NikhilFunctions();
    public void setPIDCoefficients(double kp, double ki, double kd) {
        
        this.kp = kp;
        this.kd = kd;
        this.ki = ki;

    }
    double currError = 0, prevError = 0, errorSum = 0, dT = 0, prevTime =0, currTime = 0, derivative = 0;

    /**
     * Flywheel Set position function
     */
    public void updatePID() {

        prevTime = currTime;
        currTime = timer.milliseconds();
        dT = currTime - prevTime;


        prevError = currError;
        currError = flywheelTargetVel - flywheel_current_velocity;

        errorSum = currError * dT;

        p = kp * currError;
        i = ki * errorSum;
       derivative = (currError - prevError) / dT;
        d = kd * derivative;

        left_flywheel.setPower(customFunctions.clamp(p+i+d));
        right_flywheel.setPower(customFunctions.clamp(p+i+d));

    }

    public boolean isAtTargetVelocity() {
        if (flywheel_current_velocity < (flywheelTargetVel + 150) && flywheel_current_velocity > (flywheelTargetVel - 150)) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean flywheelEngaged = false;

    public void update() {

        currentPose = follower.getPose();

        currX = currentPose.getX();
        currY = currentPose.getY();

        flywheel_current_velocity = left_flywheel.getVelocity();


        if (gamepad.left_bumper) {
            flywheelEngaged = true;
        }
        if (flywheelEngaged && gamepad.left_bumper) {
            flywheelEngaged = false;

            flywheelTargetVel = 0;

            left_flywheel.setVelocity(0);
        }

        if (flywheelEngaged) {


            if (currX > 0 && currY > 0) {
                flywheelTargetVel = FlywheelConstants.close_velocity;
                left_flywheel.setVelocity(flywheelTargetVel);
            } else {
                flywheelTargetVel = FlywheelConstants.far_velocity;
                left_flywheel.setVelocity(flywheelTargetVel);

            }
        }
    }


}
