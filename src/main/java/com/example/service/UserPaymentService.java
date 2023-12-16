package com.example.service;

import com.example.model.UserPayment;

public interface UserPaymentService{
    UserPayment getUserbyId(Integer id);
    UserPayment getDataUserByAccId(String accountId);
}
