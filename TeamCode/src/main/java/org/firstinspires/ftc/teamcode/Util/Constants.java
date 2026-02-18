package org.firstinspires.ftc.teamcode.Util;

import com.pedropathing.geometry.Pose;

import java.util.HashMap;

public class Constants {


    public static class ShooterConstants {

        public static class ConfigNames {

            public static String left_turret_Config_name = "left_turret_base";

            public static String right_turret_Config_name = "right_turret_base";

        }

        public static class FlywheelConstants {
            public static double close_velocity = 360_000;

            public static double far_velocity = 565_000;
        }

    }


    public static class MotorNames {

        public static String left_flywheel = "left_flywheel";
        public static String right_flywheel = "right_flywheel";
        public static String left_front_motor = "left_front";
        public static String left_back_motor = "left_back";
        public static String right_front_motor = "right_front";
        public static String right_back_motor = "right_back";


    }

    public static class IntakeConstants {

        public static String intake_motor = "intake";
        public static double intake_power = 2000;

        public static double outtake_power = -2000;

    }
    public static class TransferConstants {

        public static String transfer_name = "transfer";
        public static double transfer_velocity = 1200;

        public static double anti_transfer_velocity = -1200;

    }

    public static class LiftConstants {
        public static String liftServoMotorName = "lift";
        public static double lift_servo_position = 0.48;
    }

    public static class HoodConstants {
        public static String HoodAnglerName = "HoodAngler";

        //TODO: could add regression
    }

    /// CORE TESTER CONSTANTS: EXPERIMENTAL: BEWARE  ⚠ ⚠ ⚠ ⚠

    public static class CoreTesterConstants {
        public static String LimelightCameraName = "Limelight3A";


        public static final Pose BLUE_DRIVE_POSE = new Pose(-48, 24);
        public static final Pose RED_DRIVE_POSE = new Pose(-48, -24);
    }






}
