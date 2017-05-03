package com.company;

/**
 * Created by vdmitrieva on 02.05.2017.
 */
public class Triangle90 extends Triangle {
    Triangle90(int a, int b) {
        super(a, b, 0);
    }

    public double square(){
        return dim1*dim2/2;
    }
    @Override
    public double perimeter() {
        return dim1 + dim2 + (Math.sqrt(Math.pow(dim1,2)+Math.pow(dim2,2)));
    }

    public String toString() {
        return "Triangle90 [ The first leg = " + dim1 + ", the second leg = "+dim2+"] [ P = " + perimeter() + " ] [ S = " + square() + "]";
}}
