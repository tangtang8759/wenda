package sort;

import java.util.Random;

public class Main {

	public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
		int[] arrays = new int[n];
		Random random = new Random();
		for(int i=0;i<n;i++) {
			arrays[i] = random.nextInt(n)%(rangeR - rangeL +1)+rangeL;
		}
		return arrays;
	}
	
	public static void main(String[] args) {
		
		int[] arrays = generateRandomArray(10000000, 1, 10000000);
//		for(int i=0;i<arrays.length;i++) {
//			System.out.print(arrays[i]+", ");
//		}
		System.out.println("");
		long start = System.nanoTime();
		QuickSort.sort(arrays, 0, arrays.length-1);
		long end = System.nanoTime();
//		for(int i=0;i<arrays.length;i++) {
//			System.out.print(arrays[i]+", ");
//		}
		System.out.println("");
		System.out.println((end-start)/1000000000.0);
		System.out.println(arrays[0]);
		System.out.println(arrays[arrays.length-1]);
		System.out.println(arrays[arrays.length/2]);
		System.out.println("");
	}

}
