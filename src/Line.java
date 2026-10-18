public class Line {
    private Point startPoint;
    private Point endPoint;

    public Line() {
        this.startPoint = new Point();
        this.endPoint = new Point();
    }

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }

    public Point getStartPoint() { return startPoint; }
    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }
    public Point getEndPoint() { return endPoint; }
    public void setEndPoint(Point endPoint) { this.endPoint = endPoint; }

    @Override
    public String toString() {
        return "Линия от " + startPoint.toString() + " до " + endPoint.toString();
    }
}
