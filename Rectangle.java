package com.company;

    /**
     * Created by vdmitrieva on 02.05.2017.
     */
    public class Rectangle extends Figure {
        Rectangle(double a, double b) {
            super(a, b);
        }

        public double square() {
            return dim1 * dim2;
        }

        public double perimeter() {
            return dim1 * dim2 * 2;
        }

        public String toString() {
            return "Rectangle [ A = " + dim1 + " , B = " + dim2 + "] [ P = " + perimeter() + " ] [ S = " + square() + "]";

        }


    }
