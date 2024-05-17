import java.awt.*;
import java.util.ArrayList;

public class Civilizations {
    int startingPoint;
    Color color;
    Board board;

    int [] boardArray;
    int id;
    ArrayList<Integer> conqueredTiles = new ArrayList<>();
    Civilizations(int startingPoint, int r, int g, int b, Board board, int [] boardArray, int id){
        this.startingPoint = startingPoint;
        this.color = new Color(r, g, b);
        this.board = board;
        this.boardArray = boardArray;
        this.id= id;
        boardArray[startingPoint] = id;
        board.updateCell(startingPoint / 10, startingPoint % 10, color);
        conqueredTiles.add(startingPoint);
    }

    public void conquer(){
        System.out.println(this.id);
    }
}

