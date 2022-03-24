package com.example.pm124lastone.Configuraciones;

public class transaccion {

    public static final String NAME_DATABASE = "sign";
    public static final String TABLE_SIGN= "putsign";
    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String imagen = "imagen";


    public static final String CREATE_TABLE_ONSIGN = "CREATE TABLE "+ TABLE_SIGN + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "descripcion TEXT, imagen BLOB)";
    public static final String DROP_TABLE_ONSIGN = "DROP TABLE IF EXISTS "+ TABLE_SIGN;
}
