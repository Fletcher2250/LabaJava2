import java.util.ArrayList;
import java.util.List;

public class RouteCollection {
    private List<RouteV2> routes;

    public RouteCollection() {
        this.routes = new ArrayList<>();
    }

    public RouteCollection(List<RouteV2> routes) {
        this.routes = new ArrayList<>(routes);
    }

    public List<RouteV2> getRoutes() { return routes; }
    public void setRoutes(List<RouteV2> routes) { this.routes = routes; }

    public void addRoute(RouteV2 route) {
        this.routes.add(route);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < routes.size(); i++) {
            sb.append(routes.get(i).toString());
            if (i < routes.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}