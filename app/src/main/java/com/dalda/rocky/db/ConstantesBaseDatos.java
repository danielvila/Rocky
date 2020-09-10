package com.dalda.rocky.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS           = "contacto";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO  = "telefono";
    public static final String TABLE_CONTACTS_EMAIL     = "email";
    public static final String TABLE_CONTACTS_FOTO      = "foto";

    public static final String TABLE_LIKES              = "contacto_likes";
    public static final String TABLE_LIKES_ID           = "id";
    public static final String TABLE_LIKES_ID_CONTACT   = "id_contacto";
    public static final String TABLE_LIKES_CANTIDAD     = "numero_likes";
}
