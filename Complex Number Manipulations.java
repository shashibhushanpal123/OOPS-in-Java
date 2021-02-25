// Complex Number Manipulations

import java.util.*;
class Complex {

	private int real;
	private int imaginary;
	
	Complex(int real, int imaginary)
	{
		this.real=real;
		this.imaginary=imaginary;
		
	}
	
	public int getreal()
	{
		return real;
	}
	
	public int getimaginary()
	{
		return imaginary;
	}
	
	public void setreal(int n)
	{
		this.real= n;
	}
	
	public void setimaginary(int m)
	{
		this.imaginary=m;
	}
	
	
	public void add(Complex c)
	{
		this.real=this.real+c.real;
		this.imaginary=this.imaginary+c.imaginary;
		
	}
	
	public void multiply(Complex c)
	{
		int realone=this.real;
		int realtwo=c.real;
		this.real=this.real*c.real - this.imaginary*c.imaginary;
		this.imaginary=realone*c.imaginary + this.imaginary*realtwo;	
	}
	
	public static Complex addition(Complex c1, Complex c2)
	{
	  int real=c1.real+c2.real;
	  int imaginary=c1.imaginary+c2.imaginary;
	  
	  Complex c=new Complex(real, imaginary);
	  return c;
	}
	
	public void print()
	{
		if(imaginary>=0)
      System.out.println(real+"+"+imaginary+"Iota");
		
		else
			System.out.println(real+""+imaginary+"Iota");
	}
	
	public static void main(String[]args)
	{
	  Complex f1=new Complex(2,3);
	  f1.print();
	  
	  f1.setreal(5);
	  f1.setimaginary(0);
	  f1.print();
	  System.out.println(f1.getreal());
	  System.out.println(f1.getimaginary());
	  
	  Complex f3=new Complex(1,2);
	  f1.multiply(f3);
	  f1.print();
	  
	  Complex u=Complex.addition(f1, f3);
	  u.print();
	 
	}
}
}