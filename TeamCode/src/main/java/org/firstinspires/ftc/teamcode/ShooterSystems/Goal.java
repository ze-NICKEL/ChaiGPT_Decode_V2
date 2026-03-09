package org.firstinspires.ftc.teamcode.ShooterSystems;

import com.pedropathing.geometry.Pose;

import java.util.HashMap;

public class Goal {


    public enum ALLIANCE {
        BLUE,
        RED
    }

    Pose blueCoords = new Pose(64.1951219512195,60.58536585365853);

    Pose redCoords = new Pose(64.1951219512195, -60.58536585365853);


    public ALLIANCE alliance;

    public double x;
    public double y;

    public Goal(ALLIANCE alliance) {

        if (alliance == ALLIANCE.BLUE) {
                this.x = blueCoords.getX();
                this.y = blueCoords.getY();
        }
        else if (alliance == ALLIANCE.RED) {
            this.x = redCoords.getX();
            this.y = redCoords.getY();
        }
    }
}
