package creatures;

public class Policeman extends Creature {

    private PoliceRank rank;

    public Policeman(String name, double x, double y, double speed, PoliceRank rank) {
        super(name, x, y, speed);
        this.rank = rank;
    }

    @Override
    public void move() {
        System.out.println("Полицейский по имени " + this.getName() + " куда то двигается");
    }

    public void arrest(Bandit bandit) {
        if (this.getSpeed() > bandit.getSpeed()) {
            bandit.setArrested(true);
            System.out.println("Полицейский по имени " + this.getName() + " задержал бандита по имени " + bandit.getName());
        } else {
            System.out.println("Полицейский по имени " + this.getName() + " не смог задержать бандита по имени " + bandit.getName());
        }
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
                '}';
    }
}
