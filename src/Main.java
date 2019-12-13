import creatures.Bandit;
import creatures.CyberBandit;
import creatures.MicroChelik;
import creatures.Policeman;
import entities.Bank;
import entities.Car;
import weapons.Glock;
import weapons.Gun;

import java.lang.reflect.Field;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Bank sberbank = new Bank("Сбербанк", Double.MAX_VALUE);
        Bank tinkoff = new Bank("Тинькофф", 100000);
        Gun glock = new Glock();
        Bandit bandit = new Bandit("Инкогнито", 0, 0, 3, glock, 50);

        Policeman policeman = new Policeman("Пшигль", 0, 0, 2, Policeman.PoliceRank.SERGEANT);
        Policeman policeman2 = new Policeman("Дигль", 0, 0, 2, Policeman.PoliceRank.SERGEANT);
        Policeman policeman3 = new Policeman("Гигль", 0, 0, 2, Policeman.PoliceRank.SERGEANT);
        Policeman policeman4 = new Policeman("Спигль", 0, 0, 2, Policeman.PoliceRank.SERGEANT);

        Car car = new Car("Mercedes",10, 5);
        Car car2 = new Car("Lada",50, 2);
        Car car3 = new Car("Jeep",100, 4);
        Car car4 = new Car("Priora",50, 2.5);
        Car car5 = new Car("Ferrari",10, 5);
        Car car6 = new Car("Volksvagen",10, 5);
        car.drive();
        try {
            bandit.robTheBank(sberbank, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            bandit.robTheBank(tinkoff, 1000000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < 14; i++) {
            try {
                bandit.shoot();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                bandit.reload();
                break;
            }
        }
        bandit.shoot();
        policeman.arrest(bandit);
        Bandit bandit_no_gun = new Bandit("БезПистолетный", 1, 1, 3, null, 0);
        try {
            bandit_no_gun.robTheBank(sberbank, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        car.addCreature(bandit);
        car.addCreature(bandit_no_gun);
        while (true) {
            try {
                car.drive();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        car.kickOutOfCar(bandit_no_gun);
        try {
            bandit.hideTheMoney(car, bandit.getMoney());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MicroChelik chelik1 = new MicroChelik("Коротышка Пупсень", 0, 0, 1, false);
        MicroChelik chelik2 = new MicroChelik("Коротышка Вупсень", 0, 0, 1, true);
        MicroChelik chelik3 = new MicroChelik("Коротышка Крупсень", 0, 0, 3, false);
        MicroChelik chelik4 = new MicroChelik("Коротышка Лупсень", 0, 0, 3, true);

        chelik1.cutTheWheels(car2);
        chelik2.cutTheWheels(car3);
        chelik3.cutTheWheels(car4);
        chelik4.cutTheWheels(car5);
        chelik1.cutTheWheels(car6);

        policeman.arrest(chelik1);
        policeman2.arrest(chelik2);
        policeman3.arrest(chelik3);
        policeman4.arrest(chelik4);

        Bank bankReflection = new Bank("Bank", 100);
        CyberBandit cyberBandit = new CyberBandit("CyberBandit", 0, 0, 100, null, 10);

        Field f = ClassLoader.class.getDeclaredField("classes");
        f.setAccessible(true);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Vector<Class> classes =  (Vector<Class>) f.get(classLoader);
        for (Class clazz : classes) {
            Class superClass = clazz.getSuperclass();
            if (superClass != null) {
                if (superClass.getSuperclass() != null) {
                    System.out.println("For " + clazz.getSimpleName() + " parent of parent is " + superClass.getSuperclass().getSimpleName());
                } else {
                    System.out.println("For " + clazz.getSimpleName() + " parent is " + superClass.getSimpleName());
                }
            }
        }
    }
}
