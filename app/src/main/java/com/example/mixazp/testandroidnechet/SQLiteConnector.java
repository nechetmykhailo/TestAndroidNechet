package com.example.mixazp.testandroidnechet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mixazp.testandroidnechet.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SQLiteConnector extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Cursor cursor;
    Context context;

    public SQLiteConnector(Context context) {
        super(context, "Products", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL("create table Product (_id integer primary key autoincrement,"
                    + "name varchar(100),"
                    + "price double )");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Product");
    }

    public void insert(Product product){
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("_id", product.getId());
        values.put("name", product.getName());
        values.put("price", product.getPrice());

        db.insert("Product", null, values);

        db.close();
    }

    public List<Product> getData(){
        List<Product> modelList = new ArrayList<>();
        String query = "select * from Product";

        db = this.getWritableDatabase();
        cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Product product = new Product();
                product.setId(cursor.getInt(0));
                product.setName(cursor.getString(1));
                product.setPrice(cursor.getDouble(2));

                modelList.add(product);
            }while (cursor.moveToNext());
        }

        return modelList;
    }
}
