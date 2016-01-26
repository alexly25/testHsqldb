package com.alex.gui.field;

/**
 * Created by user on 12.01.2016.
 */
public class CharNumField extends AbstractLimitField {

    public CharNumField(int limit) {
        super(limit);
    }

    @Override
    protected String getRegex() {
        return "[a-zA-Zа-яА-Я0-9]+";
    }
}
