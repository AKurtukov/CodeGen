package ru.sbertech.android.codegen.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.sbertech.android.codegen.CountryReflectionFactor;

public class FactoryReflection {
    private static final List<Class<?>> mObjects = new ArrayList<>();

    public FactoryReflection(Class<?>... clazz) {
        Collections.addAll(mObjects, clazz);
    }

    public static Country create(String countryName) {
        for (Class<?> clazz : mObjects) {
            if (clazz.getAnnotation(CountryReflectionFactor.class) != null &&
                    clazz.getAnnotation(CountryReflectionFactor.class).value().equals(countryName)) {
                try {
                    Object o = clazz.newInstance();
                    if (o instanceof Country) {
                        return (Country) o;
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
