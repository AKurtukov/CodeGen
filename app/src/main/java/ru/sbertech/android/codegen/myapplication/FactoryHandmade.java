package ru.sbertech.android.codegen.myapplication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ru.sbertech.android.codegen.myapplication.сountry.Germany;
import ru.sbertech.android.codegen.myapplication.сountry.Russia;
import ru.sbertech.android.codegen.myapplication.сountry.USA;

public class FactoryHandmade {

    private static final Map<String, Country> factoryMap = Collections.unmodifiableMap(new HashMap<String, Country>() {
        {
            put("USA", new USA());
            put("Russia", new Russia());
            put("Germany", new Germany());
        }
    });

    public static Country create(String countryName) {
        return factoryMap.get(countryName);
    }
}