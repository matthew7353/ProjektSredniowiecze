import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class CivilizationCircle extends Civilizations{
    CivilizationCircle(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles, int chanceToGetTile, int chanceToGetEnemy, int cooldown) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles, chanceToGetTile, chanceToGetEnemy, cooldown);
    }
    public void takeControlOf(int target){
        for (Civilizations civ : allCivilizations){
            if (boardArray[target] == civ.getId() && civ.conqueredTiles.contains(target)){
                for(int i = 0; i <= civ.conqueredTiles.size(); i++){
                    if(civ.conqueredTiles.get(i) == target){
                        civ.conqueredTiles.remove(i);
                        break;
                    }
                }
            }
        }
        conqueredTiles.add(target);
        boardArray[target] = this.id;
        board.updateCell(target / numOfTiles,target % numOfTiles, color);

    }
    @Override
    public void conquer(){
        //checking for cooldown
        if(currentCooldown == 0 && !conqueredTiles.isEmpty()) {

            // choosing random tile that can conquer
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

            // checking what conquers civ can do
            int n = rand.nextInt(101);
            conquerTile = false;
            conquerEnemy = false;
            if (n <= chanceToGetTile) {
                conquerTile = true;
            }
            if (n <= chanceToGetEnemy) {
                conquerEnemy = true;
            }

            // conquering another tiles
            if ((randomElement < numOfTiles * (numOfTiles - 1)) && boardArray[randomElement + numOfTiles] == 0 && conquerTile) {
                target = randomElement + numOfTiles;
                takeControlOf(target);
            }
            else if ((randomElement < numOfTiles * (numOfTiles - 1)) && boardArray[randomElement + numOfTiles] != this.id && conquerEnemy) {
                target = randomElement + numOfTiles;
                takeControlOf(target);
            }
            else if ((randomElement > numOfTiles) && boardArray[randomElement - numOfTiles] == 0 && conquerTile) {
                target = randomElement - numOfTiles;
                takeControlOf(target);
            }
            else if ((randomElement > numOfTiles) && boardArray[randomElement - numOfTiles] != this.id && conquerEnemy) {
                target = randomElement - numOfTiles;
                takeControlOf(target);
            }
            else if ((randomElement % numOfTiles != numOfTiles - 1) && boardArray[randomElement + 1] == 0 && conquerTile) {
                target = randomElement + 1;
                takeControlOf(target);
            }
            else if ((randomElement % numOfTiles != numOfTiles - 1) && boardArray[randomElement + 1] != this.id && conquerEnemy) {
                target = randomElement + 1;
                takeControlOf(target);
            }
            else if ((randomElement % numOfTiles != 0) && boardArray[randomElement - 1] == 0 && conquerTile) {
                target = randomElement - 1;
                takeControlOf(target);
            }
            else if ((randomElement % numOfTiles != 0) && boardArray[randomElement - 1] != this.id && conquerEnemy) {
                target = randomElement - 1;
                takeControlOf(target);
            }
            currentCooldown = cooldown;
        }
        else{
            currentCooldown--;
        }
    }
}