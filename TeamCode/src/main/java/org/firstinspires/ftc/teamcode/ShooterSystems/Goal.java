package org.firstinspires.ftc.teamcode.ShooterSystems;

import java.util.HashMap;

public class Goal {


    public enum ALLIANCE {
        BLUE,
        RED
    }

    static HashMap<String, Integer> BlueCoords = new HashMap<>();

    {
        BlueCoords.put("x", 50);
        BlueCoords.put("y", 50);
    }

    static HashMap<String, Integer> RedCoords = new HashMap<>();

    {
        RedCoords.put("x", 50);
        RedCoords.put("y", -50);
    }

    public ALLIANCE alliance;

    public double x;
    public double y;

    public Goal(ALLIANCE alliance) {

        if (alliance == ALLIANCE.BLUE) {
                this.x = BlueCoords.get("x");
                this.y = BlueCoords.get("y");
        }
        else if (alliance == ALLIANCE.RED) {
            this.x = RedCoords.get("x");
            this.y = RedCoords.get("Y");
        }
    }
}
