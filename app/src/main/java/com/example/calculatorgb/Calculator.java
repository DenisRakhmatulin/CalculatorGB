package com.example.calculatorgb;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class Calculator implements Parcelable {

    protected Double valueDbl = 0d;
    protected String operation = null;

    protected String lastNum = null;
    protected String lastBtn = null;
    protected String result = "0";

    public Calculator() {
    }

    protected Calculator(Parcel in) {
        if (in.readByte() == 0) {
            valueDbl = null;
        } else {
            valueDbl = in.readDouble();
        }
        operation = in.readString();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setValueDbl(Double valueDbl) {
        this.valueDbl = valueDbl;
    }

    public String getLastNum() {
        return lastNum;
    }

    public void setLastNum(String lastNum) {
        this.lastNum = lastNum;
    }

    public String getLastBtn() {
        return lastBtn;
    }

    public void setLastBtn(String lastBtn) {
        this.lastBtn = lastBtn;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void buttonPush(String key, String value) {
        if (value.equals("0") && !key.equals(".")) {
            lastNum = key;
        } else if (value.contains(".") && key.equals(".")) {
            lastNum = String.format(Locale.getDefault(), "%s", value);
        } else {
            lastNum = String.format(Locale.getDefault(), "%s", value + key);
        }
        result = lastNum;
    }

    public void operationPush(String operation, String value) {
        this.operation = operation;
        this.valueDbl = Double.parseDouble(value);
        result = "0";
        lastBtn = String.format(Locale.getDefault(), "%s", value + " " + operation + " ");
    }

    public void resultPush(String value) {
        switch (this.operation) {
            case "+":
                this.valueDbl = this.valueDbl + Double.parseDouble(value);
                break;

            case "-":
                this.valueDbl = this.valueDbl - Double.parseDouble(value);
                break;

            case "x":
                this.valueDbl = this.valueDbl * Double.parseDouble(value);
                break;

            case "/":
                this.valueDbl = this.valueDbl / Double.parseDouble(value);
                break;
        }
        this.operation = null;
        result = String.valueOf(valueDbl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (valueDbl == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(valueDbl);
        }
        parcel.writeString(operation);
    }
}
