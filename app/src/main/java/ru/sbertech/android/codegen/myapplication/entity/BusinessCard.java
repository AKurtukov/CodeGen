package ru.sbertech.android.codegen.myapplication.entity;

import ru.sbertech.android.codegen.EntityForFactory;
import ru.sbertech.android.codegen.myapplication.EntityMarker;

@EntityForFactory("business_card")
public class BusinessCard implements EntityMarker {

    private String mName;
    private String mSurname;
    private String mPhoneNumber;

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

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }
}
