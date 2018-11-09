package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {
				14,10,8,3,11,2,5,8,13
		};
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}else {
			for(int i=0;i<arr.length-1;i++) {
				int minIndex = i;
				for(int j=i; j<arr.length;j++) {
					if(arr[minIndex]>arr[j]) {
						minIndex = j;
					}
				}
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
