package sort;

public class HeapSort {
	
	private int[] arrays;
	private int count;
	
	public HeapSort(int n) {
		arrays = new int[n+1];
		count=0;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public int size() {
		return count;
	}
	public void insert(int i) {
		arrays[count+1]=i;
		count++;
		shiftUp(count);
	}
	private void shiftUp(int k) {
		while(arrays[k/2]<arrays[k] && k>1) {
			swap(arrays, k/2, k);
			k=k/2;
		}
	}
	private void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x]=arr[y];
		arr[y]=tmp;
	}
	
	public void display() {
		for(int i=1;i<=count; i++) {
			System.out.print(arrays[i]+", ");
		}
	}
	
	public int extractMax() {
		if(count<=0)
			throw new RuntimeException();
		int ret = arrays[1];
		swap(arrays, 1, count);
		count--;
		shiftDown(1);
		return ret;
	}
	
	private void shiftDown(int k) {
		while(k*2 <=count ) {
			int j = 2*k; 
			if(j+1<=count && arrays[j+1]>arrays[j]) {
				j=j+1;
			}
			if(arrays[k]>=arrays[j])
				break;
			swap(arrays, k, j);
			k=j;			
		}
	}
}
