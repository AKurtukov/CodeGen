package ru.sbertech.android.codegen.myapplication.loggen;

import ru.sbertech.android.codegen.LogAnnotation;


public class Log {

    @LogAnnotation(AllSender.class)
    public interface Main {

        void showLogDebug(@LogMessage Object message);

        void showLogError(@LogMessage Object message);

        void saveFileLog(@LogMessage Object message);

    }
}