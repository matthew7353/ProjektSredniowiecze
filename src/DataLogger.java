import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLogger {
    public static void logData(String fileName, ArrayList<Civilizations> civilizationsInPlay){
        //txt file writer
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data(civilizationsInPlay));
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String data(ArrayList<Civilizations> civilizationsInPlay){
        String[][] temp = new String[civilizationsInPlay.size()][2];

        //filling the 2D temporary array with number of conquered tiles and the color of civilization
        for(Civilizations civ : civilizationsInPlay){
            temp[civ.getId() - 1][0] = String.valueOf(civ.getConqueredTiles().size());
            temp[civ.getId() - 1][1] = civ.getColor().getColorSpace().getName(civ.getId() - 1);
        }

        //searching for civilization with the highest number of conquered tiles and getting its id
        int max = 0;
        int maxId = 0;
        for (int i = 0; i < temp.length; i++) {
            int currentSize = Integer.parseInt(temp[i][0]);
            if (currentSize > max) {
                max = currentSize;
                maxId = i;
            }
        }
        String winner = temp[maxId][1];

        //making output printable
        String conqueredTiles = "The winner is " + winner + "!\n";
        for (int i = 0; i < temp.length; i++) {
            conqueredTiles = conqueredTiles + (temp[i][1] + " conquered " + temp[i][0] + " Tiles\n");
        }
        return conqueredTiles;
    }
}
