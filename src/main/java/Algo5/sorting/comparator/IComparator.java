package Algo5.sorting.comparator;

public interface IComparator<T> {
        
        // returns true if el on index+1 is smaller (whether its String or int attribute) than el on index
        int compare ( int from, int to, T[] arr );
}