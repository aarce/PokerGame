//Abraham Arce
package MainPackage;

public class Test extends Account {
	public static void main(String[] args){
		Account test1 = new Account(7015, 50000, 5.0);
		
	
		System.out.println("Current Balance: $" + test1.getBalance());
		System.out.println("Account Created: " + test1.getDateCreated());
		System.out.println("Monthly Interest: $"+ test1.getMonthlyInterestRate());
		test1.deposit(5000);
		
		try{
			test1.withdraw(3000);
			System.out.println("Balance after drawing $3000: "+ test1.getBalance());
			
			System.out.println("Trying to draw $55000");
			test1.withdraw(55000);
			}
			catch (InsufficientFundsException e){
				System.out.println("You have to deposit $"+ e.getAmount()+ " to be able to draw again");
				e.printStackTrace();
			}
			}
		
		
		
		
		
		
}

