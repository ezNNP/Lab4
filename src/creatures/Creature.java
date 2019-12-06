package creatures;

public abstract class Creature implements Moveable {
    protected String name;
    protected double x, y;
    protected double speed;

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

    public void move() {
        System.out.println("Кто-то с именем " + name + " куда-то идет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        if (Double.compare(creature.x, x) != 0) return false;
        if (Double.compare(creature.y, y) != 0) return false;
        if (Double.compare(creature.speed, speed) != 0) return false;
        return name.equals(creature.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(speed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                '}';
    }
}
