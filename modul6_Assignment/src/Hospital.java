public class Hospital extends Building {
    private int beds;

    public Hospital(String name, String address, int floors, BuildingStatus status, int beds) {
        super(name, address, floors, status);
        this.beds = beds;
    }

    @Override
    public String getType() { return "Hospital"; }

    @Override
    public String getDetail() { return beds + " Beds"; }
}