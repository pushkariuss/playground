import java.util.Scanner;

/**
 * Created by pushkariuss on 10.04.2017.
 */
public class ArrayFromKeyboard {
            public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Enter array length: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int ar[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Insert array elements:");
    /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++)
            ar[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        System.out.print ("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + ar[i]); // Выводим на экран, полученный массив
        }
        System.out.println();
    }
}
