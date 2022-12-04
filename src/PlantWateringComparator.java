import java.util.Comparator;

public class PlantWateringComparator implements Comparator<Plant> {

    //seřazení podle data zasazení
    @Override
    public int compare(Plant plant1, Plant plant2){
        if (plant1.getWatering() == null || plant2.getWatering() == null) {
            return 0;
        }else
            return plant1.getWatering().compareTo(plant2.getWatering());}
}
