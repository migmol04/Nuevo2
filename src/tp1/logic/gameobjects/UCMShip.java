package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.Move;

public class UCMShip extends Ship {

	private static final int ARMOR = 3;
	private boolean canShoot;
	private int points;
	private boolean hasShockWave;
	
    public UCMShip(Game game, Position position) {
        super(game, position, ARMOR);  
        this.canShoot = false;
        this.hasShockWave = false;

    }

    @Override
    public void move(Move move) {
    	int newX = pos.getX() + move.getX();
	    int newY = pos.getY() + move.getY();
        pos = new Position(newX, newY);
    }

    @Override
	public Position getPosition() {
        return pos;
    }
	
	
	@Override
	public String getSymbol() {
		if(isAlive()) {
		return Messages.UCMSHIP_SYMBOL;
		}
		else
		return Messages.UCMSHIP_DEAD_SYMBOL;
	}

	@Override
	protected int getDamage() {
		return 0;
	}
    

	public void performAttack() {
		
	}

	@Override
	protected int getArmour() {
		return ARMOR;
	}
	
	public void enableLaser() {
        this.canShoot = !this.canShoot;
        game.getLaser().setPosition(getPosition());
      
    }
	
	public boolean shootLaser() {
        boolean shooted = false;
        
        if (!this.canShoot) {
            enableLaser();
            shooted = true;
        }
        
        return shooted;
    }
	

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onBorder() {
		boolean enBorde = false;
		if(pos.getX() >= Game.DIM_X || pos.getX() < 0) {
			enBorde = true;
		}
		return enBorde;
	}

	@Override
	public void automaticMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean weaponAttack(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}

}
