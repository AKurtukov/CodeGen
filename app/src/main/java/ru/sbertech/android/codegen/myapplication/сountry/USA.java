package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryReflectionFactor;
import ru.sbertech.android.codegen.CountryСodegenFactory;

@CountryReflectionFactor("usa")
@CountryСodegenFactory("usa")
public class USA implements Country {

    @Override
    public String getCapital() {
        return "Вашингтон";
    }
}
