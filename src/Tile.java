public class Tile {
    private int index, id, numOfTiles;
    private boolean goTop, goBot, goLeft, goRight;
    int [] boardArray;
    Tile(int index, int id, int [] boardArray, int numOfTiles){
        this.index = index;
        this.id = id;
        this.boardArray = boardArray;
        this.numOfTiles = numOfTiles;

    }

    public boolean chooseTile(){
        goTop = false;
        goBot = false;
        goLeft = false;
        goRight = false;
        boolean result = false;
        if(index > numOfTiles){
            if(boardArray[index - numOfTiles] != id){
                result = true;
                goTop = true;
            }
        }
        if (index < numOfTiles*(numOfTiles - 1)){
            if(boardArray[index + numOfTiles] != id){
                result = true;
                goBot = true;
            }
        }
        if (index % numOfTiles != numOfTiles - 1){
            if(boardArray[index + 1] != id){
                result = true;
                goRight = true;
            }
        }
        if (index % numOfTiles != 0){
            if(boardArray[index - 1] != id){
                result = true;
                goLeft = true;
            }
        }
        return result;
    }

    public boolean canTop(){
        return goTop;
    }

    public boolean canBot(){
        return goBot;
    }

    public boolean canRight(){
        return goRight;
    }

    public boolean canLeft(){
        return goLeft;
    }

    public int getIndex(){
       return index;
    }
}
