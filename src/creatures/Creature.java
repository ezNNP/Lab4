package creatures;

public abstract class Creature implements Moveable {
    private String name;
    private double x, y;
    private double speed;

    public Creature(String name, double x, double y, double speed) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
