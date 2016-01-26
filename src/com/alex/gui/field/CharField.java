package com.alex.gui.field;

/**
 * Created by user on 12.01.2016.
 */
public class CharField extends AbstractLimitField {

    public CharField(int limit) {
        super(limit);
    }

    @Override
    protected String getRegex() {
        return "[a-zA-Zа-яА-Я]+";
    }
}
