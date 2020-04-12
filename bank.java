import java.util.Scanner;

class Account
{
	private int accNo;
	private String name;
	private double balance;
	private static double minBal=500;
	Account(int an,String n,double b){
		accNo=an;
		name=n;
		balance=b;
	}
int getAccountNo(){
return accNo;
	}
	void show(){
			System.out.println("Account No : "+accNo);
			System.out.println("Name       : "+name);
			System.out.println("Balance    : "+balance);
	}
	
	void deposit(double amt){
		balance+=amt;
		System.out.println("Transaction Succeed");
	}
	void withdrawal(double amt){
		double t=balance-amt;
		if(t<minBal){
			System.out.println("Transaction Fail : Minimum Balance");
		}else{
			balance=t;
			System.out.println("Transaction Succeed");
		}
}
	public void showLine(){		
		System.out.printf("%-10d %-20s %10.2f%n",accNo,name,balance);
	}
	
	static double getMinBal(){
		return minBal;
	}
	static void updateMinBal(double amt){
		minBal=amt;
	}
}

class Test{	
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Account[] accounts=new Account[10];
	int c=0;
	int ch;
		do{
			System.out.println("********Bank Menu************");
			System.out.println("1 - New Account");
			System.out.println("2 - Show Account");
			System.out.println("3 - Show List");
			System.out.println("4 - Withdrawal");
			System.out.println("5 - Deposit");
			System.out.println("6 - Show Min Balance");			
			System.out.println("7 - Update Min Balance");
			System.out.println("0 - Exit");
			System.out.println("Enter Choice : ");
			ch=sc.nextInt();
			switch(ch){
			case 1:{
				if(c==accounts.length)
				{
					System.out.println("No More Account");
					break;
				}
				System.out.println("Enter Account NO : ");
				int an=sc.nextInt();
				boolean found=false;
				for(int i=0;i<c;i++)
				{
if(accounts[i].getAccountNo()==an){
found=true;				
	System.out.println("Error in account creation :  Account Number Exists");	
	break;
}
				}
				if(!found){
				System.out.println("Enter Name : ");
				String n=sc.next();
				System.out.println("Enter Balance : ");
				double b=sc.nextDouble();
				if(b<Account.getMinBal()){
System.out.println("Error in account creation :  Balance should not be less then Min Balance");
					break;
				}
				Account a=new Account(an,n,b);
				accounts[c++]=a;
				System.out.println("Account Created Successfully");
				}
			}
					break;
			case 2:
			{	
					System.out.println("Enter Account No : ");
					int an=sc.nextInt();
					Account a=null;
					for(int i=0;i<c;i++)
					{
						if(accounts[i].getAccountNo()==an){
								a=accounts[i];	
								break;
						}
					}
						
					if(a!=null)
					{
						a.show();
					}else
					{
						System.out.println("Account Not found");
					}
				}
			break;
					
			case 3:
				if(c>0){
					for(int i=0;i<c;i++){
					accounts[i].showLine();
					}		
					}else
					{
						System.out.println("No Account Exist");
					}
					break;					
			case 4:
			{
				System.out.println("Enter Account No : ");
				int an=sc.nextInt();
				Account a=null;
					for(int i=0;i<c;i++)
					{
						if(accounts[i].getAccountNo()==an){
								a=accounts[i];	
								break;
						}
					}
				if(a!=null)
				{
					System.out.println("Enter Amount : ");
					double amt=sc.nextDouble();
					a.withdrawal(amt);
				}else
				{
					System.out.println("Account Not found");
				}	
			}
			
					break;
			case 5:
			{
				System.out.println("Enter Account No : ");
				int an=sc.nextInt();
				Account a=null;
					for(int i=0;i<c;i++)
					{
						if(accounts[i].getAccountNo()==an){
								a=accounts[i];	
								break;
						}
					}
				if(a!=null)
				{
					System.out.println("Enter Amount : ");
					double amt=sc.nextDouble();
					a.deposit(amt);
				}else
				{
					System.out.println("Account Not found");
				}
			
			}
					break;
					
			case 6:
				System.out.println("Min Balance="+Account.getMinBal());
				break;
			case 7:System.out.println("Enter New Min Balance : ");
					double amt=sc.nextDouble();
					Account.updateMinBal(amt);
					break;
			case 0:	System.out.println("Bye");
				break;
			default:System.out.println("Invalid Entry");
			}
		}while(ch!=0);
}
}
