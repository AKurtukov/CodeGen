package ru.sbertech.android.codegen.myapplication.factories;

import java.util.Arrays;
import java.util.List;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryFactory;
import ru.sbertech.android.codegen.CountryReflectionFactor;

public class FactoryReflection implements CountryFactory {

    private final List<Class<?>> mFactoryClasses;

    public FactoryReflection(Class<?>... clazz) {
        mFactoryClasses = Arrays.asList(clazz);
    }

    @Override
    public Country getCountry(String name) {
        for (Class<?> clazz : mFactoryClasses) {
            if (clazz.getAnnotation(CountryReflectionFactor.class) != null &&
                    clazz.getAnnotation(CountryReflectionFactor.class).value().equals(name)) {
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
