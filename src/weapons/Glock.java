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
}
