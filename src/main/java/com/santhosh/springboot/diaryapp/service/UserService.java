package com.santhosh.springboot.diaryapp.service;

import java.util.List;

import com.santhosh.springboot.diaryapp.entity.User;

public interface UserService {
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
	public User findByUsername(String username);
}
