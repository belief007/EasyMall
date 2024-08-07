package com.EasyMall.exception;

/**
 * 用来接收异常信息并输出
 */
public class AccountNotFoundException extends BaseException{

    public AccountNotFoundException(){

    }

    public AccountNotFoundException(String msg){
        super((msg));
    }
}
