// Dynamic Array Implementation without using built in Library 

import java.util.*;
class DArray {
  
	private int arr[];
	private int nextIndex;
	
	DArray()
	{
		arr=new int[5];
		nextIndex=0;
	}
	
	public int size()
	{
		return nextIndex;
	}
	
	public void add(int element)
	{
		if(size()<arr.length)
		{
			arr[nextIndex]=element;
			++nextIndex;
		}
		
		else
		restructure(element);
	}
	
	public void restructure(int element)
	{
		int temp[]=arr;
		arr=new int[arr.length*2];
		
		for(int i=0;i<temp.length;i++)
		{
			arr[i]=temp[i];
		}
		
		arr[nextIndex]=element;
		++nextIndex;
	}
	
	public int get(int index)
	{
		if(index<nextIndex)
		{
			return arr[index];
		}
		
		else
		{
			return -1;
		}
	}
	
	public void set(int index, int element)
	{
		if(index<nextIndex)
		{
			arr[index]=element;
		}
		
		else if(index>nextIndex)
		{
			return;
		}
		
		else
			add(element);
	}
	
	public int removeLast()
	{
		int value=arr[nextIndex-1];
		arr[nextIndex-1]=0;
		--nextIndex;
		return value;
	}
	
	public boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
		
		else
			return false;
	}
	
	public static void main(String[]args)
	{
	  DArray d1=new DArray();
	  
	  for(int i=0;i<100;i++)
	  {
		  d1.add(i+10);
	  }
	  
	  System.out.println(d1.get(3));
	  
	  d1.set(4, 14);
	  
	  System.out.println(d1.get(4));
	  
	  System.out.println(d1.size());
	  
	  while(!d1.isEmpty())
	  {
		  System.out.println(d1.removeLast());
		  
		  System.out.println(d1.size());
	  }
	  
	}
}