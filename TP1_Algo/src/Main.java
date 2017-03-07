public class Main {
 
	public static void main(String[] args){
		RandomData rdm = new RandomData();
		int min = 0;
		int max = 500;
		int nbvals = 10;
		
		while (nbvals <= 100000){
			int[] list = rdm.generate1d(nbvals, min, max);
			for(int i=0;i<nbvals;i++){
				//System.out.println(list[i]);
			} 
		
			long startTime = System.currentTimeMillis();
			InterfaceSort iSort = new Factory().getSort("quick");
			//SelectionSort sSort = new SelectionSort();
			//BubbleSort bSort = new BubbleSort();
			//MergeSort mSort = new MergeSort();
			iSort.sort(list);
		
			long endTime = System.currentTimeMillis();
			long difference = endTime - startTime;
			
			System.out.println("The number of value is " + nbvals + " Time is : " + difference );
			nbvals +=10000;
		}
	}
	 
	/**
	 * Méthode qui trouve la valeur minimale
	 * @param list
	 * @param nbvals
	 * @return
	 */
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
}



