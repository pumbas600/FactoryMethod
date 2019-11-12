package nz.pumbas;

public abstract class ClassBase
{

    protected float speed;
    protected float health;
    private final float MAX_HEALTH = health;
    protected float stamina;
    private final float MAX_STAMINA = stamina;
    protected boolean dead = false;
    protected String name;
    protected Inventory inventory;

    public void doAttack(AttackBase attack) {
        attack.doAttack();
    }


    public void loseHealth(float loss) {
        health -= loss;
        if (health <= 0) {
            health = 0;
            dead = true;
        }
    }

    public void gainHealth(float gain) {
        health += gain;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public void loseStamina(float loss) {
        stamina -= loss;
        if (stamina < 0) {
            stamina = 0;
        }
    }

    public void gainStamina(float gain) {
        stamina += gain;
        if (stamina > MAX_STAMINA) {
            stamina = MAX_STAMINA;
        }
    }

    public abstract void classShout();

}
