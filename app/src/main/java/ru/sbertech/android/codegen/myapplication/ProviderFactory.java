package ru.sbertech.android.codegen.myapplication;

import ru.sbertech.android.codegen.myapplication.loggen.Factory$$$Autogenerate;

public class ProviderFactory {
    public static Country create(String countryName) {
        return Factory$$$Autogenerate.create(countryName);
    }
}
