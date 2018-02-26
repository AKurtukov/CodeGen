package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryCodegenFactory;
import ru.sbertech.android.codegen.CountryReflectionFactor;

@CountryReflectionFactor("Russia")
@CountryCodegenFactory("Russia")
public class Russia implements Country {

    @Override
    public String getCapital() {
        return "Москва";
    }
}
