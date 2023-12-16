package com.example.service;

import com.example.model.UserPayment;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Configuration
public class UserPaymentServiceImpl implements UserPaymentService{

    ArrayList<UserPayment> userPayments = new ArrayList<>(Arrays.asList(
            new UserPayment(1,"Ron","Ron01",75000,"IDR"),
            new UserPayment(2,"Jack","Jack01",150000,"IDR"),
            new UserPayment(3,"Becky","Becky01",180000,"IDR"),
            new UserPayment(4,"Ann","Ann01",240000,"IDR"),
            new UserPayment(5,"Hod","Hod01",270000,"IDR")
    ));


    public UserPayment getUserbyId(Integer id) {
        for (int i =0; i<userPayments.size();i++ ) {
            if (userPayments.get(i).getId() == id) {
                return userPayments.get(i);
            }
        }
        return null;
    }

    public UserPayment getDataUserByAccId(String accountId) {
        System.out.println("werwrwrwr" + accountId);
        for (int i =0; i<userPayments.size();i++ ) {
            if (userPayments.get(i).getAccountId().equals(accountId)) {
                return userPayments.get(i);
            }

        }
        return null;
    }

}
