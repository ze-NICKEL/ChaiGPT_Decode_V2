package org.firstinspires.ftc.teamcode.ShooterSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Util.Constants.HoodConstants;

public class HoodAngler {
    Servo HoodAngler;

    public HoodAngler(HardwareMap hardwareMap) {
        this.HoodAngler = hardwareMap.get(Servo.class, HoodConstants.HoodAnglerName);
    }

    /**
     *
     * @param position 0.11 is fully in, 0.9 is fully out
     */
    public void setPosition(double position) {
        HoodAngler.setPosition(position);
    }

    public void reset() {
        HoodAngler.setPosition(0.11);
    }
}
