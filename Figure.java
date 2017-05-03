package com.company;

/**
 * Created by vdmitrieva on 02.05.2017.
 */
  public abstract class Figure {
       protected double dim1;
       protected double dim2;

      public  Figure(double a, double b) {
            dim1 = a;
            dim2 = b;
        }

        public abstract double square();
        public abstract double perimeter();

    }



