package entities;

import creatures.Creature;
import exceptions.NotEnoughFuelException;

import java.util.ArrayList;

public class Car implements Drivable {
    private ArrayList<Creature> creatures;
    private double fuel;
    private double fuelPerDrive;

    public Car(ArrayList<Creature> creatures, double fuel, double fuelPerDrive) {
        this.creatures = creatures;
        this.fuel = fuel;
        this.fuelPerDrive = fuelPerDrive;
    }

    public void kickOutOfCar(Creature creature) {
        for (Creature c : creatures) {
            if (c.equals(creature)) {
                System.out.println("Из машины был выкинут кто-то по имени " + c.getName());
                creatures.remove(c);
            }
        }
    }

    @Override
    public void drive() throws NotEnoughFuelException {
        fuel -= fuelPerDrive;
        if (fuel < 0) {
            fuel += fuelPerDrive;
            throw new NotEnoughFuelException("Недостаточное количество топлива");
        }
        System.out.println("Машина успешно проехала");
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
}
