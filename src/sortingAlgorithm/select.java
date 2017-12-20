package sortingAlgorithm;

/*
 * 选择排序练习
 */
public class select {

	public static int count = 0;
	public static void main(String[] args) {
		int[] array = {2,4,21,9,10,3,2,4,13};
		System.out.print("初始序列：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n---------");
		select bubble = new select();
		bubble.bubbleSort(array, array.length);
		System.out.print("--------\n排序结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
//		System.out.println("\n----------------");
//		System.out.println(count);
	}
	
	public void bubbleSort(int[] a,int n){
		int i,j;
		int index;
		for(i=0; i<n-1; i++){
			index = i;
			for(j=i+1; j<n; j++){
				if(a[index]>a[j]){
					index = j;
				}
			}
			if(index != i){
				int temp = a[index];
				a[index]=a[i];
				a[i]=temp;
			}
			count++;
			System.out.print("第"+count+"趟结果：");
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k]+" ");
			}
			System.out.println();
		}
	}
}
