import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLogger {
    public static void logData(String fileName, ArrayList<Civilizations> civilizationsInPlay, int turn){
        //txt file writer
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data(civilizationsInPlay, turn));
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String data(ArrayList<Civilizations> civilizationsInPlay, int turn){
        String[][] temp = new String[civilizationsInPlay.size()][2];

        //filling the 2D temporary array with number of conquered tiles and the color of civilization
        for(int i = 0; i < civilizationsInPlay.size(); i++){
            temp[i][0] = String.valueOf(civilizationsInPlay.get(i).getConqueredTiles().size());
            temp[i][1] = String.valueOf(civilizationsInPlay.get(i).getId());
        }
        int max = 0;
        int maxId = 0;

        //searching for civilization with the highest number of conquered tiles and getting its id
        for (int i = 0; i < civilizationsInPlay.size(); i++) {
            int currentSize = Integer.parseInt(temp[i][0]);
            if (currentSize > max) {
                max = currentSize;
                maxId = i;
            }
        }
        String winner = temp[maxId][1];

        //making output printable
        String conqueredTiles = "The winner is Civilization nr " + winner + "!\n";
        conqueredTiles += "The simulation ended on turn " + turn + "!\n";
        for (int i = 0; i < temp.length; i++) {
            conqueredTiles = conqueredTiles + ("Civilization nr " + civilizationsInPlay.get(i).getId() + " conquered " + temp[i][0] + " Tiles\n");
        }
        return conqueredTiles;
    }
}
