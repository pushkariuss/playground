package com.company;

/**
 * Created by vdmitrieva on 02.05.2017.
 */
public class ClassesHierarchy {

    public static void main(String[] args) {
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(3,6);
        Triangle triangle = new Triangle(1,2,5);
        Triangle90 triangle90 = new Triangle90(3,4);

        System.out.println("Square: "+circle.square());
        System.out.println("Perimeter: "+circle.perimeter());
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);
        System.out.println(triangle90);
    }
}
