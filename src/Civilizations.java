import java.awt.*;
import java.util.ArrayList;

abstract class Civilizations {
    int startingPoint;
    Color color;
    Board board;

    int [] boardArray;
    int id;
    int numOfTiles;
    int target;
    ArrayList<Civilizations> allCivilizations;
    ArrayList<Integer> conqueredTiles = new ArrayList<>();
    Civilizations(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles){
        this.startingPoint = startingPoint;
        this.color = colorName;
        this.board = board;
        this.boardArray = boardArray;
        this.id= id;
        this.numOfTiles = numOfTiles;
        this.allCivilizations = new ArrayList<>();
        boardArray[startingPoint] = id;
        board.updateCell(startingPoint / numOfTiles, startingPoint % numOfTiles, color);
        conqueredTiles.add(startingPoint);
    }
    public void setAllCivilizations(ArrayList<Civilizations> allCivilizations) {
        this.allCivilizations = allCivilizations;
    }
    public ArrayList<Integer> getConqueredTiles() {
        return conqueredTiles;
    }
    public int getId (){
        return id;
    }
    public Color getColor (){
        return color;
    }

    abstract void conquer();
}

