import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Route> routes;

    public City() {
        this.name = "Неизвестный город";
        this.routes = new ArrayList<>();
    }

    public City(String name) {
        this.name = name;
        this.routes = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Route> getRoutes() { return routes; }
    public void setRoutes(List<Route> routes) { this.routes = routes; }

    public void addRoute(City destination, double cost) {
        this.routes.add(new Route(destination, cost));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(": [");

        for (int i = 0; i < routes.size(); i++) {
            result.append(routes.get(i).toString());
            if (i < routes.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }
}
