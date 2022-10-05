package caidat.dmt.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUser,edtPassword;
    Button btnXacnhan;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtUser.setText(sharedPreferences.getString("user",""));
        edtPassword.setText(sharedPreferences.getString("password",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (userName.equals("thanhbui")&& password.equals("123456")){
                    Toast.makeText(MainActivity.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user",userName);
                        editor.putString("password",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Login false",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        edtUser = (EditText) findViewById(R.id.users);
        edtPassword = (EditText) findViewById(R.id.password);
        btnXacnhan = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
    }
}