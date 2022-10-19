package caidat.dmt.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SinhVien sinhVien = new SinhVien(this);
        SQLiteDatabase database = sinhVien.getReadableDatabase();
        database.close();
    }
}