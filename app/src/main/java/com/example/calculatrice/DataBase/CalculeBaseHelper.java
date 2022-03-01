package com.example.calculatrice.DataBase;

import android.content.Context;

public class CalculeBaseHelper extends DataBaseHelper{

    public CalculeBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, "calcule", 1);
    }

    @Override
    protected String getCreationSql() {
        return null;
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
