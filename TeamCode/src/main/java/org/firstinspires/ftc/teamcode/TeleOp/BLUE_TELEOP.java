package org.firstinspires.ftc.teamcode.TeleOp;

import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.ShooterSystems.ExtremeNikhilFlywheel;
import org.firstinspires.ftc.teamcode.ShooterSystems.Goal;
import org.firstinspires.ftc.teamcode.ShooterSystems.Turret;
import org.firstinspires.ftc.teamcode.Transfer;

public class BLUE_TELEOP extends OpMode {

    ExtremeNikhilFlywheel flywheel;

    Transfer transfer;

    Intake intake;

    Turret turret;

    //TODO: add hoodangler once tested others

    Pose initialPose = new Pose(0,0,Math.toRadians(270));

    Goal blueGoal = new Goal(Goal.ALLIANCE.BLUE);


    @Override
    public void init() {

        flywheel = new ExtremeNikhilFlywheel(hardwareMap, initialPose, gamepad1);

        transfer = new Transfer(hardwareMap, gamepad1, initialPose);

        intake = new Intake(hardwareMap, gamepad1, gamepad2);

        turret = new Turret(hardwareMap, gamepad1, initialPose, blueGoal);




    }

    @Override
    public void loop() {

        flywheel.update();

        transfer.update();
        intake.update();
        turret.update();


    }
}
