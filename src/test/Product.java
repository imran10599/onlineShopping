package test;

public class Product {
	
	String code,name;
	double qty;
	public String getCode;
	public double gty;
	public String getCode()
	{
		return code;
		
	}
	public void setCode(String code)
	{
		this.code=code;
	}
	public String getNmae()
	{
		return name;	
	}
  public void setName()
  {
	  this.name=name;
  }
  public double getQty() {
  return qty;
}
  
  public void setQty(double qty) 
  {
	  this.qty=qty;
  }
  public boolean equals(Object o)
  {
	  
	if(o instanceof  Product)
		  
		  return ((Product)o).code.equals(code);
	  
	  else  return false;
  }
public String getName() {
	// TODO Auto-generated method stub
	return null;
}
}