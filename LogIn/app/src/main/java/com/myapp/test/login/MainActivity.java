package com.myapp.test.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (EditText)findViewById(R.id.etUserNamed);
        Password = (EditText) findViewById(R.id.etPassWordd);
        Login = (Button)findViewById(R.id.btnLogin);
        Info = (TextView)findViewById(R.id.tvInfo);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(UserName.getText().toString(),Password.getText().toString());
                Log.d("omg",UserName.getText().toString()+","+Password.getText().toString());

            }
        });
    }
    private void validate(String name,String pw){

        if((name.equals("sarath"))&& (pw.equals("sarath"))){
            Log.d("omg","omg");
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else {
            Log.d("omg","oops");
            counter--;
            if(counter == 0){
                Login.setEnabled(false);
            }
            Info.setText("No of Attempts Remaining : "+String.valueOf(counter));
        }
    }
}
