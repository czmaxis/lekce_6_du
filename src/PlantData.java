import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.Comparator;

public class PlantData {

     ArrayList<Plant> listOfPlants = new ArrayList<>();

     public static final String SPACE  = "\t";
    public void readPlantsFromFile(String filename) throws PlantException, FileNotFoundException {
        String nextLine ="";
        String[] items = new String[0];
        String name = null;
        String notes = null;
        LocalDate planted = null;
        LocalDate watering = null;
        int frequencyOfWatering = 0;
        int lineNumber = 0;

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
      //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                items = nextLine.split("\t");
                lineNumber ++;


                name = items[0];
                notes = items[1];
                planted = LocalDate.parse(items[4]);
                watering = LocalDate.parse(items[3]);
                frequencyOfWatering = Integer.parseInt(items[2]);
                Plant plantFromTxt = new Plant(name, notes, planted, watering, frequencyOfWatering);
                addPlant(plantFromTxt);
            }
           // removePlantAtIndex(2);



        }catch (FileNotFoundException e) {throw new PlantException("Soubor nenalezen: " + filename + e.getLocalizedMessage());
        }catch (NumberFormatException e) {throw new PlantException(items[2] +"nutno zadat celé číslo " + e.getLocalizedMessage() + "na řádku: " + lineNumber);
        }catch (DateTimeParseException e) {throw new PlantException("nesprávný formát data zasazané nebo poslední zálivky "+ items[3] +" "+ items[4]+ " řádek s chybnou: " + lineNumber);}



    }

    public void writePlantsToFile(String filename) throws PlantException {
        removePlantAtIndex(2);
        Plant bazalka = new Plant("Bazalka ", " V kuchyni ",LocalDate.of(2021,4,4),LocalDate.of(2021,9,1), 3);
        addPlant(bazalka);

        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Plant plant : listOfPlants) {
                lineNumber ++;
                String outputLine =
                        plant.getName()+SPACE
                                + plant.getNotes()+SPACE
                                + plant.getFrequencyOfWatering()+SPACE
                                + plant.getWatering()+SPACE
                                + plant.getPlanted()+SPACE;
                writer.println(outputLine);


            }
        } catch (IOException e) {

            throw new PlantException ("Nastala chyba při zápisu do souboru na řádku: "+lineNumber+" " +e.getLocalizedMessage());
        }



    }




//
    public void addPlant (Plant plant) {
        listOfPlants.add(plant);}
//
    public void removePlantAtIndex(int index) {
        listOfPlants.remove(index);}

    public Plant getPlantAtIndex (int index){
        return listOfPlants.get(index);}

    public List<Plant> getListOfPlants() {
       return new ArrayList<>(listOfPlants);}




}









    //  public void removePlant(Plant listOfPlants()) {listOfPlants.remove();





