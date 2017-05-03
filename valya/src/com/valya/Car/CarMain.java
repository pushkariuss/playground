package com.valya.Car;

/**
 * Created by vdmitrieva on 03.05.2017.
 */
public class CarMain {
    public static void main(String[] args){
        Car car = new Car("Mitsubishi", 300);
        System.out.println(car.getName());
        System.out.println(car.getMaxSpeed());
        System.out.println(car);
        car.currentSpeed(20);
    }

}
