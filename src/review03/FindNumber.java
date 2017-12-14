package review03;

public class FindNumber {

	public static void main(String[] args) {
		int array[] = { 1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15 };
		boolean f = find(array, 4, 4, 15);
		System.out.println(f);
	}

	/*
	 * 查找函数，在输入的rows行，columns列的 array数组中进行查找 当找到输入的number时，返回true，否则返回false
	 */
	static boolean find(int array[], int rows, int columns, int number) {
		boolean found = false;
		if (array != null && rows > 0 && columns > 0) {
			int r = 0;
			int c = columns - 1; // (r,c)表示矩阵数组的右上角数的下标
			while (r < rows && c >= 0) {
				if (number == array[r * columns + c]) {
					found = true;
					break;
				} else if (number < array[r * columns + c])
					c--;
				else
					r++;
			}
		}
		return found;
	}
}
