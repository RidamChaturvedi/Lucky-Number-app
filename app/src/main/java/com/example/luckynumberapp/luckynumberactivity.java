package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class luckynumberactivity extends AppCompatActivity {
    TextView textView3, textView4;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckynumberactivity);


        textView4=findViewById(R.id.textView4);
        textView3=findViewById(R.id.textView3);
        button2=findViewById(R.id.button2);


        Intent i=getIntent();
        String user_Name=i.getStringExtra("name");

int randomNumber = generatedRandomNumber();
textView3.setText(" YOUR LUCKY NUMBER  "+randomNumber);



     button2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
shareData(user_Name, randomNumber);
         }
     });
        Toast.makeText(this, "username:"+user_Name, Toast.LENGTH_SHORT).show();
    }

    public int generatedRandomNumber() {
       Random random =new Random();
       int upper_limit = 1000;

       int randomNumberGenerated =random.nextInt(1000);
       return randomNumberGenerated;
    }
public void shareData(String username, int randomNumber){

String number=String.valueOf(randomNumber);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, username +"got lucky today" );
        i.putExtra(Intent.EXTRA_TEXT, "his lucky Number is" +randomNumber);

        startActivity(Intent.createChooser(i,"Choose a platform"));
}

}