package org.firstinspires.ftc.teamcode.ShooterSystems;


import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.apache.commons.math3.util.FastMath;
import org.firstinspires.ftc.teamcode.Util.Constants;
import org.firstinspires.ftc.teamcode.Util.Constants.ShooterConstants;
import org.firstinspires.ftc.teamcode.Util.NikhilFunctions;
import org.firstinspires.ftc.teamcode.pedroPathing.PPConstants;

public class Turret {


    Gamepad gamepad = new Gamepad();


    CRServoImplEx left_turret;

    CRServoImplEx right_turret;



    //Pose initialPose = new Pose(0,0,0);

    public double targetX = 0;
    public double targetY = 0;

    public double currentX = 0;
    /// Turret angle based on normalization to x axis
    double pointC = 0;
    public double currentY = 0;

    double deltaX = 0;
    double deltaY = 0;

    double robotHeading = 0;

    Follower follower;

    double fieldAngle = 0;

    double kp = 0, ki = 0, kd = 0;

    double currError = 0, prevError = 0;

    double p=0, i=0,  d=0, f=0;



    double currTurretPosTicks = 0;

    double errorSum = 0;
    Pose currentPose = new Pose(0,0,0);

    double dT = 0;

    DcMotorEx motor;

    NikhilFunctions customFunctions = new NikhilFunctions();




    /*

        Blue teeop starting pos: -60, 9.5);
        REd teleop starting (-60 -9.5


        //START ROBOT AT 270 degrees(facing away from goals
     */



    public Turret(HardwareMap hardwareMap, Pose initialPose, Goal goal){

        left_turret = hardwareMap.get(CRServoImplEx.class, ShooterConstants.ConfigNames.left_turret_Config_name);
        right_turret = hardwareMap.get(CRServoImplEx.class, ShooterConstants.ConfigNames.right_turret_Config_name);
        this.targetX = goal.x;
        this.targetY = goal.y;

       follower = PPConstants.createTeleOpFollower(hardwareMap);



       follower.setStartingPose(initialPose);


        follower.update();
        motor = hardwareMap.get(DcMotorEx.class, Constants.MotorNames.right_back_motor);


    }


    public void setPIDFCoefficients(double kp, double ki, double kd) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;

    }

    double turretTurnTicks = 0;

    public void setPosition(double endPos) {

        this.turretTurnTicks = endPos;

    }

    double power = 0;

    public void updatePID() {
        prevError = currError;
        currError = turretTurnTicks - currTurretPosTicks;

        errorSum = prevError + currError;


        p = kp * currError;
        i = ki * errorSum;
        d = kd* (prevError - currError) / dT;

        left_turret.setPower(customFunctions.clamp(p+i+d));
        right_turret.setPower(customFunctions.clamp(p+i+d));


    }

    public void update() {

        currTurretPosTicks = motor.getCurrentPosition();
        currentPose = follower.getPose();

        currentX = currentPose.getX();
        currentY = currentPose.getY();


        deltaX = targetX - currentX;
        deltaY = targetY - currentY;

        fieldAngle = FastMath.atan2(deltaY, deltaX);
        robotHeading = currentPose.getHeading();
        pointC = 180 - robotHeading + fieldAngle;

        setPosition(pointC + fieldAngle);
        updatePID();

    }
}
