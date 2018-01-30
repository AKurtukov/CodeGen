package ru.sbertech.android.codegen.myapplication.loggen;

import ru.sbertech.android.codegen.LogAnnotation;


public class Log {

    @LogAnnotation(AllSender.class)
    public interface Main {

        void showLogDebug(@LogMessage String message);

        void showLogError(@LogMessage String message);

        void saveFileLog(@LogMessage String message);

    }
}