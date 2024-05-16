import java.awt.*;

public class Civilizations {
    int startingPoint;
    Color color;
    Board board;

    int [] boardArray;
    int id;
    Civilizations(int startingPoint, Color colorName, Board board, int [] boardArray, int id){
        this.startingPoint = startingPoint;
        this.color = colorName;
        this.board = board;
        this.boardArray = boardArray;
        this.id= id;
        boardArray[startingPoint] = id;
        board.updateCell(startingPoint / 10, startingPoint % 10, color);
    }
}
