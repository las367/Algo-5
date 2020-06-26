package Algo5.commands;

import Algo5.cli.CommandLineInterface;

public class CmdFive implements ICommand {

	@Override
	public void execute() {
		
                try {
			CommandLineInterface.hTable.clear();
			System.out.printf("Hash table cleared\n");
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
        
}