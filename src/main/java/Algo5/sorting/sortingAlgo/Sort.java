package Algo5.sorting.sortingAlgo;

import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class Sort<T> {
        
        protected T[] array;
        protected IComparator<T> comparator;
        protected Swapper<T> swapper;

        public Sort (T[] array, IComparator<T> comparator, Swapper<T> swapper) {
                this.array = array;
                this.comparator = comparator;
                this.swapper = swapper;
        }

        public void sort () { }

        public void printArray () {

                System.out.print("[");
                for ( T st : array ) {
                        System.out.print(" " +  st + " ");
                }
                System.out.print("]\n");
        }

        public T[] getArray () { return array; }
}