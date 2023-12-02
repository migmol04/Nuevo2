package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
	
	
	private static final int ARMOR = 1;
	private static final int POINTS = 0;
	private boolean canShootBomb;
	private boolean bombReadyToFire;
	private Bomb bomb;

	public DestroyerAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR);
		this.manager = alienManager;
		this.canShootBomb = false;
		this.bombReadyToFire = false;
		
	}


	@Override
	public String getSymbol() {           
		return Messages.DESTROYER_ALIEN_SYMBOL + "[" + getLife() + "]"    ;
	}

	@Override
	protected int getDamage() {
		return this.bomb.getDamage();
	}

	@Override
	protected int getArmour() {
		return ARMOR;
	}
	
	@Override
	protected int getPoints() {
		return POINTS;
	}


	@Override
	public Position getPosition() {
		return this.pos;
	}
	
	@Override
	public void computerAction() {
		if(!this.bombReadyToFire && canGenerateRandomBomb()) {
			bomb = new Bomb (game, getPosition(), 1, this);
			this.game.addObject(bomb);
			enableBomb();
		}
		if(bomb !=null && bomb.onBorder()) {
			this.game.removeObject(bomb);
			enableBomb();
		}
	}
	
	public boolean canGenerateRandomBomb() {
		if(game.getRandom().nextDouble() < game.getLevel().getShootFrequency()) {
			
			this.canShootBomb = true;
		}
		return this.canShootBomb;
	}
	public void enableBomb() {
		this.bombReadyToFire = !this.bombReadyToFire;
		
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