package Algo5.commands;

import Algo5.cli.CommandLineInterface;

public class CmdTwo implements ICommand {

	@Override
	public void execute() {
		
		int key = CommandLineInterface.in.inputInt(CommandLineInterface.mNumIn);
                try {
			int val = CommandLineInterface.hTable.get(key);
			System.out.printf("Key %d found in the hashtable\n", val);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
        
}