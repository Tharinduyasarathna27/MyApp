package com.example.tharindumvvse.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tharindumvvse.myapplication.MESSAGE";
    private EditText editText1,editText2;
    private Button buttonSum,buttonRating;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListnerOnButton();
        addListnerOnButtonClick();

    }

    public void addListnerOnButtonClick() {
        ratingBar = findViewById(R.id.ratingBar);
        buttonRating = findViewById(R.id.buttonRating);
        buttonRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();
            }
        });

    }


//    public void sendMessage(View view){
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText =  findViewById(R.id.txt1);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }

    public void addListnerOnButton(){
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonSum = findViewById(R.id.button);

        buttonSum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int sum = a+b ;

                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();

            }
        });
    }

}
