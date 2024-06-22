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
        int maxId = 0;
        int currentSize = maxId;
        for (Civilizations civ : civilizationsInPlay) {
            currentSize = civ.getId();
            if (currentSize >= civ.getId()) {
                    maxId = currentSize;
            }
        }
        String[][] temp = new String[maxId+1][2];

        //filling the 2D temporary array with number of conquered tiles and the color of civilization
        for(Civilizations civ : civilizationsInPlay){
            temp[civ.getId()][0] = String.valueOf(civ.getConqueredTiles().size());
            temp[civ.getId()][1] = String.valueOf(civ.getId());
        }

        //searching for civilization with the highest number of conquered tiles and getting its id
        int maxNumberOfConqueredTiles = 0;
        int idOfMax = 0;
        for (int i = 0; i <= maxId; i++) {
            if (temp[i][0] != null) {
                int current = Integer.parseInt(temp[i][0]);
                if (current > maxNumberOfConqueredTiles) {
                    maxNumberOfConqueredTiles = current;
                    idOfMax = i;
                }
            }
        }
        String winner = temp[idOfMax][1];

        //making output printable
        String conqueredTiles = "The winner is Civilization nr " + winner + "!\n";
        conqueredTiles += "The simulation ended on turn " + turn + "!\n";
        for (int i = 0; i <= maxId; i++) {
            if (temp[i][0] != null && temp[i][1] != null) {
                conqueredTiles += ("Civilization nr " + temp[i][1] + " has conquered " + temp[i][0] + " Tiles\n");
            }
        }
        return conqueredTiles;
    }
}
