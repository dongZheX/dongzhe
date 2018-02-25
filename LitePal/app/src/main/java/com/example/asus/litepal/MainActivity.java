package com.example.asus.litepal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }
    private void setButton(){
        Button button_create = (Button)findViewById(R.id.button_create);
        Button button_add = (Button)findViewById(R.id.button_add);
        Button button_update = (Button)findViewById(R.id.button_update);
        Button button_delete = (Button)findViewById(R.id.button_delete);
        Button button_select = (Button)findViewById(R.id.button_select);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();//最简单的数据库操作
                Toast.makeText(MainActivity.this, "创建成功", Toast.LENGTH_SHORT).show();
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b = new Book();
                b.setBookId(111);
                b.setBookName("围城");
                b.setAuthor("钱钟书");
                b.setPrice(23);
                b.setPages(233);
                b.setPress(10);
                b.save();
                new Book(112,"胡乱","美",22,223,44).save();
                new Category("tt",11).save();
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b = new Book();
                b.setBookId(111);
                b.setBookName("围城");
                b.setAuthor("钱钟书");
                b.setPrice(23);
                b.setPages(233);
                b.setPress(10);
                b.save();
                b.setPrice(99);
                b.save();
                Category c = new Category();
                c.setName("mm");
                c.setCategory_code(24);
                c.updateAll("Name = ? and Category_code = ?","tt","11");//在使用后updateAll来设置默认值时要用setToDefault().因为数据原本就是默认
                Book book = new Book();
                book.setToDefault("BookName");//不能用setBookName
                book.updateAll("BookName = ?","胡乱");
                Toast.makeText(MainActivity.this, "更新成功", Toast.LENGTH_SHORT).show();

            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"price = ?","22");
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }

        });
        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> list = DataSupport.findAll(Book.class);
                List<Book> list2 = DataSupport.select("BookName,BookId").where("price<?","100").find(Book.class);
                String print = null;
                if(list!=null) {
                    for (Book book :list){
                        print += book.toString();
                    }
                }
                Toast.makeText(MainActivity.this, print, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
