package Algo5.sorting.sortingAlgo;

import Algo5.data.Student;
import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class Sort {
        
        protected Student[] array;
        protected IComparator comparator;
        protected Swapper swapper;

        public Sort (Student[] array, IComparator comparator, Swapper swapper) {
                this.array = array;
                this.comparator = comparator;
                this.swapper = swapper;
        }

        public void printArray () {

                System.out.print("(\n");
                for ( Student st : array ) {
                        System.out.print( st + "\n" );
                }
                System.out.print(")");
        }
}