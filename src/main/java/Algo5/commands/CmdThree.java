package Algo5.commands;

import Algo5.cli.CommandLineInterface;

public class CmdThree implements ICommand {

	@Override
	public void execute() {
		
		int key = CommandLineInterface.in.inputInt(CommandLineInterface.mNumIn);
                try {
			int i = CommandLineInterface.hTable.search(key);
			System.out.printf("Key %d found in the hashtable on index %d\n", key, i);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
        
}