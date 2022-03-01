package com.example.calculatrice.DataBase;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.calculatrice.entity.Calcule;

public class CalculeDao extends BaseDao<Calcule> {

    String INDEX_PREMIER_ELEMENT = "premierElement";
    String INDEX_DEUXIEME_ELEMENT = "deuxiemeElement";
    String INDEX_SYMBOLE = "symbole";
    String INDEX_RESULTAT = "resultat";

    public CalculeDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected void putValues(ContentValues values, Calcule entity) {
        values.put(INDEX_PREMIER_ELEMENT, entity.getPremierElement());
        values.put(INDEX_DEUXIEME_ELEMENT,entity.getDeuxiemeElement());
        values.put(INDEX_SYMBOLE,entity.getSymbole());
        values.put(INDEX_RESULTAT, entity.getResultat());
    }

    @Override
    protected Calcule getEntity(Cursor cursor) {
        Calcule calcule = new Calcule();

        Integer indexPremierElement = cursor.getColumnIndex(INDEX_PREMIER_ELEMENT);
        calcule.setPremierElement(cursor.getInt(indexPremierElement));

        Integer indexDeuxiemeElement = cursor.getColumnIndex(INDEX_DEUXIEME_ELEMENT);
        calcule.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));

        Integer indexSymbole = cursor.getColumnIndex(INDEX_SYMBOLE);
        calcule.setSymbole(cursor.getString(indexSymbole));

        Integer indexResultat = cursor.getColumnIndex(INDEX_RESULTAT);
        calcule.setResultat(cursor.getDouble(indexResultat));

        return null;
    }
}
