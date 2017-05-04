package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix m1 = new Matrix(new int[][]{
                {1, 2, 3},
                {0, 3, 5},
                {8, 7, 8},
                {2, 3, 5}
        });
        Matrix m2 = new Matrix(new int[][]{
                //{1, 0, 1},
                //{0, 1, 1},
                //{1, 1, 0}
        });
        System.out.println("Initial Matrix: ");
        m1.print_matrix();
        m2.print_matrix();
        Matrix result_multiplication = m1.multiplication(m2);
        if (result_multiplication != null) {
            System.out.println("Multiply array is: ");
            result_multiplication.print_matrix();
        } else System.out.println("These arrays cannot be multiplied or links to arrays are NULL");
    }
}
