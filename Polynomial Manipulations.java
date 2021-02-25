// Polynomial Class manipulations

public class Polynomial {

    private int arr[];
  
    Polynomial()
    {
  	    arr=new int[100];
	}
	
  public void setCoefficient(int degree, int coeff){

	  if(degree<this.arr.length)
		  {
			  this.arr[degree]=coeff;
		  }
		  else 
		  {
			  restructure(degree,coeff);
		  }
      
	}
  
    public void restructure(int degree, int coeff)
		{
      
      
			int temp[]=this.arr;
			this.arr=new int[this.arr.length*2];
			
			for(int i=0;i<temp.length;i++)
			{
				this.arr[i]=temp[i];
			} 
     
          this.arr[degree]=coeff;
        }
			
  
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
	
      for(int i=0;i<this.arr.length;i++)
		  {
			  if(this.arr[i]!=0)
			  {
				  System.out.print(this.arr[i]+"x"+(i)+"  ");
			  }
		  }
		  
		  System.out.println();
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){

      Polynomial addpoly=new Polynomial();
      
      int bigger=Math.max(this.arr.length, p.arr.length);
      int smaller=Math.min(this.arr.length, p.arr.length);
      
      addpoly.arr=new int[bigger];
      
	   for(int j=0;j<smaller;j++)
		  {
			  addpoly.arr[j]=this.arr[j]+p.arr[j];
		  }	
	   
	   for(int j=smaller+1;j<bigger;j++)
		  {
			  addpoly.arr[j]=this.arr.length>p.arr.length?this.arr[j]:p.arr[j];
		  }	
      
      return addpoly;
      
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
			
      Polynomial subpoly=new Polynomial();
      
      int bigger=Math.max(this.arr.length, p.arr.length);
      int smaller=Math.min(this.arr.length, p.arr.length);
      
      subpoly.arr=new int[bigger];
      
       for(int k=0;k<smaller;k++)
		  {
			  subpoly.arr[k]=this.arr[k]-p.arr[k];
		  }
      
       for(int j=smaller+1;j<bigger;j++)
		  {
			  subpoly.arr[j]=this.arr.length>p.arr.length?this.arr[j]:p.arr[j];
		  }
       
      return subpoly;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
      
       Polynomial oshea=new Polynomial(); 
      
      int leftlength=this.arr.length;

      for(int l=0;l<this.arr.length;l++)
		  {  
              if(l>=leftlength)
              {
                break;
              }
              for(int s=0;s<p.arr.length;s++)
              {
               if(l+s>=oshea.arr.length)
                {
                  oshea.restructure(l+s, this.arr[l]*p.arr[s]);
                  //oshea.arr[l+s]=this.arr[l]*p.arr[s];
                  continue;
                }
			  oshea.arr[l+s]+=(this.arr[l]*p.arr[s]);
            
              }
		  }
      
      return oshea;
	}

public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		 int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
 		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		// Add
		case 1: 
			 result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			 result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			 result = first.multiply(second);
			result.print();
			break;
		}

	}
}