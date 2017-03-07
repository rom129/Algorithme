public class BubbleSort implements InterfaceSort {
	//<<sort-main>>
	//<<swap>>
	//<<selection-sort-functions>>
	
	/**
	 * Méthode du sort Bubble
	 * @param data
	 */
	public void sort(int[] data){
		if(data.length < 2){return;}
		boolean hadToSwap= false;
		do{
			hadToSwap=false;
			for(int i= 0; i != data.length-1; ++i){
				if(data[i] > data[i+1]){
					Main.swap(data, i, i+1);
					hadToSwap= true;
				}
			}
		}while(hadToSwap);
	}
}
