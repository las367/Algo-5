package Algo5.sorting;

import java.util.Arrays;

import org.junit.Test;

import Algo5.sorting.helper.IntegerPrinter;
import Algo5.sorting.sortingAlgo.Sort;

public class HeapSortTest {
        
        @Test
        public void SortTest () {

                Integer[] array = { 12, -2, 3, 42, 789, 32 };
                Integer[] expected = array;
                Arrays.sort(expected);

                IntegerPrinter.print(expected);
        }
}