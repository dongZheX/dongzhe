package com.example.noticeme;

import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import org.litepal.crud.DataSupport;

import java.util.Date;

public class ContentActivity extends AppCompatActivity {

    private String id;
    private String content;
    private EditText editText;
    private SimpleDateFormat format;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        editText = (EditText) findViewById(R.id.content_edit);
         format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Intent intent = getIntent();
        if(intent!=null) {
            id = intent.getStringExtra("id");
            content = intent.getStringExtra("content");
            editText.setText(content);
        }


    }
    public static void actionStart(Context context, String id, String content){
        Intent intent = new Intent(context,ContentActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("content",content);


        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void save(){
        Content content = new Content();
        content.setTime(format.format(new Date()));
        content.setContent(editText.getText().toString());
        if(id!=null) {

            if(editText.getText().toString().isEmpty()) {
                Log.d("s", "save: ");
                DataSupport.deleteAll(Content.class, "time = ?", id);
                return;
            }
            if(content!=null&&!editText.getText().toString().equals(content))
            content.updateAll("time = ?", id);
        }
        else{
            if(!editText.getText().toString().isEmpty())
            content.save();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBackPressed() {
        save();

        finish();



    }
}
