package Algo5.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import Algo5.sorting.helper.IntegerComparator;
import Algo5.sorting.sortingAlgo.QuickSort;
import Algo5.sorting.sortingAlgo.Sort;
import Algo5.sorting.swapper.Swapper;

public class QuickSortTest {
        
        @Test
        public void SortTest () {

                Integer[] array = { 12, -2, 3, 42, 789, 32 };
                Integer[] expected = array;
                Arrays.sort(expected);

                Sort<Integer> quickSort = new QuickSort<Integer>(array, new IntegerComparator(), new Swapper<Integer>());
                quickSort.sort();

                quickSort.printArray();
                System.out.printf("Quick Sort \n\n");

                assertArrayEquals("array sorted with heapsort should match the expected array.", expected, quickSort.getArray());
        }
}