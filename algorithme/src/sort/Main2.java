package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2 {
	
	public static int[] getArray(){
		int[] array=new int[10];
		for(int i=0;i<array.length;i++){
			array[i]=(int) (Math.random()*100+100);
			System.out.print(array[i]+",");
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {178,128,183,166,105,111,179,171,110,180};//getArray();
		System.out.println("");
		Heap2 heap2 = new Heap2(6);
		for(int i=0;i<arr.length;i++) {
			heap2.insert(arr[i]);
			if(i>=5) {
				heap2.extractMax();
			}
		}
		while(!heap2.isEmpty()) {
			System.out.println(heap2.extractMax());
		}
		//heap.display();
//		Arrays.sort(arr);
		for(int ele: arr) {
			System.out.print(ele+", ");
		}
		//
		System.out.println("");
		int[] newarr = MergeSort.sort(arr);
		for(int ele: newarr) {
			System.out.print(ele+", ");
		}
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer e1, Integer e2) {
				return e2 -e1;
			}
			
		};
		Queue queue = new PriorityQueue<>(cmp);
		queue.add(5);
		queue.add(3);
		queue.add(56);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
	

}
