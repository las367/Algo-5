package Algo5.sorting.comparator;

import Algo5.data.Student;

public class PrenameComparator implements IComparator<Student> {

	@Override
	public int compare ( int from, int to, Student[] arr ) {
		
		if ( from < 0 || to < 0 ) return -1;
		if ( from >= arr.length || to >= arr.length ) return -1;

		// TODO: if bigger than 1?
		return arr[from].getPrename().compareTo( arr[to].getPrename() );
	}
        
}