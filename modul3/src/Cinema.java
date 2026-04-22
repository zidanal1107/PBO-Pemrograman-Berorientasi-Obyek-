public class Cinema extends Building {
    int ticket;

    public Cinema (String name, String address, int numberOfFloors, int ticket) {
        super(name, address, numberOfFloors);
        this.ticket = ticket;
    }

    @Override
    public void showBuildings() {
        super.showBuildings();
        System.out.println("Cinema Details");
        System.out.println("Cinema ticket\t\t\t: "+ ticket);
        System.out.println("======================================");
    }
}
