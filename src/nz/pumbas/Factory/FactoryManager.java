package nz.pumbas.Factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class FactoryManager<T>
{
    private static HashMap<String, Class<?>> subClasses = new HashMap<>();

    private static void scanForAnnotations(Class<?> clazz){
        for (Class<?> subClass : clazz.getDeclaredClasses()) {
            if (!subClass.isAnnotationPresent(FactoryType.class)) continue;
            FactoryType factoryType = subClass.getAnnotation(FactoryType.class);

            if (!factoryType.enabled()) continue;
            if (factoryType.key().equals("")) {
                subClasses.put(subClass.getSimpleName().toUpperCase(), subClass);
            }
            else {
                subClasses.put(factoryType.key().toUpperCase(), subClass);
            }
        }
    }

    public FactoryManager(Class<?>... parentClasses) {
        if (parentClasses.length == 0) return;
        for (Class<?> clazz : parentClasses)
        {
            scanForAnnotations(clazz);
        }
    }

    @SuppressWarnings("unchecked")
    public T getClass(String clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        Class<?> resultClass = FactoryManager.subClasses.get(clazz.toUpperCase());
        if (resultClass == null) return null;

        Class<?> outerClass = resultClass.getEnclosingClass();

        try
        {
            if (outerClass == null)
            {
                return (T) resultClass.newInstance();
            }
            else return (T) resultClass
                    .getDeclaredConstructor(outerClass)
                    .newInstance(
                            outerClass.newInstance()
                    );
        }
        catch (ClassCastException e) {
            return null;
        }
    }


}
