package com.app.service;

import java.util.List;

import com.app.pojos.Login;

public interface ILoginService {

  Login getDetail(String userName);

  List<Login> getAll();
 
}
