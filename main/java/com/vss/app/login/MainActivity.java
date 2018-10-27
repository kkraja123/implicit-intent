package com.vss.app.login;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edusername;
    EditText edmail;
    EditText edpassword;
    EditText edconfirmpassword;
    EditText edage;
    Button btn;
  //  CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edusername = (EditText) findViewById(R.id.edusername);
        edmail = (EditText) findViewById(R.id.edemail);
        edpassword = (EditText) findViewById(R.id.edpassword);
        edconfirmpassword = (EditText) findViewById(R.id.edconfirmpassword);
        edage = (EditText) findViewById(R.id.edage);
        btn = (Button) findViewById(R.id.edsubmit);


        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            } else if (type.startsWith("image/")) {
                handleSendImage(intent); // Handle single image being sent
            }
        } else {
            Toast.makeText(getApplicationContext(),"nothing",Toast.LENGTH_LONG).show();
        }
        

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Snackbar.make(v, "www.journaldev.com", Snackbar.LENGTH_LONG).setAction("hii",null).show();

                String str="";
                String str1="";
                String str2="";
                String str3="";
                String str4="";

                 str = edusername.getText().toString();
                 str1 = edmail.getText().toString();
                 str2 = edpassword.getText().toString();
                 str3 = edconfirmpassword.getText().toString();
                 str4 = edage.getText().toString();
                // Toast meg = Toast.makeText(getBaseContext())

                if (str.equals("")) {
                    edusername.setError("plese Enter username");
                } else if (str1.equals("")) {
                    edmail.setError("plese enter Email");
                } else if (str2.equals("")) {
                    edpassword.setError("plese Enter Password");
                } else if (str2.length() <= 1) {
                    edpassword.setError("plese Enter Minimum 8Chariter");
                } else if (str4.equals("")) {
                    edage.setError("Plese Enter Your Age");
                }else{
                    Toast.makeText(getApplicationContext(), "successfull", Toast.LENGTH_SHORT).show();
                /*   Intent intent = new Intent(Intent.ACTION_DIAL);
                    Intent intent = new Intent();
                   intent.setData(Uri.parse("tel:8940905700"));
                    Bundle bundle = new Bundle();
                    bundle.putString ("username",str);
                    bundle.putString("email",str1);
                    bundle.putString("password",str2);
                    bundle.putString("confirm_password",str3);
                    bundle.putString("age",str4);
                    intent.putExtras(bundle);
                startActivity(intent);
                */}
            }
        });
    }

    private void handleSendImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            ImageView imageView = findViewById(R.id.image_new);
            imageView.setImageURI(imageUri);
        }
    }

    private void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            // Update UI to reflect text being shared
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String message=data.getStringExtra("MESSAGE");
            edusername.setText(message);
        }
    }
}
