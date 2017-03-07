public class Factory {
	public InterfaceSort getSort(String typeSort) {
		if(typeSort.equals("bubble"))
			return new BubbleSort();
		else if(typeSort.equals("selection"))
			return new SelectionSort();
		else if(typeSort.equals("merge"))
			return new MergeSort();
		else if(typeSort.equals("quick"))
			return new QuickSort();
		else
			return null;
	}
}
