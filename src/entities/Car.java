package entities;

import creatures.Creature;
import exceptions.NotEnoughFuelException;

import java.util.ArrayList;

public class Car implements Drivable {
    private String name;
    private ArrayList<Creature> creatures;
    private double fuel;
    private double fuelPerDrive;
    private double hiddenMoney;
    private boolean working;

    public Car(String name, ArrayList<Creature> creatures, double fuel, double fuelPerDrive) {
        this.name = name == null ? "Default" : name;
        this.creatures = creatures == null ? new ArrayList<>() : creatures;
        this.fuel = fuel;
        this.fuelPerDrive = fuelPerDrive;
        this.working = true;
    }

    public Car(String name, double fuel, double fuelPerDrive) {
        this.name = name == null ? "Default" : name;
        this.creatures = new ArrayList<>();
        this.fuel = fuel;
        this.fuelPerDrive = fuelPerDrive;
        this.working = true;
    }

    public void kickOutOfCar(Creature creature) {
        for (Creature c : creatures) {
            if (c.equals(creature)) {
                System.out.println("Из машины был выкинут кто-то по имени " + c.getName());
                creatures.remove(c);
                break;
            }
        }
        System.out.println("Произошел обман, и никого в машине по имени " + creature.getName() + " обнаружено не было");
    }

    @Override
    public void drive() throws NotEnoughFuelException {
        if (creatures.size() == 0) {
            System.out.println("Некому вести машину, добавьте кого-нибудь");
            return;
        }
        if (!working) {
            System.out.println("Машина не работает");
            return;
        }
        fuel -= fuelPerDrive;
        if (fuel < 0) {
            fuel += fuelPerDrive;
            throw new NotEnoughFuelException("Недостаточное количество топлива");
        }
        System.out.println("Машина успешно проехала");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public void addCreature(Creature creature) {
        this.creatures.add(creature);
        System.out.println("Кто-то по имени " + creature.getName() + " сел в машину");
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelPerDrive() {
        return fuelPerDrive;
    }

    public void setFuelPerDrive(double fuelPerDrive) {
        this.fuelPerDrive = fuelPerDrive;
    }

    public double getHiddenMoney() {
        return hiddenMoney;
    }

    public void setHiddenMoney(double hiddenMoney) {
        this.hiddenMoney = hiddenMoney;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.fuel, fuel) != 0) return false;
        if (Double.compare(car.fuelPerDrive, fuelPerDrive) != 0) return false;
        if (Double.compare(car.hiddenMoney, hiddenMoney) != 0) return false;
        if (working != car.working) return false;
        if (!name.equals(car.name)) return false;
        return creatures.equals(car.creatures);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + creatures.hashCode();
        temp = Double.doubleToLongBits(fuel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelPerDrive);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hiddenMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (working ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", creatures=" + creatures +
                ", fuel=" + fuel +
                ", fuelPerDrive=" + fuelPerDrive +
                ", hiddenMoney=" + hiddenMoney +
                ", working=" + working +
                '}';
    }
}
