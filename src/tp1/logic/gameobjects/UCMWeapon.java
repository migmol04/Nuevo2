package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public abstract class UCMWeapon extends Weapon {

	public UCMWeapon(Game game, Position pos, int life) {
		super(game, pos, life);
		
	}
	
	@Override
	public boolean weaponAttack(GameItem other) {
		boolean wAttack = false;
		if(other.receiveAttack(this)) {
			recieveDamage(this.getDamage());
			wAttack = true;
		}
		return wAttack;
		
	}	
}

