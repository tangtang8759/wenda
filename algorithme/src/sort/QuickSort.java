package sort;

public class QuickSort {
	
	public static void sort(int[] array, int startIndex, int endIndex) {
		
		if(startIndex >= endIndex) {
			return;
		}
		int p = findPosition(array, startIndex, endIndex);
		sort(array,startIndex, p-1);
		sort(array, p+1, endIndex);
		
	}

	private static int findPosition(int[] array, int startIndex, int endIndex) {
		int ref = array[startIndex];
		int j = startIndex;
		for(int i = startIndex+1;i<=endIndex;i++) {
			if(array[i]<ref) {
				exchange(array, j+1, i);
				j++;
			}
		}
		exchange(array, startIndex,j);
		return j;
	}
	
	private static void exchange(int[] array, int x, int y) {
		int temp = array[x];
		array[x]=array[y];
		array[y]=temp;
	}
}
