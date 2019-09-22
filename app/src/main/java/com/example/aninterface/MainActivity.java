package com.example.aninterface;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DialogFactory dialogFactory;
    LinearLayout ll_layout_home;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialogFactory = new DialogFactory(MainActivity.this);

        ll_layout_home=findViewById(R.id.ll_layout_home);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createConfirmExitDialog();
            }
        });


    }


    //create confirm exit dialog
    private void createConfirmExitDialog() {

        Context context = MainActivity.this;
        dialogFactory.createConfirmExitDialog2(new DialogFactory.DialogFactoryInteraction() {
            @Override
            public void onAcceptButtonClicked(String... params) {

                String a = params[0];
                String b = params[1];
                Toast.makeText(context, ""+a + "===="+b, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDeniedButtonClicked(boolean bool) {

            }
        }, ll_layout_home);
    }
}
