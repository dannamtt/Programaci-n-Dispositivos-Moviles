/*
 *   NOMBRE: Danna Paola Muñoz Tenorio
 *   MATERIA: Programación de Dispositivos Móviles
 *   ARCHIVO: Código de base de datos:
 *              - 1 tabla de productos: nombre del producto, precio y su imagen
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "catalog.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_PRODUCTS = "products";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE products (name TEXT, price INTEGER, image TEXT)";
        db.execSQL(sql);

        // Insertar productos
        db.execSQL("INSERT INTO products VALUES ('Manzana normal', 25, 'manzana_normal')");
        db.execSQL("INSERT INTO products VALUES ('Manzana con skwinkles', 45, 'manzana_skwinkles')");
        db.execSQL("INSERT INTO products VALUES ('Manzana con mangos enchilados', 35, 'manzana_mangos')");
        db.execSQL("INSERT INTO products VALUES ('Manzana con pica fresa', 35, 'manzana_picafresa')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // ---
    }

}
