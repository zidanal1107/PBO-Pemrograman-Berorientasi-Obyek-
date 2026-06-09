import java.util.ArrayList;
import java.util.List;

public class BuildingManager {
    private List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building b) {
        buildings.add(b);
    }

    public void removeBuilding(Building b) {
        buildings.remove(b);
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}