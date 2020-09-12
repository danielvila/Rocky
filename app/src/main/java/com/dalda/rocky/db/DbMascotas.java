package com.dalda.rocky.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

public class DbMascotas extends SQLiteOpenHelper {

    private Context context;
    public DbMascotas(@Nullable Context context) {
        super(context, ConstantesDbMacota.DATABASE_NAME, null, ConstantesDbMacota.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreaTablaMascota = "CREATE TABLE "      + ConstantesDbMacota.TABLE_MASCOTA + "(" +
                ConstantesDbMacota.TABLE_MASCOTA_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesDbMacota.TABLE_MASCOTA_NOMBRE     + " TEXT," +
                ConstantesDbMacota.TABLE_MASCOTA_FOTO       + " INTEGER" +
                ")";
        String queryCreaTablaRating = "CREATE TABLE "       + ConstantesDbMacota.TABLE_RATING + "(" +
                ConstantesDbMacota.TABLE_RATING_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesDbMacota.TABLE_RATING_ID_MASCOTA  + " INTEGER," +
                ConstantesDbMacota.TABLE_RATING_CANTIDAD    + " INTEGER," +
                "FOREIGN KEY (" +  ConstantesDbMacota.TABLE_RATING_ID_MASCOTA  + ") " +
                "REFERENCES " + ConstantesDbMacota.TABLE_MASCOTA + "(" + ConstantesDbMacota.TABLE_MASCOTA_ID +")" +
                ")";
        db.execSQL(queryCreaTablaMascota);
        db.execSQL(queryCreaTablaRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDbMacota.TABLE_RATING);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDbMacota.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDbMacota.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryrating = "SELECT COUNT(" +   ConstantesDbMacota.TABLE_RATING_CANTIDAD + ") as rating FROM " +  ConstantesDbMacota.TABLE_RATING +
                    " WHERE " +  ConstantesDbMacota.TABLE_RATING_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosRating = db.rawQuery(queryrating, null);
            if (registrosRating.moveToNext()){
                mascotaActual.setRating(registrosRating.getInt(0));
            }else{
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDbMacota.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRating(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDbMacota.TABLE_RATING, null, contentValues);
        db.close();
    }

    public int obtenerRating(Mascota mascota){
        int rating = 0;
        String queryrating = "SELECT COUNT(" +   ConstantesDbMacota.TABLE_RATING_CANTIDAD + ") as rating FROM " +  ConstantesDbMacota.TABLE_RATING +
                " WHERE " +  ConstantesDbMacota.TABLE_RATING_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registrosRating = db.rawQuery(queryrating, null);
        if (registrosRating.moveToNext()){
            rating =registrosRating.getInt(0);
        }else{
            rating = 0;
        }
        db.close();
        return rating;
    }
}
