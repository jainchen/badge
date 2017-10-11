package com.bozo.badge;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bozo.badger.ShortcutBadger;


public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnClear;

    private int badgeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.mn_btn_add);
        btnClear = (Button) findViewById(R.id.mn_btn_clear);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                badgeCount += 1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShortcutBadger.applyCount(MainActivity.this, badgeCount);
                    }
                }, 5000);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutBadger.removeCount(MainActivity.this);
            }
        });
    }
}
