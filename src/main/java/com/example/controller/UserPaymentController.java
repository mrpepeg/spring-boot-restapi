package com.example.controller;

import com.example.model.UserPayment;
import com.example.service.UserPaymentServiceImpl;
import jakarta.validation.Valid;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserPaymentController {

    UserPaymentServiceImpl userPaymentService;

    @Autowired
    public UserPaymentController(UserPaymentServiceImpl userPaymentService){
        this.userPaymentService = userPaymentService;
    }

    public static int Dollar_to_rupiah(Integer amount) {
        //this is the logic to convert dollar to rupiah's currency using reference from www.xe.com/currencyconverter
        //1$ = Rp 15000 rupiahs -> simplified the number
        int resultConvert = amount*15000;
        return resultConvert;

    }

    @GetMapping("/userPayment")
    public ResponseEntity<?> getUserbyId(@RequestParam Integer id){
        UserPayment userData = userPaymentService.getUserbyId(id);
        if (userData == null){
            return ResponseEntity.badRequest().body("Data is not found!.");
        }
        return ResponseEntity.ok(userData);

    }

    @PostMapping("/validatePayment")
    public ResponseEntity<Object> validatePayment(@Valid @RequestBody UserPayment paymentDetails) throws JSONException {
        String reqData = paymentDetails.getAccountId();
        int reqData2 = paymentDetails.getAmount();
        String reqData3 = paymentDetails.getCurrency();
        int finalAmount;
        Map<String, Object> respData = new HashMap<>();
        System.out.println(reqData);
        System.out.println(reqData2);
        System.out.println(reqData3);
        UserPayment userData = userPaymentService.getDataUserByAccId(reqData);
        System.out.println(userData);
        //first validation : check user existing
        if (userData == null) {
            respData.put("message", "Payment declined.Users with this account id does not exists");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respData);
        }
        //second validation : check currency to use
        if (reqData3.equals("DOLLAR")) {
            finalAmount = Dollar_to_rupiah(reqData2);
            //third validation : check amount to pay
            if (userData.getAmount() != finalAmount) {
                respData.put("message", "Payment declined.Amount required for this user is not the same.");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(respData);
            }
            respData.put("message", "Payment validated!. Currency use : DOLLAR");
            respData.put("data", userData);
        } else if (reqData3.equals("IDR")) {
            if (userData.getAmount() != reqData2) {
                respData.put("message", "Payment declined.Amount required for this user is not the same.");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(respData);
            }
            respData.put("message", "Payment validated!. Currency use : IDR");
            respData.put("data", userData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment declined.We only accept IDR or Dollar currencies");
        }
        return ResponseEntity.status(HttpStatus.OK).body(respData);
    }
}


