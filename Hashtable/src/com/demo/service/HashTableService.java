package com.demo.service;

//import org.w3c.dom.Node;

public class HashTableService {

  Node[] heads;
  public HashTableService(int size){
	  heads=new Node[size];
	  for(int i=0;i<heads.length;i++)
	  {
		  heads[i]=null;
	  }
  }

  public class Node
  {
	  int data;
	  Node next;
	public Node(int num) {
		super();
		data = num;
		next = null;
	}
  
  }

  public void insertdata( int num) {

	  //pos is bucket in which we are
	  int pos=num%heads.length;
	  Node newnode=new Node(num);
	  
	  //if hashtable is empty 
	  if(heads[pos]==null)
	  {
		  heads[pos]=newnode;
	  }
	  else
		  //if head is there in hashtable
	  {
		  newnode.next=heads[pos];
		  heads[pos]=newnode;
	  }
			
	  
  }
  public boolean Searchdata( int num)
  {
	 int pos= num%heads.length;
	 if(heads==null)
	 {
		 System.out.println("list is empty and no data found");
		 return false;
	 }
	 else {
		 Node temp=heads[pos];
		 for(;temp!=null;temp=temp.next)
		 {
			 if(temp.data==num)
			 {
				 System.out.println("data found");
				 
			 }
			 else {
				 System.out.println("Number not found");
			 }
		 }
	 }
	return false;
		 
	 
  }
  public void displaydata() {
	  for(int i=0;i<heads.length;i++)
	  {
		  System.out.println(i);
	  
	 
	for(Node temp=heads[i];temp!=null;temp=temp.next)
  {
	  System.out.println(temp.data);
  }
  }
}
  


}
