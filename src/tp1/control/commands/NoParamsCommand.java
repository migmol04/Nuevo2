package tp1.control.commands;

public abstract class NoParamsCommand extends Command {


	 @Override
	 public Command parse(String[] commandWords) {
	     if (commandWords.length == 1 && matchCommandName(commandWords[0])) {
	         return this; // Devuelve la instancia actual si la entrada es válida
	     } else {
	         return null; // Devuelve null si la entrada no es válida
	     }
	 }
}
	
	
