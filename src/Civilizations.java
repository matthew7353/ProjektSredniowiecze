import java.awt.*;
import java.util.ArrayList;

abstract class Civilizations {
    int startingPoint;
    Color color;
    Board board;

    int [] boardArray;
    int id;
    int numOfTiles;
    ArrayList<Integer> conqueredTiles = new ArrayList<>();
    Civilizations(int startingPoint, Color colorName, Board board, int [] boardArray, int id, int numOfTiles){
        this.startingPoint = startingPoint;
        this.color = colorName;
        this.board = board;
        this.boardArray = boardArray;
        this.id= id;
        this.numOfTiles = numOfTiles;
        boardArray[startingPoint] = id;
        board.updateCell(startingPoint / numOfTiles, startingPoint % numOfTiles, color);
        conqueredTiles.add(startingPoint);
    }

    abstract void conquer();
}

