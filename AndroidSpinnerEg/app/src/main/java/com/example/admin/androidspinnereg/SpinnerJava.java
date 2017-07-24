package com.example.admin.androidspinnereg;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 17/07/2017.
 */

public class SpinnerJava extends Activity {
    String[] country = { "India", "USA", "China", "Japan", "Other",  };
    private static final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 100;
    private SharedPreferences permissionStatus;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private boolean sentToSettings = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);
        checkPermissionTest();
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.Testspinner);

        TextView t1 = (TextView) findViewById(R.id.IMEIText);
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.getDeviceId();
        Toast.makeText(getApplicationContext(),telephonyManager.getDeviceId() ,Toast.LENGTH_LONG).show();
        t1.setText(telephonyManager.getDeviceId());
        //spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position] ,Toast.LENGTH_LONG).show();
    }

    public String checkPermissionTest(){
        String result="";
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(SpinnerJava.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(getApplicationContext(),"PERMISSION_GRANTED1235",Toast.LENGTH_SHORT).show();
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(SpinnerJava.this,Manifest.permission.READ_PHONE_STATE)) {
                //if(true){
                //Toast.makeText(getApplicationContext(),"PERMISSION_GRANTED1234",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(SpinnerJava.this);
                builder.setTitle("Need Storage Permission");
                builder.setMessage("This app needs storage permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SpinnerJava.this, new String[]{Manifest.permission.READ_PHONE_STATE},EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        }
        return result;
    }
}
