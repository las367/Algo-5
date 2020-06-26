package Algo5.cli;

import java.util.LinkedList;

import Algo5.commands.CmdFive;
import Algo5.commands.CmdFour;
import Algo5.commands.CmdOne;
import Algo5.commands.CmdSix;
import Algo5.commands.CmdThree;
import Algo5.commands.CmdTwo;
import Algo5.commands.ICommand;
import Algo5.hashing.ADSHashTable;
import Algo5.hashing.hash.Hash;
import Algo5.hashing.probing.QuadraticProbing;

public class CommandLineInterface {
        
        static int size = 13;
        public static ADSHashTable hTable = new ADSHashTable(size, new Hash(size), new QuadraticProbing());
        public static Console in = new Console();

        public final static String mEnter = "Please enter a number for an option\n";
        final static String mMenu = "\n1. Add number to hash table.\n2. Get number from hash table.\n3. Search number in hash table.\n4. Delete " 
                             + "number from hash table.\n5. Clear hash table.\n6. Sort students by matriculation number.\n0. Exit\n\n";
        public static final String mAgain = "\nPlease enter another number\n";

        public static final String mNumIn = "\nPlease insert a number\n";

        public static void run () {

                System.out.printf("Console Application ADS 5.\nImplemented Hash-table with length %d and quadratic probing algorithm\n", size);
                LinkedList<ICommand> commandList = fillList();

                boolean isRunning = true;
                int userInput = 7;

                while (isRunning) {

                        printMenu();
                        userInput = in.inputInt(mEnter);

                        if (userInput == 0) {
                                break;
                        } else if (userInput > 0 && userInput < 7) {

                                System.out.printf("Executing %d\n", userInput);
                                commandList.get(userInput - 1).execute();
                        } else {
                                System.out.printf(mAgain);
                        }
                        
                }
        }

        private static void printMenu () {
                
                System.out.print(mMenu);
        }

        private static LinkedList<ICommand> fillList () {

                LinkedList<ICommand> list = new LinkedList<ICommand>();

                list.add(new CmdOne());
                list.add(new CmdTwo());
                list.add(new CmdThree());
                list.add(new CmdFour());
                list.add(new CmdFive());
                list.add(new CmdSix());

                return list;
        }
}