import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class CivilizationNext extends Civilizations{
    CivilizationNext(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles, int chanceToGetTile, int chanceToGetEnemy, int cooldown) {
        super(startingPoint, colorName, board, boardArray, id, numOfTiles, chanceToGetTile, chanceToGetEnemy, cooldown);
    }

    @Override
    public void conquer(){
        //checking for cooldown
        if(currentCooldown == 0 && !conqueredTiles.isEmpty()) {

            // choosing the next tile that can conquer
            Random rand = new Random();
            Tile nextElement = null;
            for(int i = 0; i < conqueredTiles.size(); i++){
                nextElement = conqueredTiles.get(i);
                if(nextElement.chooseTile()){
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

            if (nextElement.canTop() && boardArray[nextElement.getIndex() - numOfTiles] == 0 && conquerTile) {
                target = nextElement.getIndex() - numOfTiles;
                takeControlOf(target);
            }
            else if (nextElement.canTop() && boardArray[nextElement.getIndex() - numOfTiles] != this.id && conquerEnemy) {
                target = nextElement.getIndex() - numOfTiles;
                takeControlOf(target);
            }
            else if (nextElement.canLeft() && boardArray[nextElement.getIndex() - 1] == 0 && conquerTile) {
                target = nextElement.getIndex() - 1;
                takeControlOf(target);
            }
            else if (nextElement.canLeft() && boardArray[nextElement.getIndex() - 1] != this.id && conquerEnemy) {
                target = nextElement.getIndex() - 1;
                takeControlOf(target);

            }
            else if (nextElement.canRight() && boardArray[nextElement.getIndex() + 1] == 0 && conquerTile) {
                target = nextElement.getIndex() + 1;
                takeControlOf(target);
            }
            else if (nextElement.canRight() && boardArray[nextElement.getIndex() + 1] != this.id && conquerEnemy) {
                target = nextElement.getIndex() + 1;
                takeControlOf(target);
            }
            else if (nextElement.canBot() && boardArray[nextElement.getIndex() + numOfTiles] == 0 && conquerTile) {
                target = nextElement.getIndex() + numOfTiles;
                takeControlOf(target);
            }
            else if (nextElement.canBot() && boardArray[nextElement.getIndex() + numOfTiles] != this.id && conquerEnemy) {
                target = nextElement.getIndex() + numOfTiles;
                takeControlOf(target);
            }
            currentCooldown = cooldown;
        }
        else{
            currentCooldown--;
        }
    }
}