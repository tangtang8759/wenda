package sort;

public class MergeSort {
	public static int[] sort(int[] arr) {
		int[] newarr = sort(arr, 0, arr.length-1);
		return newarr;
	}
	private static int[] sort(int[] arr, int left, int right) {
		int length = right-left+1;
		
		if(length == 1)
			return new int[] {arr[left]};
		
		int[] leftArr = sort(arr, left, (length-1)/2+left);
		int[] rightArr = sort(arr, (length-1)/2+left+1, right);
		int leftCursor=0;
		int rightCursor=0;
		
		int[] ret = new int[length];
		int i =0;
		while(leftCursor<leftArr.length || rightCursor < rightArr.length) {
			
			if(leftCursor==leftArr.length) {
				ret[i++]=rightArr[rightCursor];
				rightCursor++;
				continue;
			}
			if(rightCursor==rightArr.length) {
				ret[i++]=leftArr[leftCursor];
				leftCursor++;
				continue;
			}
			
			if(leftArr[leftCursor]<=rightArr[rightCursor]) {
				ret[i++]=leftArr[leftCursor];
				leftCursor++;
			}else {
				ret[i++]=rightArr[rightCursor];
				rightCursor++;
			}
		}
		return ret;
	}
}
