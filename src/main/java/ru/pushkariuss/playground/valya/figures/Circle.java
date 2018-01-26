package com.valya.figures;

/**
 * Created by vdmitrieva on 02.05.2017.
 */
public class Circle extends Figure {
    Circle(int a) {
        super(a, 0);
    }

    // переопределяем метод
    public double square() {
        return Math.pow(dim1, 2) * Math.PI;

    }

    public double perimeter() {
        return 2 * Math.PI * dim1;

    }

    public String toString() {
        return "Circle [ R = " + dim1 + " ] [ P = " + perimeter() + " ] [ S = " + square() + "]";
    }
}

