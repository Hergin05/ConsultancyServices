package com.consultancy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.consultancy.dao.UserDao;
import com.consultancy.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			return true;
			
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(int UserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserId(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
