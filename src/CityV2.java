import java.util.List;

public class CityV2 {
    private String name;
    private RouteCollection routes;

    public CityV2(String name) {
        this.name = name;
        this.routes = new RouteCollection();
    }

    public CityV2(String name, RouteCollection routes) {
        this.name = name;
        this.routes = routes;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public RouteCollection getRoutes() { return routes; }
    public void setRoutes(RouteCollection routes) { this.routes = routes; }

    @Override
    public String toString() {
        return name + ": " + routes.toString();
    }
}