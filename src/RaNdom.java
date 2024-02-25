import java.util.Random;

public class RaNdom {

    int a, b, c, d;

    int[] xRandom() {

        int[] nums = new int[4];

        a = (int) (Math.random() * 4) + 1;
        nums[0] = a;

        do {
            b = (int) (Math.random() * 4) + 1;
        } while (b == nums[0]);
        nums[1] = b;

        do {
            c = (int) (Math.random() * 4) + 1;
        } while (c == nums[0] | c == nums[1]);
        nums[2] = c;

        do {
            d = (int) (Math.random() * 4) + 1;
        } while (d == nums[0] | d == nums[1] | d == nums[2]);
        nums[3] = d;

        return nums;
    }

    int[] yRandom(int size) {

        int[] array = new int[size]; // создаем массив из 9 элементов
        int[] baba = new int[size];
        int numberArray;

        for (int i = 0; i < size; i++) {
            do {
                numberArray = (int) (Math.random() * size);
            } while (baba[numberArray] == 1);
            baba[numberArray] = 1;
            array[i] = numberArray;
        }
        return array;
    }
}




