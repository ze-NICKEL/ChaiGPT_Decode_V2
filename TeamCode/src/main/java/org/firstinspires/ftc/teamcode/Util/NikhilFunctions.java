package org.firstinspires.ftc.teamcode.Util;


import org.apache.commons.math3.util.FastMath;

import dev.nextftc.core.commands.Command;

public class NikhilFunctions {


    /**
     * @param x Value to be clamped;
     * @return Clamped value of x between -1 and 1;
     */
    public double clamp(double x) {

        if (x > 1) {
            return 1;
        }
        else if (x < -1) {
            return -1;
        }
        else {
            return x;
        }
    }
    public double atan2(double deltaY, double deltaX) {
        return FastMath.atan2(deltaY, deltaX);
    }
}
