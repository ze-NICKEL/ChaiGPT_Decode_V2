package org.firstinspires.ftc.teamcode.zCoreTesterFiles;

import androidx.annotation.NonNull;

import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.ShooterSystems.ExtremeNikhilFlywheel;
import org.firstinspires.ftc.teamcode.ShooterSystems.Goal;
import org.firstinspires.ftc.teamcode.ShooterSystems.Turret;
import org.firstinspires.ftc.teamcode.Transfer;
import org.firstinspires.ftc.teamcode.Util.Constants;

public abstract class CustomOpMode extends OpMode {

Intake intake;

ExtremeNikhilFlywheel flywheel;

Pose initialPose;

Transfer transfer;

public enum ALLIANCES {
    BLUE,
    RED
}

ALLIANCES alliance;

Goal.ALLIANCE goalAlliance;

Turret turret;
Goal goal;

    public void initializeDevices() {

        intake = new Intake(hardwareMap, gamepad1, gamepad2);

        if (alliance == ALLIANCES.BLUE) {
            initialPose = Constants.CoreTesterConstants.BLUE_START_POSE;
            goalAlliance = Goal.ALLIANCE.BLUE;
        }
        else {
            initialPose = Constants.CoreTesterConstants.RED_START_POSE;
            goalAlliance = Goal.ALLIANCE.RED  ;
        }

        goal = new Goal(goalAlliance);

        flywheel = new ExtremeNikhilFlywheel(hardwareMap, initialPose, gamepad1);

        transfer = new Transfer(hardwareMap, gamepad1, initialPose);

        turret = new Turret(hardwareMap, gamepad1, initialPose, goal);
    }


    public void loopertron() {
        flywheel.update();
        turret.update();
        transfer.update();
        intake.update();

    }

}
