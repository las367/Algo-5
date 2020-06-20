package Algo5.sorting.swapper;

public class Swapper<T> implements ISwapper<T> {

	@Override
	public void swap(int from, int to, T[] arr) {

                if ( from < 0 || to < 0 ) return;
                if ( from >= arr.length || to >= arr.length ) return;

                T temp = arr[from];
                arr[from] = arr[to];
                arr[to] = temp;
	}
        
}