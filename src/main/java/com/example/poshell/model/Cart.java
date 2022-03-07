package com.example.poshell.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        int k = items.size();
        for(int i = 0; i < items.size(); i++){
            int c = items.get(i).compareTo(item);
            if(c < 0){
                k = i;
                break;
            }
            else if(c == 0) {
                if(items.get(i).add(item)){
                    if(items.get(i).isEmpty()){
                       items.remove(i);
                    }
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        if(!item.isEmpty())items.add(k, item);
        return true;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}