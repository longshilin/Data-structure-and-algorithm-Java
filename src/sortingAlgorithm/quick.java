package sortingAlgorithm;

public class quick {
	
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 0, -5, -2};
		System.out.println("排序前的数组为：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		quickSort(a, 0, a.length-1);
		
		System.out.println("排序后的数组为：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	
	static void quickSort(int[] a, int left, int right){		// 快速排序算法
		int mid,t;
		int ltemp,rtemp;
		
		ltemp = left;
		rtemp = right;
		mid = a[(left+right)/2];			// 分界值
		while(ltemp<rtemp){
			while(a[ltemp]<mid){
				ltemp++;
			}
			while(a[rtemp]>mid){
				rtemp--;
			}
			if(ltemp<=rtemp){
				t=a[ltemp];
				a[ltemp]=a[rtemp];
				a[rtemp]=t;
				ltemp++;
				rtemp--;
			}
		}
		if(ltemp==rtemp){
			ltemp++;
		}
		if(left<rtemp){
			quickSort(a, left, ltemp-1);		// 递归调用
		}
		if(ltemp<right){
			quickSort(a, rtemp+1, right);		// 递归调用
		}
	}
}
