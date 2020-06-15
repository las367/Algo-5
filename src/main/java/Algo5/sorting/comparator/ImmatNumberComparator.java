package Algo5.sorting.comparator;

import Algo5.data.Student;

public class ImmatNumberComparator implements IComparator {

	@Override
	public boolean compare ( int from, int to, Student[] arr ) {
		
		if ( from < 0 || to < 0 ) return false;
		if ( from >= arr.length || to >= arr.length ) return false;
		return arr[from].getImmatNumber() > arr[to].getImmatNumber();
	}
        
}