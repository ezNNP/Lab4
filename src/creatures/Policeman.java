package creatures;

public class Policeman extends Creature {

    private PoliceRank rank;

    public Policeman(String name, double x, double y, double speed, PoliceRank rank) {
        super(name, x, y, speed);
        this.rank = rank;
    }

    @Override
    public void move() {
        System.out.println("Полицейский по имени " + this.name + " куда то двигается");
    }

    public void arrest(Bandit bandit) {
        if (this.getSpeed() > bandit.getSpeed()) {
            bandit.setArrested(true);
            System.out.println("Полицейский по имени " + this.name + " задержал бандита по имени " + bandit.name);
        } else {
            System.out.println("Полицейский по имени " + this.name + " не смог задержать бандита по имени " + bandit.name);
        }
    }

    public void arrest(MicroChelik microChelik) {
        if (this.getSpeed() > microChelik.getSpeed()) {
            if (microChelik.isBold()) {
                System.out.println("Полицейский по имени " + this.name + " задержал микрочелика по имени " + microChelik.name + " потому-что он лысый");
            } else {
                System.out.println("Полицейский по имени " + this.name + " не задержал микрочелика по имени " + microChelik.name + " потому-что он с волосами");
            }
        } else {
            System.out.println("Полицейский по имени " + this.name + " не смог догнать микрочелика по имени " + microChelik.name);
        }
    }

    public void createFindings() {
        System.out.println("1) " + this.name + " не смог найти чемодан");
        System.out.println("2) " + this.name + " нашел одного дохлого кота");
        System.out.println("3) " + this.name + " обрушил стену дома от того, что сместил почву");
    }

    public enum PoliceRank {
        PRIVATE,
        SERGEANT,
        PETTY_OFFICER,
        ENSIGN,
        LIEUTENANT,
        MAYOR,
        COLONEL
    }

    public PoliceRank getRank() {
        return rank;
    }

    public void setRank(PoliceRank rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Policeman policeman = (Policeman) o;

        return rank == policeman.rank;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Policeman{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                '}';
    }
}
