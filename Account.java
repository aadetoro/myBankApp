
    import java.util.ArrayList;
import java.util.Scanner;

    // Account class to represent a cooperative account
    public class Account {
        private int accountId;
        private String accountHolder;
        private double balance;
        private int membershipLength; // in years

        public Account(int accountId, String accountHolder, int membershipLength) {
            this.accountId = accountId;
            this.accountHolder = accountHolder;
            this.membershipLength = membershipLength;
            this.balance = 0.0;
        }

        public int getAccountId() {
            return accountId;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public double getBalance() {
            return balance;
        }

        public int getMembershipLength() {
            return membershipLength;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount <= getWithdrawableLimit() && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double getWithdrawableLimit() {
            if (membershipLength >= 5) {
                return balance + 500; // Allow overdraft up to 500 if membership is 5+ years
            } else if (membershipLength >= 2) {
                return balance; // Withdraw up to current balance if membership is 2-4 years
            } else {
                return Math.min(balance, 200); // Max withdrawal is 200 for less than 2 years
            }
        }

        @Override
        public String toString() {
            return "Account ID: " + accountId + ", Holder: " + accountHolder + ", Balance: $" + balance + ", Membership: " + membershipLength + " years";
        }
    }


