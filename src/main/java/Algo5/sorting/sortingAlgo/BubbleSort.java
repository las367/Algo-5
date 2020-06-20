package Algo5.sorting.sortingAlgo;

import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class BubbleSort<T> extends Sort<T> {

	public BubbleSort(T[] array, IComparator<T> comparator, Swapper<T> swapper) {
		super(array, comparator, swapper);
	}
        
        public void sort () {

                for (int i = 0; i < array.length - 1; i++)
                        for (int j = 0; j < array.length - i - 1; j++)  // why + 1 ? -> when j = arr.length - 2 -> index j+1 still possible
                                if ( comparator.compare(j, j+1, array) > 0 ) {
                                        swapper.swap(j, j+1, array);
                                }
        }
}