import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
/*
public class CivilizationUp extends Civilizations{
    CivilizationUp(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles, int chanceToGetTile, int chanceToGetEnemy, int cooldown) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles, chanceToGetTile, chanceToGetEnemy, cooldown);
    }

    @Override
    public void conquer(){
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n == 0) {
            for (int x : conqueredTiles) {
                if (x > numOfTiles - 1) {
                    if (boardArray[x - numOfTiles] == 0) {
                        target = x - numOfTiles;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / numOfTiles, target % numOfTiles, color);
                        return;
                    }
                }
            }
            for (int x : conqueredTiles) {
                if (x < (numOfTiles * numOfTiles - 1) - numOfTiles) {
                    if (boardArray[x + numOfTiles] == 0) {
                        target = x + numOfTiles;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / numOfTiles, target % numOfTiles, color);
                        return;
                    }
                }
            }
            for (int x : conqueredTiles) {
                if (x % numOfTiles != 0) {
                    if (boardArray[x - 1] == 0) {
                        target = x - 1;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / numOfTiles, target % numOfTiles, color);
                        return;
                    }
                }
            }

            for (int x : conqueredTiles) {
                if (x % numOfTiles != numOfTiles - 1) {
                    if (boardArray[x + 1] == 0) {
                        target = x + 1;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / numOfTiles, target % numOfTiles, color);
                        return;
                    }
                }
            }
        }
    }
}
*/