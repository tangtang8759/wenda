package sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = new int[] {
				10,8,3,11,2,5,8,6
		};
		sort(arr);

	}
	public static void sort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		else {
			for(int i=1;i<arr.length;i++) {
				int current = arr[i];
//				for(int j=i-1;j>=0;j--) {
//					
//					if(current < arr[j]) {
//						arr[j+1]=arr[j];
//						if(j==0) {
//							arr[j] = current;
//						}
//						continue;
//					}
//					arr[j+1]=current;
//					break;
//				}
				int index = i-1;
				while(index >=0 && current < arr[index]) {
					arr[index+1]=arr[index];
					index--;
				}
				arr[index+1]=current;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
