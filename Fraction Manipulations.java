// Fraction Manipulations

import java.util.*;
class Fraction {

	private int numerator;
	private int denominator;
	
	Fraction(int numerator, int denominator)
	{
		this.numerator=numerator;
		this.denominator=denominator;
		
		simplify();
	}
	
	public int getnumerator()
	{
		return numerator;
	}
	
	public int getdenominator()
	{
		return denominator;
	}
	
	public void setnumerator(int n)
	{
		this.numerator= n;
	}
	
	public void setdenominator(int m)
	{
		if(m==0)
			return;
		
		else
	
		this.denominator=m;
	}
	
	
	public void add(Fraction f)
	{
		this.numerator=this.numerator*f.denominator+this.denominator*f.numerator;
		this.denominator=this.denominator*f.denominator;
		
		simplify();
	}
	
	public void multiply(Fraction f)
	{
		this.numerator=this.numerator*f.numerator;
		this.denominator=this.denominator*f.denominator;
		
		simplify();
	}
	
	public static Fraction addition(Fraction f1, Fraction f2)
	{
	  int numerator=f1.numerator*f2.denominator+f1.denominator*f2.numerator;
	  int denominator=f1.denominator*f2.denominator;
	  
	  Fraction f=new Fraction(numerator, denominator);
	  return f;
	}

	private void simplify()
	{
          int gcd=1;
          
          for(int i=2;i<=Math.min(numerator, denominator);i++)
          {
        	  if(numerator%i==0 && denominator%i==0)
        	  {
        		  gcd=i;
        	  }
          }
          
          this.numerator=numerator/gcd;
          this.denominator=denominator/gcd;
     }
	
	public void print()
	{

		if(denominator==1)
		{
			System.out.println(numerator);
		}
		
		else
	     System.out.println(numerator+"/"+denominator);
	 	
		
	}
	
	public static void main(String[]args)
	{
	  Fraction f1=new Fraction(2,3);
	  f1.print();
	  
	  f1.setnumerator(5);
	  f1.setdenominator(0);
	  f1.print();
	  System.out.println(f1.getnumerator());
	  System.out.println(f1.getdenominator());
	  
	  Fraction f2=new Fraction(5,6);
	  f1.add(f2);
	  f1.print();
	  f2.print();
	  
	  
	  Fraction f3=new Fraction(7,11);
	  f1.multiply(f3);
	  f1.print();
	  
	  Fraction u=Fraction.addition(f1, f3);
	  u.print();
	 
	}
}