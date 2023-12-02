package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class AlienShip extends EnemyShip {
	protected  int cyclesToMove;
	protected  int speed;
	protected AlienManager manager;
	
	
	public AlienShip(Game game, Position pos, int life) {
        super(game, pos, life);
        speed = this.game.getSpeed();
        cyclesToMove = 0;
    	dir = Move.LEFT;
  
    }
	
	@Override
	public void automaticMove() {
		cyclesToMove--;
		haveLanded();
	        if (this.manager.getAliensEnBorde() > 0 && this.manager.getOnBorder()) {
	        	descent();
	            this.manager.DecreaseOnBorder();
	            dir = dir.changeDir(dir);
	            cyclesToMove = speed;
	            
	           
	        } else if (cyclesToMove == 0){
	            this.manager.setAlienEnBorde();
	            this.manager.setOnBorderFalse();
	            performMovement(dir);
	            cyclesToMove = speed; 
	        }
	    
	}
	
	
	protected void haveLanded() {
		if(isInFnalRow()) {
			this.manager.setHaveLanded();

		}
	}

	protected void readyToDescent() {
		if(onBorder()) {
			 this.manager.setOnBorder();
		}
	}

	protected boolean isInBorder() {
        return pos.getX() == 0 || pos.getX() == Game.DIM_X - 1;
    }
	
	
	protected boolean isInFnalRow() {
	  return pos.getY() >= Game.DIM_Y -1; 
	}

	public void descent() {
		performMovement(Move.DOWN);
	}
	
	@Override
	public void onDelete() {
		
	}
	 @Override
	  public boolean onBorder() {
	      boolean onBorder = false;
	      if(isInBorder()) {
	    	 this.manager.setOnBorder();
	        onBorder = true;
	       }
	       return onBorder;
	   }
}
