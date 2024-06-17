import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class CivilizationCircle extends Civilizations{
    CivilizationCircle(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles);
    }
    ArrayList<Integer> newConqueredTiles = new ArrayList<>();
    public void takeControlOf(int target){
        for (Civilizations civ : allCivilizations){
            if (boardArray[target] == civ.getId() && civ.conqueredTiles.contains(target)) {
                civ.conqueredTiles.remove(target);
            }
        }
        newConqueredTiles.add(target);
        boardArray[target] = this.id;
        board.updateCell(target / numOfTiles,target % numOfTiles, color);

    }
    @Override
    public void conquer(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(conqueredTiles.size());
        int randomElement = conqueredTiles.get(randomIndex);
        while (
                conqueredTiles.contains(randomElement + numOfTiles) &&
                conqueredTiles.contains(randomElement - numOfTiles) &&
                conqueredTiles.contains(randomElement + 1) &&
                conqueredTiles.contains(randomElement - 1))
        {
            randomIndex = rand.nextInt(conqueredTiles.size());
            randomElement = conqueredTiles.get(randomIndex);
        }
        int n = rand.nextInt(101);
        if (n <= (50 + (200/numOfTiles^2)*conqueredTiles.size())) {
                if ((randomElement < numOfTiles * (numOfTiles - 1)) && (boardArray[randomElement + numOfTiles] == 0)) {
                    target = randomElement + numOfTiles;
                    takeControlOf(target);
                }
                if ((randomElement > numOfTiles) && boardArray[randomElement - numOfTiles] == 0) {
                    target = randomElement - numOfTiles;
                    takeControlOf(target);
                }
                if ((randomElement % numOfTiles != numOfTiles - 1) && boardArray[randomElement + 1] == 0) {
                    target = randomElement + 1;
                    takeControlOf(target);
                }
                if ((randomElement % numOfTiles != 0) && (boardArray[randomElement - 1] == 0)) {
                    target = randomElement - 1;
                    takeControlOf(target);
                }
            conqueredTiles.addAll(newConqueredTiles);
        }
    }
}