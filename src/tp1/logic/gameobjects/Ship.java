package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class Ship extends GameObject {

    public Ship(Game game, Position pos, int life) {
        super(game, pos, life);
    }

    public abstract void move(Move move);

    public void receivePoints(int points) {
 
    }
}