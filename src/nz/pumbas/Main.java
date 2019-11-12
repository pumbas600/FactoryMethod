package nz.pumbas;

import nz.pumbas.Factory.FactoryManager;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        FactoryManager<ClassBase> factoryManager = new FactoryManager<>(ClassTypes.class);
        FactoryManager<AttackBase> attackFactoryManager = new FactoryManager<>(AttackTypes.class);

        ClassBase footSoldier = factoryManager.getClass("FootSoldier");
        footSoldier.classShout();

        ClassBase archer = factoryManager.getClass("Archer");
        archer.classShout();

        ClassBase knight = factoryManager.getClass("knight");
        knight.classShout();

        knight.doAttack(attackFactoryManager.getClass("Thrust"));
        footSoldier.doAttack(attackFactoryManager.getClass("Slash"));
    }
}


