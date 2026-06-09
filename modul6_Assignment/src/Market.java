public class Market extends Building {
    private double revenue;

    public Market(String name, String address, int floors, BuildingStatus status, double revenue) {
        super(name, address, floors, status);
        this.revenue = revenue;
    }

    @Override
    public String getType() { return "Market"; }

    @Override
    public String getDetail() { return "Rev: $" + revenue; }
}