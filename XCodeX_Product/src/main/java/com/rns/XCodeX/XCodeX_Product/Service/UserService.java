package com.rns.XCodeX.XCodeX_Product.Service;

import java.util.List;

import com.rns.XCodeX.XCodeX_Product.model.UserMaster;

public interface UserService {
	List<UserMaster> getAllUsersByEmail(String email);
	List<UserMaster> getAllUsers();
	UserMaster login(UserMaster userMaster);
	UserMaster loadProfile(UserMaster userMaster);

}
