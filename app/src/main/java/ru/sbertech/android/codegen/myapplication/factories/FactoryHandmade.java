package ru.sbertech.android.codegen.myapplication.factories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryFactory;
import ru.sbertech.android.codegen.myapplication.сountry.Germany;
import ru.sbertech.android.codegen.myapplication.сountry.Russia;
import ru.sbertech.android.codegen.myapplication.сountry.USA;

public class FactoryHandmade implements CountryFactory {

    private final Map<String, Country> mFactoryMap = Collections.unmodifiableMap(new HashMap<String, Country>() {
        {
            put("usa", new USA());
            put("russia", new Russia());
            put("germany", new Germany());
        }
    });

    @Override
    public Country getCountry(String name) {
        return mFactoryMap.get(name);
    }
}