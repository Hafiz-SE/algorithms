import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            array[i] = randomNum;
        }

        printArray(array, "Before");
        MergeSort.sort(array);
    }

    public static void printArray(int[] array, String tag) {
        System.out.print("Printing " + tag + " Array --->");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.print("\n");
    }

    public static void sort(int[] array) {
        MergeSort.divide(array);
        printArray(array, "Final");
    }

    public static void divide(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }

        divide(leftArray);
        divide(rightArray);
        conquer(array, leftArray, rightArray);
    }

    public static void conquer(int array[], int[] leftArray, int[] rightArray) {
        int mainPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while (leftPointer < leftArray.length || rightPointer < rightArray.length) {
            if (leftPointer == leftArray.length) {
                array[mainPointer++] = rightArray[rightPointer++];
            } else if (rightPointer == rightArray.length) {
                array[mainPointer++] = leftArray[leftPointer++];
            } else if (leftArray[leftPointer] < rightArray[rightPointer]) {
                array[mainPointer++] = leftArray[leftPointer++];
            } else {
                array[mainPointer++] = rightArray[rightPointer++];
            }
        }
    }
}