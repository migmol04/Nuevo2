package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {

	protected Position pos;
	protected int life;
	protected Game game;
	
	public GameObject(Game game, Position pos, int life) {	
		this.pos = pos;
		this.game = game;
		this.life = life;
	}
	
	
	
	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	protected int getLife() {
		return this.life;
	}

	//TODO fill with your code
	
    public abstract Position getPosition();
	public abstract String getSymbol(); 
	protected abstract int getDamage();
	protected abstract int getArmour();
	
			
	public abstract void onDelete();
	public abstract void automaticMove();
	public abstract  void computerAction();
	
	@Override
	public boolean isOnPosition(Position pos) {
		return (this.pos.getX() == pos.getX()) && (this.pos.getY() == pos.getY());
		
	};
	
	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		boolean hasAttacked = false;
		if(this.isOnPosition(weapon.getPosition())) {
			hasAttacked = true; 
		}
		return hasAttacked;
	}
	
	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		boolean hasAttacked = false;
		if(this.isOnPosition(weapon.getPosition())) {
			hasAttacked = true; 
		}
		return hasAttacked;
	}
	
	protected abstract boolean weaponAttack(GameItem other); 
	
	
	@Override
	public boolean performAttack(GameItem other) {
	boolean attack = false;

	if(isAlive() && weaponAttack(other )&& other.isAlive()) {
		attack = true;
	}
	return attack;
	}
	
	
	
	
	public void recieveDamage(int dmg) {
		this.life -= dmg;
	}
	public abstract boolean onBorder();
	
	protected void performMovement(Move dir) {
        pos = new Position(pos.getX() + dir.getX(), pos.getY() + dir.getY());
	}
	

}
