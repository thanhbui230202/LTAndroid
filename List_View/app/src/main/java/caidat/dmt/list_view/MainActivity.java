package caidat.dmt.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listViewMonHoc;
    EditText edtNhapMonHoc;
    Button btnThem,btnCapNhat,btnXoa;
    ArrayList<String> arrayListMonHoc;
    int vitri =-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayListMonHoc = new ArrayList<>();
        arrayListMonHoc.add("Android studio");
        arrayListMonHoc.add("Java");
        arrayListMonHoc.add("C#");
        arrayListMonHoc.add("XML");
        arrayListMonHoc.add("JS");

        listViewMonHoc = (ListView) findViewById(R.id.listViewMonHoc);
        edtNhapMonHoc =(EditText) findViewById(R.id.editTextThemMonHoc);
        btnThem =(Button) findViewById(R.id.buttonThem);
        btnCapNhat =(Button) findViewById(R.id.buttonCapNhat);
        btnXoa =(Button) findViewById(R.id.buttonXoa);
        ArrayAdapter arrayAdapter= new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayListMonHoc);
        listViewMonHoc.setAdapter(arrayAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListMonHoc.add(edtNhapMonHoc.getText()+"");
//                    listViewMonHoc.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                edtNhapMonHoc.setText("");
            }
        });
        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtNhapMonHoc.setText(arrayListMonHoc.get(i));
                vitri=i;
            }
        });
        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtNhapMonHoc.setText(arrayListMonHoc.get(i));
                arrayListMonHoc.remove(i);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Ban da xoa thanh cong!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( arrayAdapter.isEmpty()){
                    Toast.makeText(MainActivity.this, "List view rong!!", Toast.LENGTH_SHORT).show();
                }else{
                    arrayListMonHoc.set(vitri,edtNhapMonHoc.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Ban da cap nhat thanh cong!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( arrayAdapter.isEmpty()){
                    Toast.makeText(MainActivity.this, "List view rong!!", Toast.LENGTH_SHORT).show();
                }else{
                    arrayListMonHoc.remove(vitri);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Ban da xoa thanh cong!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Long click:" +i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}