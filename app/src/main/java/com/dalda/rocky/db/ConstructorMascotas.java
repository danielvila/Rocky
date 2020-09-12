package com.dalda.rocky.db;

import android.content.ContentValues;
import android.content.Context;

import com.dalda.rocky.R;
import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final Integer RATING = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        DbMascotas db = new DbMascotas(context);
        //insertarMascota(db);
        return db.obtenerMascotas();
    }

    public void insertarMascota(DbMascotas db){;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_NOMBRE, "Zepellin");
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_FOTO, R.drawable.mascota1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_NOMBRE, "Lucifer");
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_FOTO, R.drawable.mascota2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_NOMBRE, "Yeico");
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_FOTO, R.drawable.mascota3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_NOMBRE, "Rocky");
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_FOTO, R.drawable.mascota4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_NOMBRE, "Duran");
        contentValues.put(ConstantesDbMacota.TABLE_MASCOTA_FOTO, R.drawable.mascota5);
        db.insertarMascota(contentValues);

    }

    public void ratingMascota(Mascota mascota){
        DbMascotas db = new DbMascotas(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDbMacota.TABLE_RATING_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesDbMacota.TABLE_RATING_CANTIDAD, RATING);
        db.insertarRating(contentValues);
    }

    public int obtenerRating(Mascota mascota){
        DbMascotas db = new DbMascotas(context);
        return db.obtenerRating(mascota);
    }
}
