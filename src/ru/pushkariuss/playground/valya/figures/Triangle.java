package com.valya.figures;

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
        double halfper = perimeter()/2;
        return Math.sqrt(halfper * (halfper - dim1) * (halfper - dim2) * (halfper - dim3));

    }

    @Override
    public double perimeter() {
        return dim1 + dim2 + dim3;
    }

    public String toString() {
        return "Triangle [ A = " + dim1 + ", B = "+dim2+", C = "+dim3+"] [ P = " + perimeter() + " ] [ S = " + square() + "]";

    }
}