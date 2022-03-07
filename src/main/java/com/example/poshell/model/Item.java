package com.example.poshell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int amount;

    @Override
    public String toString(){
        return product.toString() +"\t" + amount;
    }

    public int compareTo(Item item){
        return product.compareTo(item.product);
    }

    public boolean add(Item item){
        int tmp = amount + item.amount;
        if(tmp >= 0){
            amount = tmp;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        return amount <= 0;
    }

}
