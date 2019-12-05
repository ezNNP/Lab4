package creatures;

import entities.Car;

public class MicroChelik extends Creature {

    private boolean bold;

    public MicroChelik(String name, double x, double y, double speed, boolean bold) {
        super(name, x, y, speed);
        this.bold = bold;
    }

    public void cutTheWheels(Car car) {
        if (car.getHiddenMoney() > 0) {
            car.setWorking(false);
            System.out.println("Микрочелик по имени " + this.getName() + " проколол колеса машины и нашел машину с деньгами");
        } else {
            car.setWorking(false);
            System.out.println("Микрочелик по имени " + this.getName() + " проколол колеса машины и не нашел машину с деньгами");
        }
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MicroChelik that = (MicroChelik) o;

        return bold == that.bold;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bold ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MicroChelik{" +
                "bold=" + bold +
                '}';
    }
}
