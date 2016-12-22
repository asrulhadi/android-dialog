package com.example.hadi.libview;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        //dp.setOnDate
    }

    public void toastMe(View v) {
        Toast.makeText(this, R.string.app_name,Toast.LENGTH_SHORT).show();
    }

    public void showMe(View v) {
        EditText et = (EditText)findViewById(R.id.editText);
        if ( ((CheckBox)findViewById(R.id.customize)).isChecked() ) {
            // create the layout
            View layout = getLayoutInflater().inflate(
                    R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_container));
            ((TextView)layout.findViewById(R.id.toastText)).setText(et.getText());
            // a customizes toast
            Toast t = new Toast(this);
            t.setGravity(Gravity.CENTER, 0 ,0);
            t.setDuration(Toast.LENGTH_SHORT);
            t.setView(layout);
            t.show();
        } else {
            Toast.makeText(this, et.getText(), Toast.LENGTH_SHORT).show();
        }
        Snackbar.make(findViewById(R.id.activity_main), et.getText(), Snackbar.LENGTH_SHORT).show();
    }

    public void showAlert(View v) {
        // Init the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Macam mana ni").setTitle("Yang selalu");
        // create the button with the handler
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();
                        ((Button)MainActivity.this.findViewById(R.id.btnLagi)).setText("OK");
                        dialog.dismiss();
                    }
                }
        );
        builder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();
                        ((Button)MainActivity.this.findViewById(R.id.btnLagi)).setText("CANCEL");
                        dialog.dismiss();
                    }
                }
        );
        // Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        // show the dialog
        dialog.show();
    }

    public void setTarikh(View v) {
        DatePicker dp = (DatePicker)v;
        Calendar c = new GregorianCalendar(dp.getYear(),dp.getMonth(),dp.getDayOfMonth());
        Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show();
    }
}
