import java.time.LocalDate;
import java.util.*;
import java.io.FileNotFoundException;

public class Main {
    public static final String FILENAME = "F:\\Programy JAVA\\lekce_5_du\\kvetiny.txt";
    public static final String OUTPUTFILENAME = "F:\\Programy JAVA\\lekce_5_du\\kvetiny - kopie.txt";


    public static void main(String[] args) throws  FileNotFoundException, PlantException {
        PlantData list = new PlantData();
        try {
            list.readPlantsFromFile(FILENAME);
        }catch (PlantException e){
            System.err.println("chyba při čtení souboru: "+ e.getLocalizedMessage());

        }
        List<Plant> listOfplants = list.getListOfPlants();
        System.out.println(listOfplants);
        for (Plant plant : listOfplants){
            //System.out.println(plant.getName()+" "+ plant.getNotes()+" "+plant.getPlanted()+" "+plant.getWatering()+" "+plant.getFrequencyOfWatering());
           System.out.println(plant.getWateringInfo());
        }

//        listOfplants.remove(2);
//        Plant bazalka = new Plant("Bazalka ", " V kuchyni ",LocalDate.of(2021,4,4),LocalDate.of(2021,9,1), 3);
//       // listOfplants.add(bazalka);


        try {
            list.writePlantsToFile(OUTPUTFILENAME);
        }catch (PlantException e){
            System.err.println("nastala chyba při zápisu do souboru " + e.getLocalizedMessage());
        }


        try {
            list.readPlantsFromFile(OUTPUTFILENAME);

        }catch (PlantException e){
            System.err.println("chyba při čtení souboru: "+ e.getLocalizedMessage());
            }

        System.out.println("seřazení rostlin podle jména:\n ");

        Collections.sort(listOfplants);
        listOfplants.forEach(n -> {System.out.println(n.getName());});

        System.out.println("seřazení rostlin podle poslední zálivky:\n ");

        // listOfplants.sort(Comparator.comparing(plant -> plant.getPlanted()));
       Collections.sort(listOfplants, new PlantWateringComparator());
       // Collections.sort(listOfplants, (plant1, plant2) -> plant1.getPlanted().compareTo(plant2.getPlanted()));
        listOfplants.forEach(n -> {System.out.println(n.getName() +" "+ n.getWatering());});

        System.out.println("dny kdy proběhlo zasazení rostliny:\n ");

        Set<LocalDate> dataZasazení = new HashSet();
        for (Plant plant : listOfplants){
            dataZasazení.add(plant.getPlanted());
        }
        System.out.println(dataZasazení.toString());

        System.out.println("zasazené rostliny za poslední měsíc: \n");

        Plant ruze = new Plant("růže","test",LocalDate.of(2022,12,1),LocalDate.of(2022,12,2),2);
        listOfplants.add(ruze);

        //System.out.println(LocalDate.now().minusMonths(1));
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        for (Plant plant : listOfplants){
            if (plant.getPlanted().isAfter(lastMonth) || plant.getPlanted().isEqual(lastMonth)){
                System.out.println(plant.getName()+ " " + plant.getPlanted());
            }

        }









    }



//
//            Plant ruze = new Plant("růže", "test", LocalDate.of(1998,5,11), LocalDate.of(1999,5,11), -11);
//            ArrayList<Plant> listOfPlants = new ArrayList<>();
//            listOfPlants.add(ruze);







    }



