package Algo5.sorting.sortingAlgo;

import Algo5.data.Student;
import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class RadixSort extends Sort implements ISort {

	public RadixSort(Student[] array, IComparator comparator, Swapper swapper) {
		super(array, comparator, swapper);
		//TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
        
        private int getMax (int[] array) {

                int max = array[0];
                for (int i = 0; i < array.length; i++)
                        if (array[i] > max) {
                                max = array[i];
                        }

                return max;
        }
}