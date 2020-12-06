package com.example.genova_green;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dove_lo_butto extends AppCompatActivity {
    DrawerLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dove_lo_butto);

        dl=findViewById(R.id.dove_lo_butto);
    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(dl);
    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(dl);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this, MainActivity.class);
    }
    public void ClickDoveLoButto(View view){
        recreate();
    }
    public void ClickPericolosi(View view){
        MainActivity.redirectActivity(this,Pericolosi.class);
    }
    public void ClickSpedizioni(View view){
        MainActivity.redirectActivity(this,Spedizioni.class);
    }
    public void ClickImpostazioni(View view){
        MainActivity.redirectActivity(this,Impostazioni.class);
    }
    public void ClickContatti(View view){
        MainActivity.redirectActivity(this,Contatti.class);
    }



    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(dl);
    }
}