public class InsertionSort {
	public static void main(String args[]) {
		int array[] = new int[6];
		array[0] = 1;
		array[1] = 4;
		array[2] = 3;
		array[3] = 5;
		array[4] = 6;
		array[5] = 2;

		System.out.println("Before Sorting");
		for (int i = 0; i < array.length; i++) {
			System.out.print("\t" + array[i]);
		}
		System.out.println("");

		int cursor = 1;
		while (cursor != array.length) {
			int sortingValue = array[cursor];
			for (int i = cursor - 1; i >= 0; i--) {
				if (array[i] > sortingValue) {
					array[i + 1] = array[i];
					if (i == 0) {
						array[i] = sortingValue;
					}
				} else if (array[i] < sortingValue) {
					array[i + 1] = sortingValue;
					break;
				}
			}
			System.out.println("\n");
			System.out.print("Iteration " + cursor + ":\t");
			for (int i = 0; i < array.length; i++) {
				System.out.print("\t" + array[i]);
			}
			cursor++;
		}

	}
}
