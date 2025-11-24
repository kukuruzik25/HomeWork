public class MainBankAccount {
	public static void main(String[] args) {
		BankAccount my_account1 = new BankAccount();
		BankAccount my_account2 = new BankAccount("3748250731", "Ficus");
		BankAccount my_account3 = new BankAccount("5673920472", "Лео Лексусович", 1000000.0, "RUB", false);

		my_account1.displayInfo();
		System.out.println();
		my_account2.displayInfo();
		System.out.println();
		my_account3.displayInfo();
		System.out.println();

		my_account3.activateAccount();
		my_account3.withdraw(2500);
		my_account3.deposit(600000);
		my_account3.deactivateAccount();
	}	
}		