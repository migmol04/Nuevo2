package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMLaser extends UCMWeapon {
	
	private static final int ARMOR = 1;
	private static final int DMG = 1;
	
	public UCMLaser(Game game, Position pos) {
		super(game, pos, ARMOR);
		dir = Move.UP;
	}

	@Override
	public Position getPosition() {
		return pos;
	}

	@Override
	public String getSymbol() {
		return Messages.LASER_SYMBOL;
	}

	@Override
	protected int getDamage() {
		return DMG;
	}

	@Override
	protected int getArmour() {
		return ARMOR;
	}

	@Override
	public void onDelete() {
		
	}
	
	@Override
	public boolean onBorder() {
		boolean enBorde = false;
		if(pos.getY() < 0 ) {
			enBorde = true;
		}
		return enBorde;
	}
	
	public void setPosition(Position position) {
		this.pos = position;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		// TODO Auto-generated method stub
		return false;
	}

}
