import java.util.Random;

public class CivilizationLeft extends Civilizations{
    CivilizationLeft(int startingPoint, int r, int g, int b, Board board, int [] boardArray, int id){
        super(startingPoint, r, g, b, board, boardArray, id);
    }

    @Override
    public void conquer(){
        int target;
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n == 0) {
            for (int x : conqueredTiles) {
                if (x % 10 != 0) {
                    if (boardArray[x - 1] == 0) {
                        target = x - 1;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / 10, target % 10, color);
                        return;
                    }
                }
            }
            for (int x : conqueredTiles) {
                if (x % 10 != 9) {
                    if (boardArray[x + 1] == 0) {
                        target = x + 1;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / 10, target % 10, color);
                        return;
                    }
                }
            }
            for (int x : conqueredTiles) {
                if (x < 89) {
                    if (boardArray[x + 10] == 0) {
                        target = x + 10;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / 10, target % 10, color);
                        return;
                    }
                }
            }
            for (int x : conqueredTiles) {
                if (x > 10) {
                    if (boardArray[x - 10] == 0) {
                        target = x - 10;
                        conqueredTiles.add(target);
                        boardArray[target] = this.id;
                        board.updateCell(target / 10, target % 10, color);
                        return;
                    }
                }
            }
        }
    }
}
