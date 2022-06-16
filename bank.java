import java.util.Scanner;

class Bank {
	private int amount;
	private int pin;
	private int otp;
	Bank() {	//initializes the instance variables
		amount = 50000;
		pin = 2508;
		otp = 1234;
	}
	void withDrawl(int w) {  //to withdraw money
		amount = amount - w;
		checkBalance();
	}
	void deposit(int d) {  // to deposit money
		amount = amount + d;
		checkBalance();
	}
	void checkBalance() {  // to print current balance
		System.out.println("Your current balance is : " + amount);
	}
	void changePin(int x) { // to change pin
		pin = x;
	}
	int checkPin(int p) {   // to check if the entered pin is correct or not
		if (pin == p) {
			return 1;
		}
		return 0;//System.out.println("INCORRECT PIN");
	}	
	int checkOtp(int x) {
		if (x == otp)
			return 1;
		else
			return 0;
	}
}


class Vikebank {
	public static void main(String args [])
	{
		int cash, choice;
		int otp;
		Scanner sc = new Scanner(System.in);
		Bank atm = new Bank();
		System.out.println("\n\n\n\n\n\n\n\n\t\t\tWELCOME TO VIKE BANK");
		System.out.print("Enter pin : ");
		int pin = sc.nextInt();
		int res = atm.checkPin(pin);
		if(res==1){
			while(true) {
				System.out.println("\n\n\n\n\n\t\t1. Withdrawl\t\t\t\t\t2. Deposit");
				System.out.println("\n\n\n\n\n\t\t3. Check Balance\t\t\t\t4. Change Pin\n\n\n\n\n\n\n\t\t5. Exit");
				System.out.print("\n\n\t\tEnter your choice : ");
				choice = sc.nextInt();
				switch(choice) {
					case 1 : System.out.print("\n\n\tEnter amount to withdraw : ");
							cash = sc.nextInt();
							atm.withDrawl(cash); break;
					case 2 : System.out.print("\n\n\tEnter amount to deposit : ");
							cash = sc.nextInt();
							atm.deposit(cash); break;
					case 3 : atm.checkBalance(); break;
					case 4 : System.out.print("\n\n\t\tEnter the otp sent to your mobile number: ");
							otp = sc.nextInt();
							res = atm.checkOtp(otp);
							if(res==1) { //check if otp is correct or not
								System.out.print("\n\n\tEnter the new pin : ");
								pin = sc.nextInt();
								atm.changePin(pin);
							}
							else {
								System.out.println("\n\n\n\t\tINVALID OTP");
							}
							break;
					case 5 : return;
					default : System.out.println("\n\n\t\t\tInvalid choice");
				}
			}
		}
		else 
		System.out.println("INVALID PIN");
	}
}

	
