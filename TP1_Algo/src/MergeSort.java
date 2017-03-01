public class MergeSort {
	//<<sort-main>>
	//<<merge-sorted>>
	
	public static void sort(int[] data){
		sort(data, 0, data.length);
	}
	
	public static void sort(int[] data, int begin, int end){
		if((end-begin) < 2)
			return;
		
		int middle= (end+begin)/2;
		sort(data, begin, middle);
		sort(data, middle, end);
		Main.mergeSorted(data, begin, middle, end);
	}
}