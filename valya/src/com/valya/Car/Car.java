package com.valya.Car;

/**
 * Created by vdmitrieva on 03.05.2017.
 */
public class Car {
    private String name;
    private double maxSpeed;

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

    public double currentSpeed(int qualityRoad){
        switch ( qualityRoad ){
            case 0:
                System.out.println("For quality road equals  to " + qualityRoad+" max speed will be "+getMaxSpeed()*0.4);
                break;
            case 1:
                System.out.println("For quality road equals  to " + qualityRoad+" max speed will be "+getMaxSpeed()*0.4);
            break;
            case 2:
                System.out.println("For quality road equals to " + qualityRoad+" max speed will be "+getMaxSpeed()*0.5);
            break;
            case 3:
                System.out.println("For quality road equals to " + qualityRoad+" max speed will be "+getMaxSpeed()*0.7);
            break;
            case 4:
                System.out.println("For quality road equals to " + qualityRoad+" max speed will be "+getMaxSpeed()*1.0);
            break;
            case 5:
                System.out.println("For quality road equals to " + qualityRoad+" max speed will be "+getMaxSpeed()*1.0);
            break;
            default:
                System.out.println("Please setup number from 0 to 5");
                break;
        }
        return (qualityRoad);
    }
        }
