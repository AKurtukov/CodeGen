package ru.sbertech.android.codegen.myapplication.entity;

import ru.sbertech.android.codegen.EntityForFactory;
import ru.sbertech.android.codegen.myapplication.EntityMarker;

@EntityForReflection("tetete")
@EntityForFactory("account")
public class Account implements EntityMarker {

    private String mName;
    private String mSurname;
    private String mAccountNumber;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        mAccountNumber = accountNumber;
    }
}
