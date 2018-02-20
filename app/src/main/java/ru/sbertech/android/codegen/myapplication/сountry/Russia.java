package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.CountryСodegenFactory;
import ru.sbertech.android.codegen.CountryReflectionFactor;
import ru.sbertech.android.codegen.myapplication.Country;

@CountryReflectionFactor("Russia")
@CountryСodegenFactory("Russia")
public class Russia implements Country {

    @Override
    public String getCapital() {
        return "Москва";
    }
}
