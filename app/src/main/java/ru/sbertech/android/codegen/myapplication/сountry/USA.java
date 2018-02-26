package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryCodegenFactory;
import ru.sbertech.android.codegen.CountryReflectionFactor;

@CountryReflectionFactor("USA")
@CountryCodegenFactory("USA")
public class USA implements Country {

    @Override
    public String getCapital() {
        return "Вашингтон";
    }
}
