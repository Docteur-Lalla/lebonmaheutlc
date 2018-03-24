package fr.istic.m2;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

@Entity
public class Advertisement {
    @Id public Long id;
    @Index public String title;
    @Index public int price;
    @Index public String contents;
    @Index public Date date;

    public Advertisement() {

    }

    public Advertisement(String title, int price, String contents, Date date) {
        this.title = title;
        this.price = price;
        this.contents = contents;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}