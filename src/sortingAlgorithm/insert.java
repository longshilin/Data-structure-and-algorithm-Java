package sortingAlgorithm;

/*
 * 选择排序练习
 */
public class insert {

	public static int count = 0;
	public static int ex = 0;
	public static void main(String[] args) {
		int[] array = {2,4,21,9,10,3,2,4,13};
		System.out.print("初始序列：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n---------");
		insert bubble = new insert();
		bubble.bubbleSort(array, array.length);
		System.out.print("--------\n排序结果：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n----------------");
		System.out.println(ex);
	}
	
	public void bubbleSort(int[] a,int n){
		int i,j;
		int t;
		for(i=1; i<n; i++){
			t=a[i];
			j=i-1;
			while(j>=0 && t<a[j]){	// 后移每个比t大的元素
				a[j+1]=a[j];
				j--;
				ex++;
			}
			a[j+1]=t;
			count++;
			System.out.print("第"+count+"趟排序结果：");
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k]+" ");
			}
			System.out.println();
		}
	}
}
