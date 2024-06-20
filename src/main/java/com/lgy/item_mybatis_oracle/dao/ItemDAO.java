package com.lgy.item_mybatis_oracle.dao;

import java.util.ArrayList;

import com.lgy.item_mybatis_oracle.dto.ItemDTO;

public interface ItemDAO {
	public void write(String name, int price, String description);
	public ArrayList<ItemDTO> list();
}