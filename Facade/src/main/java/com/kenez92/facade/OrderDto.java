package com.kenez92.facade;

import java.util.ArrayList;
import java.util.List;

public final class OrderDto {
    private final List<ItemDto> items = new ArrayList<>();

    public List<ItemDto> getItems() {
        return items;
    }

    public void addItem(final ItemDto item) {
        items.add(item);



    }
}
