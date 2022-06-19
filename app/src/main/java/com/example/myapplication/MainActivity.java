package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText currentHP;
    EditText maxHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentHP= findViewById(R.id.currentHP);
        maxHP=findViewById(R.id.maxHP);
    }

    public void refreshAlarm(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("同步进度")
                .setMessage("正在同步当前体力:"+currentHP.getText().toString())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("hello","点击确认");
                        Intent intent = new Intent(com.example.myapplication.MainActivity.this,com.example.myapplication.WakeUpService.class);
                        intent.putExtra("checktime",currentHP.getText().toString());
                        startService(intent);
//                        sendBroadcast(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("hello","点击取消");
                    }
                })
                .setNeutralButton("middle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("hello","点击中性");
                    }
                })
                .create()
                .show();
        Log.d("hello","正在设置提醒");
    }

    public void shutDownAlarm(View v){
        Intent intent = new Intent(this, WakeUpService.class);
        stopService(intent);

    }
}