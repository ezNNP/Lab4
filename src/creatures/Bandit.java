package creatures;

import entities.Bank;
import entities.Car;
import exceptions.NotAbleToRobTheBankException;
import exceptions.NotEnoughMoneyException;
import weapons.Gun;

public class Bandit extends Creature {

    protected Gun gun; // DI
    protected double money;
    protected boolean arrested;

    public Bandit(String name, double x, double y, double speed, Gun gun, double money) {
        super(name, x, y, speed);
        this.gun = gun;
        this.money = money;
        this.arrested = false;
    }

    public void move() {
        System.out.println("Бандит по имени " + this.name + " куда-то двигается");
    }

    public void shoot() {
        gun.shoot();
        System.out.println("Бандит по имени " + this.name + " куда-то выстрелил");
    }

    public void reload() {
        gun.reload();
        System.out.println("Бандит по имени " + this.name + " перезарядил пистолет");
    }

    public void robTheBank(Bank bank, double forMoney) throws Exception {
        if (gun == null) {
            throw new NotAbleToRobTheBankException("Невозможно ограбить банк без пистолета");
        }
        if (arrested) {
            throw new NotAbleToRobTheBankException("Невозможно ограбить, так как бандит задержан");
        }
        if (bank.getMoney() < forMoney) {
            throw new NotEnoughMoneyException("Невозможно ограбить банк, так как в нем недостаточное количество денег");
        }
        gun.shoot();
        money += forMoney;
        bank.setMoney(bank.getMoney() - forMoney);
        System.out.println("Банк успешно ограблен бандитом по имени " + this.name);
    }

    public void hideTheMoney(Car car, double money) throws NotEnoughMoneyException {
        if (money > this.money) {
            throw new NotEnoughMoneyException("Недостаточно денег, чтобы спрятать их в машину");
        }
        car.setHiddenMoney(car.getHiddenMoney() + money);
        this.money -= money;
        System.out.println("Бандит по имени " + name + " спрятал " + money + " условных единиц в машине " + car.getName());
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bandit bandit = (Bandit) o;

        if (Double.compare(bandit.money, money) != 0) return false;
        if (arrested != bandit.arrested) return false;
        return gun != null ? gun.equals(bandit.gun) : bandit.gun == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (gun != null ? gun.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (arrested ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bandit{" +
                "gun=" + gun +
                ", money=" + money +
                ", arrested=" + arrested +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                '}';
    }
}
