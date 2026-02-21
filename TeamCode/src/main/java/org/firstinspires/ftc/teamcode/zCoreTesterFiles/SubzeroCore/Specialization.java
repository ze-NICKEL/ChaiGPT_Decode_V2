package org.firstinspires.ftc.teamcode.zCoreTesterFiles.SubzeroCore;

public class Specialization {

    public double first = 1;
    public double second = 2;


    public void setter() {
        first = 1;
        second = 1;
    }

    public Specialization setFirst(double first) {
        this.first = first;

        return this;



    }

    public Specialization setSecond(double second) {
        this.second = second;
        return this;
    }



    public Specialization() {

        setter();

    }
}
