package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryReflectionFactor;
import ru.sbertech.android.codegen.CountryСodegenFactory;

@CountryReflectionFactor("russia")
@CountryСodegenFactory("russia")
public class Russia implements Country {

    @Override
    public String getCapital() {
        return "Москва";
    }
}
