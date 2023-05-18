package models;

public class Account {
    private String AccountID;
    private String Password;
    private String ROLE;
    private String CustomerID;

    public Account () {}

    public Account(String accountID, String password, String rOLE, String customerID) {
        this.AccountID = accountID;
        this.Password = password;
        this.ROLE = rOLE;
        this.CustomerID = customerID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String rOLE) {
        ROLE = rOLE;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "Account [AccountID=" + AccountID + ", Password=" + Password + ", ROLE=" + ROLE + ", CustomerID="
                + CustomerID + "]";
    }
}
