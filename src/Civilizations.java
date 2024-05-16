import java.awt.*;

public class Civilizations {
    int startingPoint;
    Color color;
    Board board;
    Civilizations(int startingPoint, int r, int g, int b, Board board){
        this.startingPoint = startingPoint;
        this.color = new Color(r, g, b);
        this.board = board;
        board.updateCell(startingPoint / 10, startingPoint % 10, color);
    }
}
