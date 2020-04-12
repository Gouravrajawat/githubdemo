class Person
{
    private String name;
    private String add;
    private String city;
    Person(){     
         }
    Person(String name,String add,String city)
         {
              this.name=name;
              this.add=add;
              this.city=city;
         }        
     void show()
         {
              System.out.println("Name : "+name);
              System.out.println("Address : "+add);
              System.out.println("City : "+city);
         } 

}
class Employee extends Person
{
    private int empno;
    protected double basic;
    private String type;
    Employee()
         {             
         }
    Employee(String nm,String add,String city,int empno,double basic,String type)
         {
         	  super(nm,add,city);
              this.empno=empno;
              this.basic=basic;
              this.type=type;
         }  

     void show()
         {
			  System.out.println("Employee no : "+empno);
              super.show();
              System.out.println("Basic :"+basic);
              System.out.println("type :"+type);
         }    
} 
class Manager extends Employee
{
    private double perk;
    Manager()
         {
              super();
              perk=0;
         }
    Manager(String nm,String add,String city,int empno,double basic,double perk) 
         {
              super(nm,add,city,empno,basic,"Manager");
              this.perk=perk;  
         }      
     void show()
         {
              super.show();
              System.out.println("perk :"+perk);
              System.out.println("Total Salary :"+getSalary());
         } 
    double getSalary()
    {
    	double sal=basic+perk;
    	return sal;
    }

}
class Worker extends Employee
{
    private int days;
    private double rate;
    Worker(String nm,String add,String city,int empno,double basic,int days,double rate)
         {
              super(nm,add,city,empno,basic,"Worker");
              this.days=days;
              this.rate=rate;
         }
     void show()
         {
              super.show();
              System.out.println("Working Days : "+days);
              System.out.println("Rate per Day : "+rate);
              System.out.println("Total Salary :"+getSalary());
         }  
   double getSalary()
    {
    	double sal=rate*days+basic;
    	return sal;
    }
}            
class SalesPerson extends Employee
{
    private double totalSales;
    private double commRate;
    SalesPerson(String nm,String add,String city,int empno,double basic,double totalSales,double commRate)
         {  
         	 super(nm,add,city,empno,basic,"Sales Person");
              this.totalSales=totalSales;
              this.commRate=commRate;
         }
     void show()
         {
              super.show();
              System.out.println("Total sales : "+totalSales+"      Commission rate : "+commRate);
              System.out.println("Total Salary :"+getSalary());
         }  
    double getCommision()
    {
    	double com=totalSales*commRate;
    	return com;
    }     
    double getSalary()
    {
    	double sal=basic+getCommision();
    	return sal;
    }  
} 
class TestEmp
{
	public static void main(String[] d)
	{
	Manager m=new Manager("Mohan","Reagal","Indore",101,10000,5000);
	m.show();
	System.out.println("**********************");
	SalesPerson s=new SalesPerson("Ramesh","Nehru Nagar","Bhopal",102,6000,200000,0.05);
	s.show();
	System.out.println("**********************");
	Worker w=new Worker("Lalaram","Chandan Nagar","Indore",678,500,26,120);
	w.show();
	}

}