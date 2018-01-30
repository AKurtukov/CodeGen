package ru.sbertech.android.codegen.myapplication.loggen;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class LogProxy {

    @NonNull
    @Contract(pure = true)
    public static <T> T send(Class<T> clazz) {
        return Log$$$LogGenerated.getInstance(clazz);
    }

}
