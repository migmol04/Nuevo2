package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
	
	private static final int ARMOR = 2;
	private static final int POINTS = 0;

	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR);
		this.manager = alienManager;
	}


	@Override
	public String getSymbol() {          
		// TODO fill with your code
		return Messages.REGULAR_ALIEN_SYMBOL+ "[" + getLife() + "]" ;
	}

	@Override
	protected int getDamage() {
		return 0;
	}

	@Override
	protected int getArmour() {
		return ARMOR;
	}
	

	@Override
	public Position getPosition() {
		return this.pos;
	}
	
	@Override
	protected int getPoints() {
		return POINTS;
	}


	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void move(Move move) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected boolean weaponAttack(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}


}
