import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.channels.ScatteringByteChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantData  {
    public static final String SPACE  = "  ";

  //  public static Plant parsePlant(String data) {
    public void readPlantsFromFile(String filename) throws PlantException, FileNotFoundException {


        String nextLine = null;
        String[] items = new String[0];
        String name = null;
        String notes = null;
        LocalDate planted = null;
        LocalDate watering = null;
        int frequencyOfWatering = 0;
        int lineNumber = 0;


        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            while (scanner.hasNextLine()) {
                lineNumber ++;
                nextLine = scanner.nextLine();
                items = nextLine.split(SPACE);
                //  String[] items = data.split("   ");
                name = items[0];
                notes = items[1];
                planted = LocalDate.parse(items[4]);
                watering = LocalDate.parse(items[3]);
                frequencyOfWatering = Integer.parseInt(items[2]);
                Plant plantFromTxt = new Plant(name, notes, planted, watering, frequencyOfWatering);
                addPlant(plantFromTxt);

            }

            //Plant result = new Plant(name, notes, planted, watering, frequencyOfWatering);
         //   return result;
        }catch (FileNotFoundException e) {throw new PlantException("Soubor nenalezen: " + filename + e.getLocalizedMessage());
        }catch (NumberFormatException e) {throw new PlantException(items[2] +"nutno zadat celé číslo " + e.getLocalizedMessage() + "na řádku: " + lineNumber);
        }catch (DateTimeParseException e) {throw new PlantException("nesprávný formát data zasazané nebo poslední zálivky "+ items[3] +" "+ items[4]);}
    }


    File dataFile = new File("F:\\Programy JAVA\\lekce_5_du\\kvetiny.txt");
    ArrayList<Plant> listOfPlants = new ArrayList<>();
    //private String data;

    public void addPlant (Plant newPlant) {listOfPlants.add(newPlant);}

    public void removePlant(Plant deletePlant) {listOfPlants.remove(deletePlant);}
    public List<Plant> getListOfPlants() {
        return new ArrayList<>(listOfPlants);
    }


    //  public void removePlant(Plant listOfPlants()) {listOfPlants.remove();
}




