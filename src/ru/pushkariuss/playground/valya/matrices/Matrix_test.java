/**
 * Created by pushkariuss on 12.04.2017.
 */
public class Matrix_test {
    public static void main(String[] args) {
        int[][] mmm = {
                {1, 2, 3, 4},
                {2, 3, 5, 6},
                {8, 7, 8, 3},
                {2, 3, 5, 1}
        };
        System.out.println("Initial matrix:");
        print_matrix(mmm);
        convert_to_diagonal(mmm);
        System.out.println("Matrix_test is converted to diagonal view:");
        print_matrix(mmm);
        //Здесь перемножаются матрицы
        int[][] mmm1 = {
                {1, 2, 3},
                {0, 3, 5},
                {8, 7, 8},
                {2, 3, 5}
        };
        int[][] mmm2 = {
                {2, 7,56},
                {1, 1,568},
                {0, 4,5}
        };
        System.out.println("Initial arrays are: ");
        print_matrix(mmm1);
        System.out.println();
        print_matrix(mmm2);
        int[][] result_multiplication = matrix_multiplication(mmm1, mmm2);
        if (result_multiplication != null) {
            System.out.println("Multiply array is: ");
            print_matrix(result_multiplication);
        } else System.out.println("These arrays cannot be multiplied or links to arrays are NULL");

        // matrix_multiplication(mmm1, mmm2);
    }

    public static void print_matrix(int[][] mx) {
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                System.out.print(" " + mx[i][j]);
            }
            System.out.println();
        }


    }

    public static void convert_to_diagonal(int[][] mx) {
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                if (i != j) {
                    mx[i][j] = 0;
                }
            }
        }
    }

    public static int[][] matrix_multiplication(int[][] mx1, int[][] mx2) {
        if (mx1 == null || mx2 == null) return null;
        if (mx1.length == 0 || mx2.length == 0) return null;
        int count_of_column_1st_array = mx1[0].length;
        int count_of_rows_1st_array = mx1.length;
        int count_of_column_2nd_array = mx2[0].length;
        int count_of_rows_2nd_array = mx2.length;
        if (count_of_column_1st_array != count_of_rows_2nd_array) {
            return null;
        } else {
            int[][] result_matrix = new int[count_of_rows_1st_array][count_of_column_2nd_array];
            for (int i = 0; i < count_of_rows_1st_array; i++) {
                for (int k = 0; k < count_of_column_2nd_array; k++) {
                    int sum_elements = 0;
                    for (int j = 0; j < count_of_rows_2nd_array; j++) {
                        sum_elements += mx1[i][j] * mx2[j][k];
                    }
                    result_matrix[i][k] = sum_elements;
                }
            }
            return result_matrix;
        }
    }
}
