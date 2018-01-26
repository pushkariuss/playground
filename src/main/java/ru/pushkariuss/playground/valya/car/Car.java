package com.valya.car;

import java.util.Random;

/**
 * Created by vdmitrieva on 03.05.2017.
 */
public class Car {
    private String name;
    private double maxSpeed;
    private Random rand = new Random();
    private double n = rand.nextDouble();

    public Car(String a1, double a2) {
        this.name = a1;
        this.maxSpeed = a2;

    }

    public String toString() {
        return "[ The car's name is " + name + ", max speed equals to " + maxSpeed + "]";

    }

    public String getName() {
        return name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

        public double currentSpeed(int qualityRoad) {
        switch (qualityRoad) {
            case 0:
            case 1:
                return n * maxSpeed * 0.4;
            case 2:
                return n * maxSpeed * 0.5;

            case 3:
                return n * maxSpeed * 0.7;
            case 4:
            case 5:
                return n * maxSpeed * 1.0;
            default:
                return (10000000);
        }
    }
}
