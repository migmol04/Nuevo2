package tp1.logic;

import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.Ufo;

public class AlienManager  {
	
	private Game game;
	private int remainingAliens;
	private Level level;
	private boolean onBorder;
	private boolean squadInFinalRow;
	private int numAliensEnBorde;
	
	//TODO fill with your code
	
	public AlienManager(Game game, Level level) {
		this.game = game;
		this.level = level;
		this.onBorder = false;
	}

	public  GameObjectContainer initialize() {
		this.remainingAliens = this.game.getLevel().getNumDestroyerAliens() + this.game.getLevel().getNumRegularAliens();
		GameObjectContainer container = new GameObjectContainer();
		initializeOvni(container);
		initializeRegularAliens(container);
		initializeDestroyerAliens(container);
		return container;
	}
	
	private void initializeOvni(GameObjectContainer container) {
		container.add(new Ufo(game, new Position(9, 0), 1));
	}
	
	private void initializeRegularAliens (GameObjectContainer container) {
	
		container.add(new RegularAlien(this.game, new Position(2,1), this));
		container.add(new RegularAlien(this.game, new Position(3,1), this));
		container.add(new RegularAlien(this.game, new Position(4,1), this));
		container.add(new RegularAlien(this.game, new Position(5,1), this));
		if(this.level != Level.EASY) {
			container.add(new RegularAlien(this.game, new Position(2,2), this));
			container.add(new RegularAlien(this.game, new Position(3,2), this));
			container.add(new RegularAlien(this.game, new Position(4,2), this));
			container.add(new RegularAlien(this.game, new Position(5,2), this));
			
		}

		
	}
	
	private void initializeDestroyerAliens(GameObjectContainer container) {
		if(this.level == Level.EASY) {
			container.add(new DestroyerAlien(this.game, new Position(3,2), this));
			container.add(new DestroyerAlien(this.game, new Position(4,2), this));
		}
		
		else if(this.level == Level.HARD) {
			container.add(new DestroyerAlien(this.game, new Position(3,3), this));
			container.add(new DestroyerAlien(this.game, new Position(4,3), this));
		}
		
		else {
			container.add(new DestroyerAlien(this.game, new Position(3,3), this));
			container.add(new DestroyerAlien(this.game, new Position(4,3), this));
			container.add(new DestroyerAlien(this.game,  new Position(2,3), this));
			container.add(new DestroyerAlien(this.game, new Position(5,3), this));
			
			
		}
	}
	
	public boolean getOnBorder() {
		return this.onBorder;
	}

	
	public void setOnBorder() {
		this.onBorder = true;
	}
	
	public void setOnBorderFalse() {
		this.onBorder = false;
	}
	
	public int getRemainingAliens() {
	    return this.remainingAliens;
	}
	
	public void setAlienEnBorde() {
		this.numAliensEnBorde = this.remainingAliens;
	}
	
	public void setHaveLanded() {
		this.squadInFinalRow = true;
	}
	
	public int getAliensEnBorde() {
		return this.numAliensEnBorde;
	}
	
	public void DecreaseOnBorder() {
		this.numAliensEnBorde--;
	}
	
	public boolean getSquadInFinalRow() {
	  return this.squadInFinalRow;
	}
	
}
