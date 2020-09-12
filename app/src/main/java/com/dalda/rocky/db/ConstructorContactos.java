package com.dalda.rocky.db;

import android.content.ContentValues;
import android.content.Context;

import com.dalda.rocky.R;
import com.dalda.rocky.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> ObtenerDatos(){
        /*ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Juan Pimentel", "2649784", "juan@test.com", R.drawable.mascota1, 5));
        contactos.add(new Contacto("Maria Bellido", "2644613", "maria@test.com", R.drawable.mascota2, 3));
        contactos.add(new Contacto("Rosario Tijeras", "2641379", "rosario@test.com", R.drawable.mascota3, 8));
        contactos.add(new Contacto("Jose Sanches", "2641478", "jose@test.com", R.drawable.mascota4, 2));
        contactos.add(new Contacto("Nancy Icarraime", "2643698", "nancy@test.com", R.drawable.mascota5, 9));
        contactos.add(new Contacto("Sonia Sarmiento", "2641379", "sonia@test.com", R.drawable.mascota1, 1));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        //insertarContactos(db);
        return db.obtenerContactos();
    }

    public void insertarContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Juan Pimentel");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "2649784");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "juan@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota1);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Maria Bellido");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "2644613");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "maria@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota2);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Rosario Tijeras");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "2641379");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "rosario@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mascota3);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_CONTACT, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CANTIDAD, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
