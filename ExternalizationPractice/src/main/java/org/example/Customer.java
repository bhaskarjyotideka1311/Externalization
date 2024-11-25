package org.example;

import javax.naming.ldap.ExtendedRequest;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Customer implements Externalizable {

    int custId;
    String custName;
    int custAge;
    int password;

    public Customer(){
        System.out.println("No arg constructor for externalizable");
    }
    public Customer(int custId, String custName, int custAge, int password) {
        this.custId = custId;
        this.custName = custName;
        this.custAge = custAge;
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        //we only serialize custId and custName
        out.writeInt(custId);
        out.writeObject(custName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        //restoring variables
        int tempCustId = in.readInt();
        String tempCustName = (String) in.readObject();

        //assigning restored variables to member variable back
        custId = tempCustId;
        custName = tempCustName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAge=" + custAge +
                ", password=" + password +
                '}';
    }
}
