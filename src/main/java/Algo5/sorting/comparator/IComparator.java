package Algo5.sorting.comparator;

import Algo5.data.Student;

public interface IComparator {
        
        // returns true if el on index+1 is smaller (whether its String or int attribute) than el on index
        boolean compare ( int from, int to, Student[] arr );
}