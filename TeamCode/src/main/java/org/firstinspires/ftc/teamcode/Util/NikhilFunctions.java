package org.firstinspires.ftc.teamcode.Util;


import org.apache.commons.math3.util.FastMath;

public class NikhilFunctions {



    public double clamp(double x) {

        if (x > 1) {
            return 1;
        }
        else {
            return x;
        }

    }


    public double atan2(double deltaY, double deltaX) {
        return FastMath.atan2(deltaY, deltaX);
    }
}
