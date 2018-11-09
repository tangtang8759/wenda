package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[] {
				10,8,3,11,2,5,8
		};
		sort(arr);

	}
	public static void sort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		else {
			int gap =  arr.length/2;
			while(gap > 0) {
				for(int i=gap;i<arr.length;i++) {
					int current = arr[i];
					int preIndex = i-gap;
					while(preIndex>=0 && current < arr[preIndex]) {
						arr[preIndex+gap]= arr[preIndex];
						preIndex = preIndex - gap;
					}
					arr[preIndex+gap]=current;
				}
				gap= gap/2;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
