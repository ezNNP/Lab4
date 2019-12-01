package creatures;

import entities.Bank;
import exceptions.NotAbleToRobTheBankException;
import exceptions.NotEnoughMoneyException;
import weapons.Gun;

public class Bandit extends Creature {

    private Gun gun; // DI
    private double money;
    private boolean arrested;

    public Bandit(String name, double x, double y, double speed, Gun gun, double money) {
        super(name, x, y, speed);
        this.gun = gun;
        this.money = money;
        this.arrested = false;
    }

    public void move() {
        System.out.println("Бандит по имени " + this.getName() + " куда-то двигается");
    }

    public void shoot() {
        gun.shoot();
        System.out.println("Бандит по имени " + this.getName() + " куда-то выстрелил");
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
        System.out.println("Банк успешно ограблен бандитом по имени " + this.getName());
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
}
