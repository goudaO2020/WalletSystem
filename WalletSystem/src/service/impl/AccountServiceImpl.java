package service.impl;
import models.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public Account createAccount(String userName, String password, String email, String phoneNumber, double balance) {
        return new Account(userName, password, email, phoneNumber, balance);
    }
}