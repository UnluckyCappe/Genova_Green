package com.example.genova_green;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout dl;
    private static String ip="192.168.1.6";
    private static String port="1433";
    private static String classes="net.sourceforge.jtds.jdbc.Driver";
    private static String database="GenovaGreen";
    private static String username="Angelo Morro";
    private static String password= "barcollomanonMorro";
    private static String url="jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    private Connection connection=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        dl=findViewById(R.id.home);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(classes);
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public static void closeDrawer(DrawerLayout dl) {
        if(dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        recreate();
    }
    public void ClickDoveLoButto(View view){
        redirectActivity(this,Dove_lo_butto.class);
    }
    public void ClickPericolosi(View view){
        redirectActivity(this,Pericolosi.class);
    }
    public void ClickSpedizioni(View view){
        redirectActivity(this,Spedizioni.class);
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

    @Override
    public void onClick(View v) {

    }
}