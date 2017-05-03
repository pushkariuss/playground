package com.company;

/**
 * Created by vdmitrieva on 02.05.2017.
 */
public class Triangle extends Figure {
    protected double dim3;

    Triangle(double a, double b, double c) {
        super(a, b);
        this.dim3 = c;
    }

    public double square() {
        return Math.sqrt(perimeter() * (perimeter() - dim1) * (perimeter() - dim2) * (perimeter() - dim3));

    }

    @Override
    public double perimeter() {
        return dim1 + dim2 + dim3;
    }

    public String toString() {
        return "Triangle [ A = " + dim1 + ", B = "+dim2+", C = "+dim3+"] [ P = " + perimeter() + " ] [ S = " + square() + "]";

    }
}