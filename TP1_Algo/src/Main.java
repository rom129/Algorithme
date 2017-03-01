public class Main {
 
	public static void main(String[] args){
		RandomData rdm = new RandomData();
		int min = 0;
		int max = 500;
		int nbvals = 10;
		
		while (nbvals <= 100){
			int[] list = rdm.generate1d(nbvals, min, max);
			for(int i=0;i<nbvals;i++){
				System.out.println(list[i]);
			}
			
			long startTime = System.currentTimeMillis();
			//sort1(list);
			//bubbleSort(list);
			MergeSort.sort(list);
			//QuickSort.sort(list);
			long endTime = System.currentTimeMillis();
			long difference = endTime - startTime;
			
			System.out.println("The number of value is " + nbvals + " Time is : " + difference );
			nbvals +=10000;
		}
	}
	 
	public static int minimumIndex(int[] data, int begin, int end){
		int res= begin;
		for(int i=begin+1; i != end; ++i){
			if(data[i] < data[res]){
				res= i;
			}
		}
		return res;
	}
	/**
	 * Méthode du sort pour le swap.
	 * @param data
	 */
	public static void sort1(int[] data){
		if(data.length < 2){return;}
		for(int i=0; i != data.length-1; ++i){
			swap(data, i, minimumIndex(data, i, data.length));
		}
	}
	 
	public class SelectionSort {
	//<<sort-main>>
	//<<swap>>
	//<<selection-sort-functions>>
	}
	
	/**
	 * Méthode du sort Bubble
	 * @param data
	 */
	public static void bubbleSort(int[] data){
		if(data.length < 2){return;}
		boolean hadToSwap= false;
		do{
			hadToSwap=false;
			for(int i= 0; i != data.length-1; ++i){
				if(data[i] > data[i+1]){
					swap(data, i, i+1);
					hadToSwap= true;
				}
			}
		}while(hadToSwap);
	}
	
	/**
	 * Méthode qui trouve la valeur minimale
	 * @param list
	 * @param nbvals
	 * @return
	 */
	public static int minval(int[] list, int nbvals){
		int min = list[0];
		for (int i=0; i< nbvals; i++){
			if (min > list[i]){
					min = list[i];
			}
		}
		return min;
	}
	
	/**
	 * Méthode pour le swap
	 * @param data
	 * @param i
	 * @param j
	 * @return
	 */
	public static int[] swap(int[]data, int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp; 
		return data;
	}
	/**
	 * Méthode mergeSorted
	 * @param data
	 * @param begin
	 * @param middle
	 * @param end
	 */
	
	public static void mergeSorted(int data[], int begin, int middle, int end){
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



