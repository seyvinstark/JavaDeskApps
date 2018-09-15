
package rw.mobile.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobileAccount {
    
    private String nationalId;
    @Id
    private String phoneNumber;
    private String ownerNames;
    private Double accountBalance;
    
    

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwnerNames() {
        return ownerNames;
    }

    public void setOwnerNames(String ownerNames) {
        this.ownerNames = ownerNames;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return ownerNames ;
    }
    
    
    
}
