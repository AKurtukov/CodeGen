package ru.sbertech.android.codegen.myapplication.entity;

import ru.sbertech.android.codegen.EntityForFactory;
import ru.sbertech.android.codegen.myapplication.EntityMarker;

@EntityForFactory("card")
public class Card implements EntityMarker {

    private String mName;
    private String mSurname;
    private String mCardNumber;

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

    public String getCardNumber() {
        return mCardNumber;
    }

    public void setCardNumber(String cardNumber) {
        mCardNumber = cardNumber;
    }
}
