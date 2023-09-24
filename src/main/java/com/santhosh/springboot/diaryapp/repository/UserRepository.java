package com.santhosh.springboot.diaryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santhosh.springboot.diaryapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from users where username=:username LIMIT 1",nativeQuery=true)
	public User findByUsername(String username);
}
