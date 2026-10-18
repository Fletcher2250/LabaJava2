public class RouteV2 {
    private CityV2 destination;
    private double cost;

    public RouteV2() {
        this.destination = null;
        this.cost = 0.0;
    }

    public RouteV2(CityV2 destination, double cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public CityV2 getDestination() { return destination; }
    public void setDestination(CityV2 destination) { this.destination = destination; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    @Override
    public String toString() {
        return destination.getName() + ":" + (int) cost;
    }
}