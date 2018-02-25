package com.example.noticeme;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS on 2018/2/24.
 */

public class Content extends DataSupport{
    private String content;
    private String time;

    public Content() {
    }

    public Content(String content, String time) {

        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
