import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            array[i] = randomNum;
        }
        printArray(array, "Before");
        QuickSort.sort(array, 0, array.length - 1);
        printArray(array, "Final");
    }

    public static void sort(int[] array, int begin, int end) {
        if (begin == end) {
            return;
        }
        int pivotIndex = begin;
        int pivotValue = array[pivotIndex];
        Position pivotPosition = Position.LEFT;
        int i = begin;
        int j = end;
        while (i != j) {
            if (pivotPosition == Position.LEFT) {
                if (array[j] < pivotValue) {
                    QuickSort.swap(array, j, i);
                    pivotIndex = j;
                    pivotPosition = Position.RIGHT;
                } else {
                    j--;
                }
            }
            if (pivotPosition == Position.RIGHT) {
                if (array[i] >= pivotValue) {
                    QuickSort.swap(array, j, i);
                    pivotIndex = i;
                    pivotPosition = Position.LEFT;
                } else {
                    i++;
                }
            }
        }
        QuickSort.sort(array, begin, i);
        int rightArrayStartIndex = i == end ? i : i + 1;
        QuickSort.sort(array, rightArrayStartIndex, end);
    }

    public static void printArray(int[] array, String tag) {
        System.out.print("Printing " + tag + " Array --->");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.print("\n");
    }

    public static enum Position {
        LEFT, RIGHT
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}