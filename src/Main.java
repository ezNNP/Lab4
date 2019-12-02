import creatures.Bandit;
import creatures.Policeman;
import entities.Bank;
import entities.Car;
import weapons.Glock;
import weapons.Gun;

public class Main {
    public static void main(String[] args) {
        Bank sberbank = new Bank("Сбербанк", Double.MAX_VALUE);
        Bank tinkoff = new Bank("Тинькофф", 100000);
        Gun glock = new Glock();
        Bandit bandit = new Bandit("Test Bandit", 0, 0, 1, glock, 50);
        bandit.move();
        Policeman policeman = new Policeman("Test policeman", 0, 0, 2, Policeman.PoliceRank.SERGEANT);
        policeman.move();
        try {
            bandit.robTheBank(sberbank, 100);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            bandit.robTheBank(tinkoff, 1000000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        policeman.arrest(bandit);
        for (int i = 0; i < 14; i++) {
            try {
                bandit.shoot();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                bandit.reload();
                break;
            }
        }
        bandit.shoot();
        Bandit bandit_no_gun = new Bandit("Bandit_No_Gun", 1, 1, 3, null, 0);
        try {
            bandit_no_gun.robTheBank(sberbank, 10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Car car = new Car(null, 10, 5);
        car.addCreature(bandit);
        car.addCreature(bandit_no_gun);
        while (true) {
            try {
                car.drive();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                break;
            }
        }
        car.kickOutOfCar(bandit);
    }
}
