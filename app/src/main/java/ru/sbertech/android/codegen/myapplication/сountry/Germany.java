package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryCodegenFactory;
import ru.sbertech.android.codegen.CountryReflectionFactor;

@CountryReflectionFactor("germany")
@CountryCodegenFactory("germany")
public class Germany implements Country {

    @Override
    public String getCapital() {
        return "Берлин";
    }
}
