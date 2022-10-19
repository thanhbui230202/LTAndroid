package caidat.dmt.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLClientInfoException;

public class SinhVien extends SQLiteOpenHelper {
    public static final String DB_NAME ="Demo";
    public static final int DB_VERSION = 2;

    public SinhVien( Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE nhanvien (id text primary key , name text not null,"+
                "salary integer not null)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS nhanvien";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
}