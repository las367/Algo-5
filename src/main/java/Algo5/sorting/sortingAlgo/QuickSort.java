package Algo5.sorting.sortingAlgo;

import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class QuickSort<T> extends Sort<T> {

	public QuickSort(T[] array, IComparator<T> comparator, Swapper<T> swapper) {
		super(array, comparator, swapper);
        }

        public void sort () {

                doQuickSort(0, array.length-1);
        }
        
        private void doQuickSort  (int low, int high) {

                if (low < high) {

                        int index = partition(low, high);

                        doQuickSort(low, index - 1);
                        doQuickSort(index + 1, high);
                }
        }
        
        // Inspiration (read: code) taken from https://www.geeksforgeeks.org/quick-sort/
        private int partition (int low, int high) {

                int indexPivot = high;
                int indexOfSmaller = low - 1; // keep track of the index of smaller el added to the left side.

                for (int i = indexOfSmaller; i < high; i++) 
                        if ( comparator.compare(high, i, array) > 0 ) { /* if el on index i is smaller than pivot, swap el to the leftside + changes tracked
                                                                           by indexOfSmaller -> how many els are swapped. */

                                indexOfSmaller++;
                                swapper.swap(indexOfSmaller, i, array);
                        }

                swapper.swap(indexOfSmaller + 1, indexPivot, array); /* if last el before pivot is bigger -> swap withpivot
                                                                        if last el before pivot is smaller -> reversing the swap happened, so that pivot stays 
                                                                        on far left */

                return indexOfSmaller + 1;
        }
        
}