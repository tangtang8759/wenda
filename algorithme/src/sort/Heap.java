package sort;

public class Heap {
	
	private int[] arrays;
	private int[] index;
	private int count;
	
	public Heap(int n) {
		arrays = new int[n+1];
		index = new int[n+1];
		count=0;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public int size() {
		return count;
	}
	public void insert(int i) {//TO DO
		arrays[count+1]=i;
		index[count+1]=count+1;
		count++;
		shiftUp(count);
	}
	private void shiftUp(int k) {
		while(arrays[index[k/2]]<arrays[index[k]] && k>1) {
			swap(index, k/2, k);
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
			System.out.print(arrays[index[i]]+", ");
		}
	}
	
	public int extractMax() {
		if(count<=0)
			throw new RuntimeException();
		int ret = arrays[index[1]];
		swap(index, 1, count);
		count--;
		shiftDown(1);
		return ret;
	}
	
	public int extractMaxIndex() {
		if(count<=0)
			throw new RuntimeException();
		int ret = index[1];
		swap(index, 1, count);
		count--;
		shiftDown(1);
		return ret;
	}
	
	public int getItem(int i) {
		return arrays[i];
	}
	
	public void change(int ind, int value) {
		arrays[ind]= value;
		for(int i=1;i<=count;i++) {
			if(index[i]==ind) {
				shiftDown(i);
				shiftUp(i);
				return;
			}
		}
	}
	
	private void shiftDown(int k) {
		while(k*2 <=count ) {
			int j = 2*k; 
			if(j+1<=count && arrays[index[j+1]]>arrays[index[j]]) {
				j=j+1;
			}
			if(arrays[index[k]]>=arrays[index[j]])
				break;
			swap(index, k, j);
			k=j;			
		}
	}
}
