package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.view.Messages;

public class MoveCommand extends Command {

	private Move move;

	public MoveCommand() {}

	protected MoveCommand(Move move) {
		this.move = move;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_MOVE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_MOVE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_MOVE_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_MOVE_HELP;
	}

	
	@Override
	public ExecutionResult execute(Game game) {
            game.movePlayer(move);
		//System.out.println("TODO: PENDING ON IMPLEMENTING Move " + this.move);
	
	return new ExecutionResult(true);
	}



	@Override
	public Command parse(String[] commandWords) {
        if (commandWords.length == 2) {
            switch (commandWords[1].toLowerCase()) {
            case "left":
                return new MoveCommand(Move.LEFT);
            case "right":
                return new MoveCommand(Move.RIGHT);            
            case "lleft":
                return new MoveCommand(Move.LLEFT);
            case "rright":
                return new MoveCommand(Move.RRIGHT);
            }

        }
        
        return null;
	}

}
