package com.company;

/**
 * Created by pushkariuss on 18.04.2017.
 */
public class Matrix {
    private int[][] ar; //Поле в классе

    //Конструктор
    public Matrix(int[][] ar) {
        this.ar = ar; //полю ar присваивается значение переменной ar из конструктора
    }
    public Matrix multiplication (Matrix m){
        if (this.ar == null || m.ar == null) return null;
        if (this.ar.length == 0 || m.ar.length == 0) return null;
        int count_of_column_1st_array = this.ar[0].length;
        int count_of_rows_1st_array = this.ar.length;
        int count_of_column_2nd_array = m.ar[0].length;
        int count_of_rows_2nd_array = m.ar.length;
        if (count_of_column_1st_array != count_of_rows_2nd_array) {
            return null;
        } else {
            int[][] result_matrix = new int[count_of_rows_1st_array][count_of_column_2nd_array];
            for (int i = 0; i < count_of_rows_1st_array; i++) {
                for (int k = 0; k < count_of_column_2nd_array; k++) {
                    int sum_elements = 0;
                    for (int j = 0; j < count_of_rows_2nd_array; j++) {
                        sum_elements += this.ar[i][j] * m.ar[j][k];
                    }
                    result_matrix[i][k] = sum_elements;
                }
            }
            return new Matrix(result_matrix);
        }
    }
    public void print_matrix() {
        for (int i = 0; i < this.ar.length; i++) {
            for (int j = 0; j < this.ar[i].length; j++) {
                System.out.print(" " + this.ar[i][j]);
            }
            System.out.println();
        }
        System.out.println();


    }

}
