public class BankAccount {

	private String accountNumber;
	private String ownerName;
	private double balance;
	private String currency;
	private boolean isActive;

	public BankAccount() {
		this("0123456789", "Пробный Про", 0.0, "RUB", true);
	}

	public BankAccount(String accountNumber, String ownerName) {
		this(accountNumber, ownerName, 0.0, "RUB", false);
	}

	public BankAccount(String accountNumber, String ownerName, double balance, String currency, boolean isActive) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
		this.currency = currency;
		this.isActive = isActive;
	}

	public void displayInfo() {
		System.out.println("Account Number: " + accountNumber + "\n" + "Holder: " + ownerName + "\n" + "Balance: " + balance + "\n" + "Currency: " + currency + "\n" + "Active: " + isActive);
	}

	public void deposit(double amount) {
		if (!isActive) {
			System.out.println("Error");
		} else {
			balance += amount;
			System.out.println("deposit: " + amount + "\n" + "Balance: " + balance);
		}
	}

	public void withdraw(double amount) {
		if (!isActive) {
			System.out.println("Error");
		} else {
			balance -= amount;
			System.out.println("withdraw: " + amount + "\n" + "Balance: " + balance);
		}
		
	} 

	public void activateAccount() {
		this.isActive = true;
		System.out.println("Active: " + isActive);
	}
	
	public void deactivateAccount() {
		this.isActive = false;
		System.out.println("Active: " + isActive);
	}
}