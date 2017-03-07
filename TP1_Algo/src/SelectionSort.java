
public class SelectionSort implements InterfaceSort {
	/**
	 * Méthode du sort pour le swap.
	 * @param data
	 */
	public void sort(int[] data){
		if(data.length < 2){return;}
		for(int i=0; i != data.length-1; ++i){
			Main.swap(data, i, Main.minimumIndex(data, i, data.length));
		}
	}
}
