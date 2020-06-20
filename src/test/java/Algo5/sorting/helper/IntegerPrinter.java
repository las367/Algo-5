package Algo5.sorting.helper;

public class IntegerPrinter {
        
        public static void print (Integer[] arr) {
                
                System.out.print("[");
                for (int i = 0; i < arr.length; i++)
                        System.out.printf(" %d ", arr[i]);
                System.out.printf("]\n");
        }
}