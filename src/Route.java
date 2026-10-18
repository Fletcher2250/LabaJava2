public class Route {
    private City destination;
    private double cost;

    public Route() {
        this.destination = null;
        this.cost = 0.0;
    }

    public Route(City destination, double cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public City getDestination() { return destination; }
    public void setDestination(City destination) { this.destination = destination; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    @Override
    public String toString() {
        return destination.getName() + ":" + (int) cost;
    }
}
