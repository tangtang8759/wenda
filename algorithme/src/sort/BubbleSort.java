package sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {
				10,8,3,11,2,5,8
		};
		sort(arr);
		for(int ele : arr) {
			System.out.println(ele);
		}
		
	}
	
	public static void sort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		else {
			for(int i = 0; i<arr.length-1;i++) {
				for(int j=1; j<arr.length-i;j++) {
					if(arr[j-1]<arr[j]) {
						int t = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = t;
					}
				}
			}
		}
	}
	
}
