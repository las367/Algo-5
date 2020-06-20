package Algo5.sorting.sortingAlgo;

import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class SelectionSort<T> extends Sort<T> {

	public SelectionSort(T[] array, IComparator<T> comparator, Swapper<T> swapper) {
		super(array, comparator, swapper);
	}
 
        public void sort () {
                
                int minimum = 0;
                for (int i = 0; i < array.length; i++) {

                        minimum = i;
                        for (int j = i + 1; j < array.length; j++) 
                                if ( comparator.compare(minimum, j, array) > 0 ) {
                                        minimum = j; //for every step, search the minimum num between i and length of the list 
                                }
                                
                        //at the end of every step the min number would be placed to where i is.
                        swapper.swap(i, minimum, array);
                }
        }
        
}