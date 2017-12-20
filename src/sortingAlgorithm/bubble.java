package sortingAlgorithm;

/*
 * 冒泡排序练习
 */
public class bubble {

	public static int count = 0;
	public static void main(String[] args) {
		int[] array = {2,4,21,9,10,3,2,4,13};
		System.out.print("冒泡初始序列：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n---------");
		bubble bubble = new bubble();
		bubble.bubbleSort(array, array.length);
		System.out.print("--------\n冒泡排序结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
//		System.out.println("\n----------------");
//		System.out.println(count);
	}
	
	public void bubbleSort(int[] a,int n){
		int i,j;
		for(i=0; i<n-1; i++){
			boolean exchange = false;
			for(j=n-1; j>i; j--){
				if(a[j]<a[j-1]){
					int temp = a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
					exchange = true;
				}
			}
			count++;
			System.out.print("第"+count+"趟排序结果：");
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k]+" ");
			}
			System.out.println();
			if(!exchange)
				return;
		}
	}
}
