package com.example.calculatorgb.domain;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculatorgb.R;

public enum Theme {
    ONE(R.style.Theme_CalculatorGB, R.string.key_theme1,"one"),
    TWO(R.style.Theme_CalculatorGB_V2, R.string.key_theme2, "two");

    @StyleRes
    private final int style;

    @StringRes
    private final int title;

    private final String key;

    Theme(int style, int title, String key) {
        this.style = style;
        this.title = title;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getStyle() {
        return style;
    }

    public int getTitle() {
        return title;
    }



}
