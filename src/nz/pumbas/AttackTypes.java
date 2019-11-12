package nz.pumbas;

import nz.pumbas.Factory.FactoryType;

public class AttackTypes
{
    @FactoryType
    public class Slash extends AttackBase {
        public Slash() {
            name = "SLASH";
            from = new int[] {0, 1, 2, 3};
            damage = 15f;
            cost = 20f;
        }

        @Override
        public void doAttack() {
            System.out.println("Does attack: " + name + ", dealing " + damage + " damage!");
        }
    }

    @FactoryType
    public class Thrust extends AttackBase {
        public Thrust() {
            name = "THRUST";
            from = new int[] {0, 1};
            damage = 25f;
            cost = 30f;
        }

        @Override
        public void doAttack() {
            System.out.println("Does attack: " + name + ", dealing " + damage + " damage!");
        }
    }
}
