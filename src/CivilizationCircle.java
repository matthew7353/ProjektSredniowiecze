import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class CivilizationCircle extends Civilizations{
    CivilizationCircle(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles);
    }
    int target;
    ArrayList<Integer> newConqueredTiles = new ArrayList<>();
    public void takeControlOf(int target){
                newConqueredTiles.add(target);
                boardArray[target] = this.id;
                board.updateCell(target / numOfTiles,target % numOfTiles, color);
    }
    @Override
    public void conquer(){
        Random rand = new Random();
        int n = rand.nextInt(2);
        if (n == 0) {
            for (int x : conqueredTiles) {
                if ((x < numOfTiles * (numOfTiles - 1)) && (boardArray[x + numOfTiles] == 0)) {
                    target = x + numOfTiles;
                    takeControlOf(target);
                }
                if ((x > numOfTiles) && boardArray[x - numOfTiles] == 0) {
                    target = x - numOfTiles;
                    takeControlOf(target);
                }
                if ((x % numOfTiles != numOfTiles - 1) && boardArray[x + 1] == 0) {
                    target = x + 1;
                    takeControlOf(target);
                }
                if ((x % numOfTiles != 0) && (boardArray[x - 1] == 0)) {
                    target = x - 1;
                    takeControlOf(target);
                }
            }
            conqueredTiles.addAll(newConqueredTiles);
        }
    }
}