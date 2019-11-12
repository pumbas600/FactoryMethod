# Factory Manager

Factory Manager provides an easy way to quickly implement many 
different Factory Method Patterns into your code. 

## Usage:

**Note:** All classes involved in this process must be public or package-private.

Begin by constructing a parent class which will be extended by all following child classes in the pattern.

``` java
public abstract class AttackBase
{
    protected String name;
    protected int[] from;
    protected float cost;
    protected float damage;

    public abstract void doAttack();
}
```

Next, create as many child classes as you want extending your parent class, however, they must be nested within another
class, be annotated with the *@FactoryType* annotation and have a constructor with no parameters. Note they don't all need to be nested within the same class.

There are 2 optional parameters for the @FactoryType annotation:

***enabled*** - *default:* true. 

***key*** - *default:* class name. - This can be changed to whatever string you would like to use as the key to your class.

``` java
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
```

Finally, in your main class you can create a **FactoryManager** object using the following syntax:

```java
FactoryManager<child_class> attackFactoryManager = new FactoryManager<>(encapsulating_class.class);

//If you have multiple encapsulating classes, they can be added like so:

FactoryManager<child_class> attackFactoryManager = new FactoryManager<>(class1.class, class2.class, etc);
```

From then on, you can get make on object like so:

```java
FactoryManager<AttackBase> attackFactoryManager = new FactoryManager<>(AttackTypes.class);

AttackBase thrust = attackFactoryManager.getClass("Thrust");
AttackBase slash = attackFactoryManager.getClass("Slash");

thrust.doAttack();
slash.doAttack();
```

