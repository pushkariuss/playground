import ru.pushkariuss.collections.Item;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Item<String> head = new Item<String>(String.valueOf(0));
        Item<String> tmp = head;
        Item<String> cycledOn = null;
        Random random = new Random();
        int n = 1000;
        int randomCycleIndex = random.nextInt(n);
        for (int i = 0; i < n; ++i) {
            tmp.setNext(new Item<String>(String.valueOf(i)));
            if (i == randomCycleIndex) {
                cycledOn = tmp;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(cycledOn);

        System.out.println(String.format("cycled on: %d", randomCycleIndex));
        System.out.println(String.format("cycled: %s", head.isCycled()));
    }
}
