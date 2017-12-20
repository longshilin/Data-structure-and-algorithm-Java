package sortingAlgorithm;

public class binaryInsert {

	public static void main(String[] args) {
        int[] a = { 4, 2, 1, 6, 3, 0, -5, -2 };
        BinaryInsertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
	
	public static void BinaryInsertSort(int[] a) {
        int low, high;
        int mid, temp;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            low = 0;
            high = i - 1;
            while (low <= high) {			// 折半查找的过程
                mid = (low + high) / 2;
                if (temp < a[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i - 1; j > high; j--)
                a[j + 1] = a[j];
            a[high + 1] = temp;
        }
    }
}
