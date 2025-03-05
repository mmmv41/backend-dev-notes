package com.min.common;

import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@ToString
public class ShoppingCart {

    private final List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<Product>();
    }

    /* 설명. 카트에 물품을 담는 기능 */
    public void addItem(Product item) {
        items.add(item);
    }

    /* 설명. 카트에 물품 꺼내는 기능 */
    public List<Product> getItems() {
        return items;
    }
}
