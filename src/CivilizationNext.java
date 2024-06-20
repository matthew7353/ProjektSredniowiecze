import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class CivilizationNext extends Civilizations{
    CivilizationNext(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles, int chanceToGetTile, int chanceToGetEnemy, int cooldown) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles, chanceToGetTile, chanceToGetEnemy, cooldown);
    }
    public void takeControlOf(int target){
        for (Civilizations civ : allCivilizations){
            if (boardArray[target] == civ.getId()){
                civ.destroyTile(target);
            }
        }
        addTile(target);
        boardArray[target] = this.id;
        board.updateCell(target / numOfTiles,target % numOfTiles, color);

    }
    @Override
    public void conquer(){
        //checking for cooldown
        if(currentCooldown == 0 && !conqueredTiles.isEmpty()) {

            // choosing random tile that can conquer
            Random rand = new Random();
            Tile randomElement = null;
            for(int i = 0; i < conqueredTiles.size(); i++){
                randomElement = conqueredTiles.get(i);
                if(randomElement.chooseTile()){
                    break;
                }
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
            if (randomElement.canBot() && boardArray[randomElement.getIndex() + numOfTiles] == 0 && conquerTile) {
                target = randomElement.getIndex() + numOfTiles;
                takeControlOf(target);
            }
            else if (randomElement.canBot() && boardArray[randomElement.getIndex() + numOfTiles] != this.id && conquerEnemy) {
                target = randomElement.getIndex() + numOfTiles;
                takeControlOf(target);
            }
            else if (randomElement.canTop() && boardArray[randomElement.getIndex() - numOfTiles] == 0 && conquerTile) {
                target = randomElement.getIndex() - numOfTiles;
                takeControlOf(target);
            }
            else if (randomElement.canTop() && boardArray[randomElement.getIndex() - numOfTiles] != this.id && conquerEnemy) {
                target = randomElement.getIndex() - numOfTiles;
                takeControlOf(target);
            }
            else if (randomElement.canRight() && boardArray[randomElement.getIndex() + 1] == 0 && conquerTile) {
                target = randomElement.getIndex() + 1;
                takeControlOf(target);
            }
            else if (randomElement.canRight() && boardArray[randomElement.getIndex() + 1] != this.id && conquerEnemy) {
                target = randomElement.getIndex() + 1;
                takeControlOf(target);
            }
            else if (randomElement.canLeft() && boardArray[randomElement.getIndex() - 1] == 0 && conquerTile) {
                target = randomElement.getIndex() - 1;
                takeControlOf(target);
            }
            else if (randomElement.canLeft() && boardArray[randomElement.getIndex() - 1] != this.id && conquerEnemy) {
                target = randomElement.getIndex() - 1;
                takeControlOf(target);
            }
            currentCooldown = cooldown;
        }
        else{
            currentCooldown--;
        }
    }
}