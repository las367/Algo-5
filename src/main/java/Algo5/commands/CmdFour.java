package Algo5.commands;

import Algo5.cli.CommandLineInterface;

public class CmdFour implements ICommand {

	@Override
	public void execute() {
		
		int key = CommandLineInterface.in.inputInt(CommandLineInterface.mNumIn);
                try {
			CommandLineInterface.hTable.remove(key);
			System.out.printf("Key %d removed from the hashtable\n", key);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
        
}