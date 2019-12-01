import creatures.Bandit;
import creatures.Policeman;
import entities.Bank;
import weapons.Glock;
import weapons.Gun;

public class Main {
    public static void main(String[] args) {
        Bank sberbank = new Bank("Сбербанк", Double.MAX_VALUE);
        Bank tinkoff = new Bank("Тинькофф", 100000);
        Gun glock = new Glock();
        Bandit bandit = new Bandit("Test Bandit", 0, 0, 1, glock, 50);
        Policeman policeman = new Policeman("Test policeman", 0, 0, 2, Policeman.PoliceRank.SERGEANT);
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
    }
}
