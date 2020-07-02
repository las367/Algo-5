package Algo5.commands;

import Algo5.cli.CommandLineInterface;

public class CmdOne implements ICommand {

	@Override
	public void execute() {
		
		int key = CommandLineInterface.in.inputInt(CommandLineInterface.mNumIn);
                try {
			CommandLineInterface.hTable.insert(key);
			System.out.printf("Key %d added\n", key);

		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
        
}