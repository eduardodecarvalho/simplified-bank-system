package com.eduardodecarvalho.simplifiedbankssytem.authorization;

import org.springframework.stereotype.Service;

import com.eduardodecarvalho.simplifiedbankssytem.transaction.Transaction;

@Service
public class AuthorizationService {

    public void authorize(Transaction transaction) {
        System.out.println("Authorized");
        ;
    }

}
