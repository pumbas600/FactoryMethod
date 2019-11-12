package nz.pumbas;

import nz.pumbas.Factory.FactoryType;

public class ClassTypes
{

    @FactoryType
    public class FootSoldier extends ClassBase {
        public FootSoldier() {
            health = 100f;
            stamina = 100f;
            speed = 20f;
            name = "FOOT_SOLDIER";
        }

        @Override
        public void classShout()
        {
            System.out.println(name + ": We fight for freedoom!");
        }
    }

    @FactoryType
    public class Archer extends ClassBase
    {
        public Archer()
        {
            health = 80f;
            stamina = 110f;
            speed = 25f;
            name = "ARCHER";
        }

        @Override
        public void classShout()
        {
            System.out.println(name + ": We shoot for freedoom!");
        }
    }

    @FactoryType
    public class Knight extends ClassBase {
        public Knight() {
            health = 150f;
            stamina = 85f;
            speed = 10f;
            name = "Knight";
        }

        @Override
        public void classShout()
        {
            System.out.println(name + ": We fight for honour!");
        }
    }
}
