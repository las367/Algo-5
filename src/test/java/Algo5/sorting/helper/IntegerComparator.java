package Algo5.sorting.helper;

import Algo5.sorting.comparator.IComparator;

public class IntegerComparator implements IComparator<Integer> {

	@Override
	public int compare(int from, int to, Integer[] arr) {

                if ( from < 0 || to < 0 ) return -1;
                if ( from >= arr.length || to >= arr.length ) return -1;
                return arr[from] - arr[to];
	}
        
}