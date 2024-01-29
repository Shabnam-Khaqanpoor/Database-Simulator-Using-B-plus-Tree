package com.example.demo;

import javafx.scene.text.Text;
// بجای تکست عادی ازش اساتفاده میشود و میتواند کلید و شماره ستون را در خود ذخیره کند
public class Cell <TKey> extends Text{
    private int colum ;
    private TKey tKey ;
    public Cell (TKey tKey , String text , int colum) {
        super(text);
        this.tKey = tKey ;
        this.colum = colum ;
    }
    public int getColum() {
        return colum;
    }
    public void setColum(int colum) {
        this.colum = colum;
    }
    public TKey getKey() {
        return tKey;
    }
    public void setKey(TKey tKey) {
        this.tKey = tKey;
    }
}
