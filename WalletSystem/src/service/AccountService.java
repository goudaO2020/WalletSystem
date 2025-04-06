package service;

import models.Account;

public interface AccountService {


  Account createAccount(String userName, String password, String email, String phoneNumber, double balance);

}
