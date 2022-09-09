package caidat.dmt.thanhbui_2050531200332;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView txtDiem;
CheckBox cb1,cb2,cb3;
SeekBar sb1,sb2,sb3;
ImageButton ibtnPlay;
int diem =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
        txtDiem.setText(diem + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number=5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"turtle win",Toast.LENGTH_LONG).show();
                    if(cb1.isChecked()){
                        diem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng!", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    HidCheckbox();
                }
                if(sb2.getProgress() >= sb2.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "bird win", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        diem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng!", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    HidCheckbox();
                }
                if(sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "buffallo win", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        diem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán đúng!", Toast.LENGTH_SHORT).show();
                    }else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    HidCheckbox();
                }
                sb1.setProgress(sb1.getProgress()+one);
                sb2.setProgress(sb2.getProgress()+two);
                sb3.setProgress(sb3.getProgress()+three);
            }

            @Override
            public void onFinish() {
            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    Disable();
                }else {
                    Toast.makeText(MainActivity.this, "Hãy chọn con vật để bắt đầu!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb2.setChecked(false);
                cb3.setChecked(false);
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb1.setChecked(false);
                cb3.setChecked(false);
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb1.setChecked(false);
                cb2.setChecked(false);
            }
        });
    }
    private void HidCheckbox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void Disable(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void anhxa(){
        txtDiem = (TextView) findViewById(R.id.textview1) ;
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        sb1 = (SeekBar) findViewById(R.id.seekbar1);
        sb2 = (SeekBar) findViewById(R.id.seekbar2);
        sb3 = (SeekBar) findViewById(R.id.seekbar3);
        }
}