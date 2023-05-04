import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
            array[i] = randomNum;
        }
        printArray(array, "Before");
        RadixSort.sort(array);
        printArray(array, "Final");
    }

    public static void sort(int[] array) {
        int numberFormat = 9; // For Decimal
        List<ArrayList<Integer>> aList = RadixSort.makeFreshArrayList(numberFormat);
        int max = RadixSort.getMaxNumber(array);
        int numberOfDigitOfMaxNumber = RadixSort.getNumberOfDigits(max);
        int divisor = 1;
        for (int i = 1; i <= numberOfDigitOfMaxNumber; i++) {
            for (int j = 0; j < array.length; j++) {
                int currentPosition = array[j] / divisor;
                int position = currentPosition == 0 ? currentPosition : currentPosition % 10;
                ArrayList<Integer> targetList = aList.get(position);
                targetList.add(array[j]);
                aList.set(position, targetList);
            }
            int pointer = 0;
            for (int k = 0; k <= numberFormat; k++) {
                ArrayList<Integer> numberArrayList = aList.get(k);
                if (numberArrayList == null) {
                    continue;
                }
                for (Integer number : numberArrayList) {
                    array[pointer] = number;
                    pointer++;
                }
            }
            aList = RadixSort.makeFreshArrayList(numberFormat);
            divisor = divisor*10;
        }
    }

    public static List<ArrayList<Integer>> makeFreshArrayList(int size) {
        List<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>(size);
        for (int i = 0; i <= size; i++) {
            aList.add(i, new ArrayList<>());
        }
        return aList;
    }

    public static void printArray(int[] array, String tag) {
        System.out.print("Printing " + tag + " Array --->");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.print("\n");
    }

    public static int getMaxNumber(int[] array) {
        int max = array[0]; // considering array is not empty

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int getNumberOfDigits(int number) {
        int divisor = 10;
        int numberOfDigit = 1;

        while (number / divisor >= 1) {
            divisor *= 10;
            numberOfDigit++;
        }
        return numberOfDigit;
    }
}