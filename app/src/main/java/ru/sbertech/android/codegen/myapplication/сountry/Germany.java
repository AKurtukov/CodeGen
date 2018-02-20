package ru.sbertech.android.codegen.myapplication.сountry;

import ru.sbertech.android.codegen.CountryReflectionFactor;
import ru.sbertech.android.codegen.CountryСodegenFactory;
import ru.sbertech.android.codegen.myapplication.Country;

@CountryReflectionFactor("Germany")
@CountryСodegenFactory("Germany")
public class Germany implements Country {

    @Override
    public String getCapital() {
        return "Берлин";
    }
}
