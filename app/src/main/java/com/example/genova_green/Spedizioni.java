package com.example.genova_green;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Spedizioni extends AppCompatActivity {
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spedizioni);
        dl=findViewById(R.id.spedizioni);
    }
    public void ClickMenu(View view){
        openDrawer(dl);
    }

    public static void openDrawer(DrawerLayout dl) {
        dl.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(dl);
    }

    public void closeDrawer(DrawerLayout dl) {
        if(dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        redirectActivity(this,MainActivity.class);
    }
    public void ClickDoveLoButto(View view){
        redirectActivity(this,Dove_lo_butto.class);
    }
    public void ClickPericolosi(View view){
        redirectActivity(this,Pericolosi.class);
    }
    public void ClickSpedizioni(View view){
        recreate();
    }
    public void ClickImpostazioni(View view){
        redirectActivity(this,Impostazioni.class);
    }
    public void ClickContatti(View view){
        redirectActivity(this,Contatti.class);
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent=new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(dl);
    }
}