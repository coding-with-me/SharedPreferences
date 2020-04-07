package com.nopalyer.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFERENCE = "FILE";
    EditText edtName,edtAddress,edtPhone,edtAge;
    Button btnSave,btnRetrieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.txtName);
        edtAddress = findViewById(R.id.txtAddress);
        edtPhone = findViewById(R.id.txtPhoneNo);
        edtAge = findViewById(R.id.txtAge);

        btnSave = findViewById(R.id.btnSave);
        btnRetrieve = findViewById(R.id.btnRetrieve);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrieveData();
            }
        });



    }

    //create some function for shared preferences
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",edtName.getText().toString());
        editor.putString("address",edtAddress.getText().toString());
        editor.putString("phone",edtPhone.getText().toString());
        editor.putString("age",edtAge.getText().toString());

        editor.apply();

        Toast.makeText(MainActivity.this,"Data Save Successfully",Toast.LENGTH_SHORT).show();

        edtName.setText("");
        edtAddress.setText("");
        edtPhone.setText("");
        edtAge.setText("");

    }

    public void retrieveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        edtName.setText(sharedPreferences.getString("name",""));
        edtAddress.setText(sharedPreferences.getString("address",""));
        edtPhone.setText(sharedPreferences.getString("phone",""));
        edtAge.setText(sharedPreferences.getString("age",""));
        Toast.makeText(MainActivity.this,"Data Retrieve Successfully",Toast.LENGTH_SHORT).show();
    }
}
