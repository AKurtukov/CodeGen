package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.CountryReflectionFactor;
import ru.sbertech.android.codegen.CountryСodegenFactory;
import ru.sbertech.android.codegen.myapplication.Country;

@CountryReflectionFactor("USA")
@CountryСodegenFactory("USA")
public class USA implements Country {

    @Override
    public String getCapital() {
        return "Вашингтон";
    }
}
