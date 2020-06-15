package Algo5.sorting.sortingAlgo;

import Algo5.data.Student;
import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class HeapSort extends Sort implements ISort {

	public HeapSort(Student[] array, IComparator comparator, Swapper swapper) {
		super(array, comparator, swapper);
	}

	@Override
	public void sort() {

                // first, we need to rearrange the provided array into a heap! from top to above...
                // why array.length / 2 - 1 -> bcs heap basically divides the array into a "tree" 
                // and this tree has two child components -> +- divides array into two main parts.
                for ( int i = 0; i < array.length / 2 - 1; i++ ) {
                        heapify(array, i);
                }
                
                // move the highest el to the end of the array -> remove highest from the heap
                for ( int i = array.length - 1; i > 0; i-- ) {

                        swapper.swap(i, 0, array); // i is where the largest element should land / be positioned
                        heapify(array, 0); // calls heapify to organize the tree (again)
                }
	}
        
        // method to transform the array into a heap and also to rank/organize the heap (possible: recursively) so that
        // the highest element would be on top.
        private void heapify ( Student[] arr, int i ) {

                // set i as the root node -> assume el on i is the largest
                int largest = i;
                int left = 2 * i + 1; // left child node of i
                int right = 2 * i + 2; // right child node of i

                // if el on left also right is bigger than el on the current largest index, change the largest index to left / right. 
                if ( left < arr.length && comparator.compare(left, largest, arr) )
                        largest = left;

                if ( right < arr.length && comparator.compare(right, largest, arr) ) 
                        largest = right;

                if ( largest != i ) { // if largest element is not on i -> call heapify recursively with the largest as i to organize lower heap(s)

                        swapper.swap(largest, i, arr);
                        heapify(arr, largest);
                }
        }
}