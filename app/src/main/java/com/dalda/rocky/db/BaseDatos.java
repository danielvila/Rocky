package com.dalda.rocky.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dalda.rocky.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE       + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO     + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL        + " TEXT," +
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO         + " INTEGER" +
                ")";
        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKES_ID_CONTACT   + " INTEGER," +
                ConstantesBaseDatos.TABLE_LIKES_CANTIDAD     + " INTEGER," +
                "FOREIGN KEY (" +  ConstantesBaseDatos.TABLE_LIKES_ID_CONTACT  + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "(" + ConstantesBaseDatos.TABLE_CONTACTS_ID +")" +
                ")";
        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTS);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            String querylikes = "SELECT COUNT(" +  ConstantesBaseDatos.TABLE_LIKES_CANTIDAD+ ") as likes FROM " + ConstantesBaseDatos.TABLE_LIKES +
                            " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_CONTACT + "=" + contactoActual.getId();
            Cursor registrosLikes = db.rawQuery(querylikes, null);
            if (registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            }else{
                contactoActual.setLikes(0);
            }
            contactos.add(contactoActual);
        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;
        String query = "SELECT COUNT(" +  ConstantesBaseDatos.TABLE_LIKES_CANTIDAD+ ") FROM " + ConstantesBaseDatos.TABLE_LIKES +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_CONTACT + "=" + contacto.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
