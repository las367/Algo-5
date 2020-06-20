package Algo5.sorting.helper;

import Algo5.sorting.comparator.IComparator;

public class IntegerComparator implements IComparator<Integer> {

	@Override
	public boolean compare(int from, int to, Integer[] arr) {

                if ( from < 0 || to < 0 ) return false;
                if ( from >= arr.length || to >= arr.length ) return false;
                return arr[from] > arr[to];
	}
        
}