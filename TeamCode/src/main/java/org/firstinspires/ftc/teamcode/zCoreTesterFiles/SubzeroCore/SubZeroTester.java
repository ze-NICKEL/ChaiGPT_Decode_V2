package org.firstinspires.ftc.teamcode.zCoreTesterFiles.SubzeroCore;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SubZeroTester extends OpMode {



    public static Specialization specialization = new Specialization()
            .first(5)
            .second(6);

Telemetry telemetry;
    @Override
    public void init() {

        telemetry = new MultipleTelemetry(super.telemetry, FtcDashboard.getInstance().getTelemetry());

    }

    @Override
    public void loop() {

        telemetry.addLine(String.valueOf(specialization.first));
        telemetry.addLine(String.valueOf(specialization.second));

    }
}
