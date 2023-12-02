package tp1.logic;

import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.UCMLaser;
import tp1.logic.gameobjects.UCMShip;
import java.util.Random;

public class Game implements GameStatus {

	//TODO fill with your code

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	
	private GameObjectContainer container;
	private UCMShip player;
	private AlienManager alienManager;
	private Level level;
	private int currentCycle;
	private Random rand;
	private UCMLaser laser;
	private long seed;
	private boolean exit;
	
	//TODO fill with your code

	public Game (Level level, long seed){
		this.level = level;
		this.seed = seed;
		initGame();
	}
		
	private void initGame () {
		this.exit = false;
		this.currentCycle = 0;
		this.rand = new Random(seed);
		this.alienManager = new AlienManager(this, this.level);
	    this.container = new GameObjectContainer();
		this.container = alienManager.initialize();
		this.player = new UCMShip(this, new Position(DIM_X / 2, DIM_Y - 1));
		laser = new UCMLaser(this,player.getPosition());
		container.add(player);
		
	}

	//MOVE METHODS
	public void movePlayer(Move move) {
		player.move(move);
	}
	//CONTROL METHODS
	
	public boolean isFinished() {
	if(aliensWin() || this.exit) {
		return true;
	}
		return false;
	}

	public void exit() {
	  this.exit = true;
	}
	public void reset() {
		initGame();
	    System.out.println("RESETEADO!");
	}

	public void update() {
	    this.currentCycle++;
	    this.container.onBorder();
	    this.container.checkAttack();
	    this.container.computerActions();
	   this.container.automaticMoves();
	    
	}
	
	public boolean laser() {
		boolean disparado = false;
		if(this.player.shootLaser()) {
			container.add(laser);
			disparado = true;
		}
		return disparado;
	}


	//CALLBACK METHODS
	
	public void addObject(GameObject object) {
	    this.container.add(object);
	}
	
	public void removeObject(GameObject object) {
	    this.container.remove(object);
	}


	//VIEW METHODS
	
	public String positionToString(int col, int row) {
		return container.toString(new Position(col, row));
	}
	
	

	@Override
	public String infoToString() {
		// TODO fill with your code
		return "";
	}

	@Override
	public String stateToString() {
		int life = 1;
		int points = 2;
		int shockwave = 1;

		return String.format("Life: %d%nPoints:  %d%nShockwave; %d ", life, points, shockwave);
	}

	@Override
	public boolean playerWin() {
		// TODO fill with your code
		return false;
	}
	
	 
	public Random getRandom() {
		 return this.rand;
	}

	@Override
	public boolean aliensWin() {
		boolean aliensWin = false;
		if(this.alienManager.getSquadInFinalRow()) {
			aliensWin = true;
		}
		return aliensWin;
	}

	@Override
	public int getCycle() {
		return this.currentCycle;
	}

	@Override
	public int getRemainingAliens() {
		return this.alienManager.getRemainingAliens();
	}
	
	public UCMShip getPlayer() {
		return this.player;
	}
	
	public int getSpeed() {
		return this.level.getSpeed();
	}
	
	@Override
	public Level getLevel() {
		return this.level;
	}
	
	public UCMLaser getLaser() {
		return this.laser;
	}
	
}
