package ru.sbertech.android.codegen.myapplication.loggen;

import java.lang.reflect.Field;

import ru.sbertech.android.codegen.LoggingParams;
import ru.sbertech.android.codegen.Sender;


public class AllSender implements Sender {

    private static final String LOG_DEBUG = "showLogDebug";
    private static final String LOG_ERROR = "showLogError";
    private static final String SAVE_LOG = "saveFileLog";

    @Override
    public void send(LoggingParams params) {
        Object o = params.getFirstAnnotatedParam(LogMessage.class).getValue();
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(LogEntries.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(o) != null) {
                        choiceAction(params.getMethodName(), field.getName(), field.get(o).toString());
                    } else {
                        choiceAction(params.getMethodName(), field.getName(), "null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void choiceAction(String methodName, String paramName, String value) {
        switch (methodName) {
            case LOG_DEBUG:
                android.util.Log.d(paramName, value);
                break;
            case LOG_ERROR:
                android.util.Log.e(paramName, value);
                break;
            case SAVE_LOG:
                // TODO save Log to File
                break;
        }
    }
}
