package Algo5.sorting.sortingAlgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Algo5.sorting.comparator.IComparator;
import Algo5.sorting.swapper.Swapper;

public class MergeSort<T> extends Sort<T> {

	public MergeSort (T[] array, IComparator<T> comparator, Swapper<T> swapper) {
		super(array, comparator, swapper);
	}
        
        public void sort () {

                mergeSort(array, 0, array.length - 1);
        }

        // divide and conquer.
        private void mergeSort (T[] arr, int left, int right) {

                // do method as long as left is smaller than right.
                if (left < right) {

                        int mid = (left + right) / 2; // find middle index

                        mergeSort(arr, left, mid); // sort the first half
                        mergeSort(arr, mid + 1, right); // sort second half

                        merge(arr, left, right); // merge these two halves
                }

        }

        // merge the conquered array.
        private void merge (T[] arr, int left, int right) {

                int mid = (left + right) / 2;

                int size1 = mid - left + 1;
                int size2 = right - mid;

                // create two arrays to store temp values;
                T[] firstArray = createArray(size1);
                T[] secondArray = createArray(size2);

                for (int i = 0; i < size1; i++) {
                        firstArray[i] = arr[left + i];
                }

                for (int j = 0; j < size2; j++) {
                        secondArray[j] = arr[mid + 1 + j];
                }

                // helper vars / iteration vars to walk through the first, second and main array. k => starting index of the
                // main "to-be merged" array.
                int i = 0;
                int j = 0;
                int k = left;

                // what this loop does is just comparing two elements and then adding the smaller element into the main "to-be merged"
                // array.
                while (i < size1 && j < size2) {
                        // using arrays.aslist here, to access the method indexOf -> all other sorting algos are using
                        // comparator to compare the elements for modularity. Here: elements being compared originate
                        // from the same array, but are being stored on a temporrary array. (as a divide and conquer strategy)
                        // to overcome this we just have to get the index of the element on the original array so that we can reuse
                        // the comparator we've been using for the other sort algos.
                        if ( comparator.compare(Arrays.asList(arr).indexOf(firstArray[i]), Arrays.asList(arr).indexOf(secondArray[j]), arr) <= 0 ) {
                                arr[k] = firstArray[i];
                                i++;
                        } else {
                                arr[k] = secondArray[j];
                                j++;
                        }
                        k++;
                }
                
                // last two loops => move remaining items from first/second array to the main array
                while (i < size1) {
                        arr[k] = firstArray[i];
                        k++;
                        i++;
                }

                while (j < size2) {
                        arr[k] = secondArray[j];
                        k++;
                        j++;
                }

        }

        // java does not allow to create an array of generics. so my workaround is to first create a linkedlist
        // of the generic and then use the toArray method to convert it to an array + casting. !! not really safe !! ⚠
        private T[] createArray (int size) {

                List<T> list = new LinkedList<T>();
                for (int i = 0; i < size; i++) {
                        list.add(null);
                }

                return (T[]) list.toArray();
        }

}