package com.consultancy.dao;

import com.consultancy.model.User;

public interface UserDao 
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int UserId);
	User getUserId(int UserId);

}
