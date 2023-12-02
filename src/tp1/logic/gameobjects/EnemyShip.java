package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class EnemyShip extends Ship {
	protected Move dir;
	public EnemyShip(Game game, Position pos, int life) {
        super(game, pos, life);
    }
	
	protected abstract int getPoints();
	public abstract void onDelete();
	
	
}
