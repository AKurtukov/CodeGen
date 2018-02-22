package ru.sbertech.android.codegen.myapplication.factories;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryFactory;
import ru.sbertech.android.codegen.myapplication.loggen.Factory$$$Autogenerate;

public class FactoryProxy implements CountryFactory {

    private CountryFactory mFactory = new Factory$$$Autogenerate();

    @Override
    public Country getCountry(String name) {
        return mFactory.getCountry(name);
    }
}
