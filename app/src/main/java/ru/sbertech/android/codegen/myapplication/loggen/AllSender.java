package ru.sbertech.android.codegen.myapplication.loggen;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ru.sbertech.android.codegen.LoggingParams;
import ru.sbertech.android.codegen.Sender;


public class AllSender implements Sender {

    private static final String LOG_DEBUG = "showLogDebug";
    private static final String LOG_ERROR = "showLogError";
    private static final String SAVE_LOG = "saveFileLog";
    private static final String TAG = "Log";

    @Override
    public void send(LoggingParams params) {
        Map<String, String> paramMap = new HashMap<>();
        for (LoggingParams.Param param : params.getParams()) {
            paramMap.put(param.getName(), param.getStringValue());
        }

        LoggingParams.Param value = params.getFirstAnnotatedParam(LogMessage.class);

        switch (params.getMethodName()) {
            case LOG_DEBUG:
                Log.d(TAG, (String) value.getValue());
                break;
            case LOG_ERROR:
                Log.e(TAG, (String) value.getValue());
                break;
            case SAVE_LOG:
                // TODO save Log to File
                break;
        }
    }
}
