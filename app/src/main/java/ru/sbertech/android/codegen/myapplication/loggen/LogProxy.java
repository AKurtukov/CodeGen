package ru.sbertech.android.codegen.myapplication.loggen;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.Contract;

import ru.sbertech.android.codegen.myapplication.Stat$$$LogGenerated;

public class LogProxy {

    @NonNull
    @Contract(pure = true)
    public static <T> T send(Class<T> clazz) {
        return Stat$$$LogGenerated.getInstance(clazz);
    }

}
