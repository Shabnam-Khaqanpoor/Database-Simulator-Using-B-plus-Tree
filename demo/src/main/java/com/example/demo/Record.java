package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Record<E> {
    private String key ;
    private List <Cell> cells = new ArrayList<>() ;
    public Record () {

    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public List<Cell> getCells() {
        return this.cells;
    }
    public void addCell(Cell<String> cell) {
        this.cells.add(cell);
    }
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
