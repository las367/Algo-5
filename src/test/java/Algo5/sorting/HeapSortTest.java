package Algo5.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import Algo5.sorting.helper.IntegerComparator;
import Algo5.sorting.sortingAlgo.HeapSort;
import Algo5.sorting.sortingAlgo.Sort;
import Algo5.sorting.swapper.Swapper;

public class HeapSortTest {
        
        @Test
        public void SortTest () {

                Integer[] array = { 12, -2, 3, 42, 789, 32 };
                Integer[] expected = array;
                Arrays.sort(expected);

                Sort<Integer> heapSort = new HeapSort<Integer>(array, new IntegerComparator(), new Swapper<Integer>());
                heapSort.sort();

                heapSort.printArray();
                System.out.printf("Heap Sort \n\n");

                assertArrayEquals("array sorted with heapsort should match the expected array.", expected, heapSort.getArray());
        }
}