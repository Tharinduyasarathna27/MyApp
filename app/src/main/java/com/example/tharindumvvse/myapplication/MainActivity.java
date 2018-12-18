package com.example.tharindumvvse.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_MESSAGE = "com.example.tharindumvvse.myapplication.MESSAGE";
//    private EditText editText1,editText2;
//    private Button buttonSum,buttonRating;
//    RatingBar ratingBar;
      Button button;
      ProgressDialog progressBar;
      private  int progressBarStatus = 0;
      private Handler progressBarHandler = new Handler();
      private long fileSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        addListnerOnButton();
//        addListnerOnButtonClick();
            addListnerOnButtonClick();

    }

    public void addListnerOnButtonClick() {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar = new ProgressDialog(view.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("File Downloading");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
                progressBarStatus = 0;
                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressBarStatus<100){
                            progressBarStatus = doOperation();
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }

                        if (progressBarStatus>=100){
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            progressBar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }


    public int doOperation(){

        while (fileSize<=10000){
            fileSize++;

            if (fileSize==1000){
                return 10;
            }else if (fileSize==2000){
                return 20;
            }else if (fileSize==3000){
                return 30;
            }else if (fileSize==4000){
                return 40;
            }else if (fileSize==5000){
                return 50;
            }else if (fileSize==6000){
                return 60;
            }else if (fileSize==7000){
                return 70;
            }else if (fileSize==8000){
                return 80;
            }else if (fileSize==9000){
                return 90;
            }else{
                return 100;
            }

        }
        return 100;
    }

//    public void addListnerOnButtonClick() {
//        ratingBar = findViewById(R.id.ratingBar);
//        buttonRating = findViewById(R.id.buttonRating);
//        buttonRating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String rating = String.valueOf(ratingBar.getRating());
//                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }


//    public void sendMessage(View view){
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText =  findViewById(R.id.txt1);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }
//
//    public void addListnerOnButton(){
//        editText1 = findViewById(R.id.editText1);
//        editText2 = findViewById(R.id.editText2);
//        buttonSum = findViewById(R.id.button);
//
//        buttonSum.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                String value1 = editText1.getText().toString();
//                String value2 = editText2.getText().toString();
//                int a = Integer.parseInt(value1);
//                int b = Integer.parseInt(value2);
//                int sum = a+b ;
//
//                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }

}
