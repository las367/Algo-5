package Algo5.sorting.swapper;

import Algo5.data.Student;

public class Swapper implements ISwapper {

	@Override
	public void swap(int from, int to, Student[] arr) {

                if ( from < 0 || to < 0 ) return;
                if ( from >= arr.length || to >= arr.length ) return;

                Student temp = arr[from];
                arr[from] = arr[to];
                arr[to] = temp;
	}
        
}