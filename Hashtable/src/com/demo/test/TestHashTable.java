package com.demo.test;

import com.demo.service.HashTableService;

public class TestHashTable {

	public static void main(String[] args) {
		HashTableService table=new HashTableService(5);
		table.insertdata(12);
		table.insertdata(35);
		table.insertdata(15);
		table.insertdata(65);
		table.insertdata(95);
		table.displaydata();
		

	}

}
