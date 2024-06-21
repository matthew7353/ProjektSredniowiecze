import java.awt.*;
import java.util.ArrayList;

abstract class Civilizations {
    int startingPoint, id, numOfTiles, target, chanceToGetTile, chanceToGetEnemy, cooldown, currentCooldown;
    Color color;
    Board board;
    int [] boardArray;
    ArrayList<Civilizations> allCivilizations;
    ArrayList<Tile> conqueredTiles = new ArrayList<>();
    boolean conquerTile, conquerEnemy;
    Civilizations(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles, int chanceToGetTile, int chanceToGetEnemy, int cooldown){
        this.startingPoint = startingPoint;
        this.color = colorName;
        this.board = board;
        this.boardArray = boardArray;
        this.id= id;
        this.numOfTiles = numOfTiles;
        this.allCivilizations = new ArrayList<>();
        this.chanceToGetTile = chanceToGetTile;
        this.chanceToGetEnemy = chanceToGetEnemy;
        this.cooldown = cooldown;
        this.currentCooldown = cooldown;
        boardArray[startingPoint] = id;
        board.updateCell(startingPoint / numOfTiles, startingPoint % numOfTiles, color);
        addTile(startingPoint);
    }
    public void setAllCivilizations(ArrayList<Civilizations> allCivilizations) {
        this.allCivilizations = allCivilizations;
    }
    public int getId (){
        return id;
    }
    public Color getColor (){
        return color;
    }
    public void addTile(int target){
        conqueredTiles.add(new Tile(target, this.id, this.boardArray, this.numOfTiles));
    }
    public ArrayList<Tile> getConqueredTiles(){
        return conqueredTiles;
    }

    public void destroyTile(int target){
        for(int i = 0; i <= conqueredTiles.size(); i++){
            if(conqueredTiles.get(i).getIndex() == target){
                conqueredTiles.remove(i);
                break;
            }
        }
        if(conqueredTiles.isEmpty()){
            int civilizationsInPlay = 0;
            int winningCiv = 0;
            for(Civilizations civ: allCivilizations){
                if(!civ.civDefeated()){
                    civilizationsInPlay++;
                    winningCiv = civ.getId();
                }
            }
            if(civilizationsInPlay == 1){
                System.out.println("Civilization " + winningCiv + " has won.");
                System.exit(0);
            }
        }
    }

    public boolean civDefeated(){
        return conqueredTiles.isEmpty();
    }

    abstract void conquer();

    public void takeControlOf(int target){
        addTile(target);
        for (Civilizations civ : allCivilizations){
            if (boardArray[target] == civ.getId()){
                civ.destroyTile(target);
            }
        }
        boardArray[target] = this.id;
        board.updateCell(target / numOfTiles,target % numOfTiles, color);

    }
}

