package weapons;

import exceptions.NotEnoughAmmoException;

public class Glock implements Gun {

    public static final String MODEL = "Glock";
    public static final int AMMO_SIZE = 12;
    private int ammo;

    public Glock() {
        this.ammo = AMMO_SIZE;
    }

    @Override
    public void shoot() throws NotEnoughAmmoException {
        if (ammo > 1) {
            ammo -= 1;
        } else {
            throw new NotEnoughAmmoException("Недостаточно патронов для выстрела");
        }
    }

    @Override
    public void reload() {
        this.ammo = AMMO_SIZE;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Glock glock = (Glock) o;

        return ammo == glock.ammo;
    }

    @Override
    public int hashCode() {
        return ammo;
    }

    @Override
    public String toString() {
        return "Glock{" +
                "ammo=" + ammo +
                '}';
    }
}
