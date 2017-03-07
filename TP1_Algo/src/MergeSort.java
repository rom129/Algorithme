public class MergeSort implements InterfaceSort {
	//<<sort-main>>
	//<<merge-sorted>>
	
	public void sort(int[] data){
		sort(data, 0, data.length);
	}
	
	public void sort(int[] data, int begin, int end){
		if((end-begin) < 2)
			return;
		
		int middle= (end+begin)/2;
		sort(data, begin, middle);
		sort(data, middle, end);
		mergeSorted(data, begin, middle, end);
	}
	
	/**
	 * Méthode mergeSorted
	 * @param data
	 * @param begin
	 * @param middle
	 * @param end
	 */
	
	public void mergeSorted(int data[], int begin, int middle, int end){
		int[] tmp= new int[middle-begin];
		System.arraycopy(data, begin, tmp, 0, tmp.length);
		int i=0, j=middle, dest=begin;
		while((i< tmp.length) && (j<end)){
			data[dest++]= (tmp[i] < data[j]) ? tmp[i++] : data[j++] ;
		}
		while(i < tmp.length){
			data[dest++]= tmp[i++];
		}
	}
}