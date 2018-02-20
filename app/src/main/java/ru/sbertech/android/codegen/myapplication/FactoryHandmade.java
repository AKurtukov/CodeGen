package ru.sbertech.android.codegen.myapplication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ru.sbertech.android.codegen.myapplication.entity.Account;
import ru.sbertech.android.codegen.myapplication.entity.BusinessCard;
import ru.sbertech.android.codegen.myapplication.entity.Card;

public class FactoryHandmade {

    private static final Map<String, EntityMarker> factoryMap = Collections.unmodifiableMap(new HashMap<String, EntityMarker>() {
        {
            put("Card", new Card());
            put("Account", new Account());
            put("BusinessCard", new BusinessCard());
        }
    });

    public static EntityMarker create(String value) {
        return factoryMap.get(value);
    }
}