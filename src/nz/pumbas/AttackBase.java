package nz.pumbas;

public abstract class AttackBase
{
    protected String name;
    protected int[] from;
    protected float cost;
    protected float damage;

    public abstract void doAttack();

}
