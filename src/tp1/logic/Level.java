package tp1.logic;

/**
 * Represents the allowed levels in the game
 *
 */
public enum Level {

	EASY(4, 1, 2, 0.1, 3, 0.5), HARD(8, 2, 2, 0.3, 2, 0.2), INSANE(8, 2, 4, 0.5, 1, 0.1);

	private int numRegularAliens;
	private int numRowsRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ufoFrequency;
	private double shootFrequency;

	private Level(int numRegularAliens, int numRowsRegularAliens, 
			      int numDestroyerAliens, 
			      double shootFrequency, int numCyclesToMoveOneCell,
			      double ufoFrequency) {
		this.numRegularAliens = numRegularAliens;
		this.numRowsRegularAliens = numRowsRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ufoFrequency = ufoFrequency;
	}

	
	//TODO fill your code

	/**
	 * Returns UFO frequency corresponding the Level
	 * @return UFO Frequency
	 */
	
	public double getShootFrequency() {
		if (this == EASY)
		{
			shootFrequency = 0.1;
		}
		else if (this == HARD)
		{
			shootFrequency = 0.3;
		}
		else if (this == INSANE)
		{
			shootFrequency = 0.5;
		}
		
		return shootFrequency;
	}
	
	
	public double getUfoFrequency() {
		if (this == EASY)
		{
			ufoFrequency = 0.5;
		}
		else if (this == HARD)
		{
			ufoFrequency = 0.2;
		}
		else if (this == INSANE)
		{
			ufoFrequency = 0.1;
		}
		
		return ufoFrequency;
	}
	
	
	public int getNumRegularAliens() {


		if (this == EASY)
		{
			numRegularAliens = 4;
		}
		else if (this == HARD)
		{
			numRegularAliens = 8;
		}
		else if (this == INSANE)
		{
			numRegularAliens = 8;
		}
		
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {


		if (this == EASY)
		{
			numDestroyerAliens = 2;
		}
		else if (this == HARD)
		{
			numDestroyerAliens = 2;
		}
		else if (this == INSANE)
		{
			numDestroyerAliens = 4;
		}
		
		return numDestroyerAliens;
	}
	
	public int getSpeed() {


		if (this == EASY)
		{
			numCyclesToMoveOneCell = 3;
		}
		else if (this == HARD)
		{
			numCyclesToMoveOneCell = 2;
		}
		else if (this == INSANE)
		{
			numCyclesToMoveOneCell = 1;
		}
		
		return numCyclesToMoveOneCell;
	}

	/**
	 * Parse a string and return any matching level
	 * 
	 * @param param string to parse
	 * @return the parsed {@link Level} or <code>null</code> if none match.
	 */
	public static Level valueOfIgnoreCase(String param) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(param))
				return level;
		return null;
	}

	/**
	 * Returns a string representation of all the levels joined with
	 * <code>separator</code>
	 * 
	 * @param separator String used as separator
	 * @return the string resulted from joining all levels using
	 *         <code>separator</code>
	 */
	public static String all(String separator) {
		StringBuilder sb = new StringBuilder();
		for (Level level : Level.values())
			sb.append(level.name() + separator);
		String allLevels = sb.toString();
		return allLevels.substring(0, allLevels.length() - separator.length());
	}
}
