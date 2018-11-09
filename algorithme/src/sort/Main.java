package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
	
	public static void print(int index, Object obj) {
		System.out.println(String.format("{%d},%s", index, obj.toString()));
	}
	public static void main(String[] args) {
		
		print(1, 5<<1);
		double b =2.2f;
		print(2, b);
		
		String str = "ahello world";
		print(3, str.indexOf("hello"));
		print(4, str.charAt(2));
		print(5, str.codePointAt(0));
		print(6, str.replace('a', 'b'));
		List<String> list = new ArrayList<>();
		list.add(String.valueOf(1));
		list.add(String.valueOf(2));
		list.add(String.valueOf(3));
		list.add(String.valueOf(0));
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return 0;
				
			}
			
		});
		System.out.println(list);
		
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
		System.out.println("helloworld");
		
		
		Heap heapSort = new Heap(100);
		heapSort.insert(5);
		heapSort.insert(10);
		heapSort.insert(8);
		heapSort.insert(16);
		heapSort.insert(12);
		heapSort.display();
		while(!heapSort.isEmpty()) {
			System.out.println(heapSort.extractMax());
		}
		
		Character c = ' ';
		System.out.println(c==' ');
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "A");
		System.out.println(map.get("b"));
		
		ServiceFilter filter = new ServiceFilter();
		filter.addWord("abc");
		filter.addWord("ag");
		filter.addWord("bf");
		System.out.println(filter.filter(" a bf  cbff"));//
		String content="  abc ddf";
		
		System.out.println(content.replaceAll("abc", "xxx"));
	}

}
