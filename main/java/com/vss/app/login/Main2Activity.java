package com.vss.app.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView username,email,password,confirm_password,age;
    Button btn;
    LinearLayout linearLayout;
    EditText edit;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linearLayout = findViewById(R.id.linear);
        username = findViewById(R.id.edusername);
        email  = findViewById(R.id.edemail);
        password = findViewById(R.id.edpassword);
        confirm_password = findViewById(R.id.edconfirmpassword);
        age = findViewById(R.id.edage);
    /*    Bundle bundle = getIntent().getExtras();
        String username1 = bundle.getString("username");
        String email1 = bundle.getString("email");
        String password1 = bundle.getString("password");
        String confirm_password1 = bundle.getString("confirm_password");
        String age1 = bundle.getString("age");
        username.setText(username1);
        email.setText(email1);
        password.setText(password1);
        confirm_password.setText(confirm_password1);
        age.setText(age1);*/
        btn=findViewById(R.id.btn1);
        edit=findViewById(R.id.edit);
    //    Snackbar.make(linearLayout, "WelCome "+username1, Snackbar.LENGTH_LONG).setAction("hii",null).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=edit.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(1,intent);
                finish();
            }
        });
        registerForContextMenu(username);
        builder = new AlertDialog.Builder(this);
      //  AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.call){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
            Log.e("Call","your calling karthick");
        }
        else if(item.getItemId()==R.id.sms){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
            Log.i("Sms","your texting karthick");
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
      //  AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.call){
            builder.setMessage("Are you call?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"calling..",Toast.LENGTH_LONG).show();
                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if(item.getItemId()== R.id.sms){

            builder.setMessage("Are you text?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"sms..",Toast.LENGTH_LONG).show();
                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if(item.getItemId()==R.id.logout){
            builder.setMessage("Are you Logout?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(i);
                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        else {
            return false;
        }
        return super.onOptionsItemSelected(item);

    }
}
