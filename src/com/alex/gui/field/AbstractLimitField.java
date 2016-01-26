package com.alex.gui.field;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Created by user on 12.01.2016.
 */
public abstract class AbstractLimitField extends JTextField {

    private int limit;

    public AbstractLimitField(int limit) {
        this.limit = limit;
    }

    protected abstract String getRegex();

    protected Document createDefaultModel() {
        return new LimitCharDocument();
    }

    class LimitCharDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

            String regex = getRegex();

            if(regex == null){
                return;
            }

            if ((str != null)
                    && ((getLength() + str.length()) <= limit)
                    && str.matches(getRegex())) {
                super.insertString(offs, str, a);
            }
        }
    }

}
