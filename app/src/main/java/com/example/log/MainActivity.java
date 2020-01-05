package com.example.log;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


        EditText h;                //宣告全域變數
        EditText w;                //宣告全域變數


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            h = (EditText)findViewById(R.id.edh);                            // 取得身高物件
            w = (EditText)findViewById(R.id.edw);                           // 取得體重物件
            Button submit = (Button)findViewById(R.id.button1); // 取得按鈕物件


            // 按下按鈕 觸發事件
            submit.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View view) {

                    //判斷條件 身高 跟 體重 都有輸入值才執行
                    if ( !("".equals(h.getText().toString())
                            || "".equals(w.getText().toString())) )
                    {
                        SharedPreferences sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);
                        sharedPreferences.edit().putString("height", h.getText().toString()).apply();
                        sharedPreferences.edit().putString("width" , w.getText().toString()).apply();

                        Intent intent = new Intent();
                        intent = intent.setClass(MainActivity.this, CountBMI.class);
                        startActivity(intent);
                    }
                }
            });

    }

    protected void onCreat(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
