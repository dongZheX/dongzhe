package com.example.asus.filepersistencetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }
    private void save()  {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = openFileOutput("data",Context.MODE_APPEND);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));//以writer为参数
            editText = (EditText)findViewById(R.id.Edit_1);
            bufferedWriter.write(editText.getText().toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e ){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("Save Error！");
            builder.setCancelable(true);
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    }
    //保存
    private void load(){
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        editText = (EditText)findViewById(R.id.Edit_1);
        try{
            fileInputStream = openFileInput("data");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            editText.setText(stringBuilder.toString());
        }catch(IOException e){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("Load Error！");
            builder.setCancelable(true);
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    }
    //加载
    private void setButton(){
        Button button_save = (Button)findViewById(R.id.button_save);
        Button button_load = (Button)findViewById(R.id.button_load);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }
}
