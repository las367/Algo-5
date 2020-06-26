package Algo5.commands;

import Algo5.cli.CommandLineInterface;
import Algo5.data.Student;
import Algo5.sorting.comparator.ImmatNumberComparator;
import Algo5.sorting.sortingAlgo.BubbleSort;
import Algo5.sorting.sortingAlgo.HeapSort;
import Algo5.sorting.sortingAlgo.QuickSort;
import Algo5.sorting.sortingAlgo.SelectionSort;
import Algo5.sorting.sortingAlgo.Sort;
import Algo5.sorting.swapper.Swapper;

public class CmdSix implements ICommand {

        private final String mSort = "1. Bubble sort.\n2. Heap sort.\n3. Quicksort.\n4. Selection sort.\n"; 
        private Sort sorter;

        private Student[] createStudentArray () {

                Student s1 = new Student("Mickey", "Mouse", 32, 1);
                Student s2 = new Student("Apple", "Juice", 123, 1);
                Student s3 = new Student("Donald", "Duck", 1, 1);
                Student s4 = new Student("Orange", "Juice", 92, 1);
                Student s5 = new Student("Ham", "Burger", 4, 1);

                return new Student[] {s1, s2, s3, s4, s5};
        }

        private void printStudents (Student[] arr) {

                for (Student s : arr) {
                        System.out.println(s);
                }
        }

	@Override
	public void execute() {
                
                Student[] arr = createStudentArray();
                System.out.printf("\nCreated student array: \n");
                printStudents(arr);

                System.out.printf(mSort);
                int userInput = CommandLineInterface.in.inputInt(CommandLineInterface.mEnter);
                boolean run = true;

                while (run) {

                        run = false;
                        switch (userInput) {
                                case 1:
                                        sorter = new BubbleSort<Student>(arr, new ImmatNumberComparator(), new Swapper<Student>());
                                        break;
                                case 2: 
                                        sorter = new HeapSort<Student>(arr, new ImmatNumberComparator(), new Swapper<Student>());
                                        break;
                                case 3:
                                        sorter = new QuickSort<Student>(arr, new ImmatNumberComparator(), new Swapper<Student>());
                                        break;
                                case 4:
                                        sorter = new SelectionSort<Student>(arr, new ImmatNumberComparator(), new Swapper<Student>());
                                        break;
                                default: 
                                        run = true;
                                        userInput = CommandLineInterface.in.inputInt(CommandLineInterface.mAgain);
                                        break;
                        }
                }

                sorter.sort();
                System.out.printf("Sorted: \n");
                printStudents(arr);
	}
        
}