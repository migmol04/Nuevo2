package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ufo extends EnemyShip {
	
	private static final int ARMOR = 1;
	private static final int POINTS = 25;
	private static final int DMG = 1;
	private boolean enabled;
	
	public Ufo(Game game, Position pos, int life) {
        super(game, pos, life);
        this.enabled = false;
        dir = Move.LEFT;
    }

	@Override
	public Position getPosition() {
		return this.pos;
	}

	@Override
	public String getSymbol() {
		return Messages.UFO_SYMBOL + "[" + getLife() + "]" ;
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
		this.enabled = false;
		this.game.removeObject(this);
	}

	@Override
	public void automaticMove() {
		if(canGenerateRandomUfo() && !this.enabled) {
			enable();
		}
		if (this.enabled) {
		performMovement(Move.LEFT);
		}
	}
		

	@Override
	protected int getPoints() {
		return POINTS;
	}
	
	public void enable() {
	  this.enabled = true;
	  pos = new Position(9, 0);
	}
	
	@Override
	public void computerAction() {
		if(onBorder()) {
			onDelete();
		}
		
	}

	@Override
	public boolean onBorder() {
		return pos.getX() < 0;
	}
	
	private boolean canGenerateRandomUfo() {
		boolean generated = false;
		if(game.getRandom().nextDouble() < game.getLevel().getUfoFrequency()) {
			generated = true;
		}
		return generated;
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
