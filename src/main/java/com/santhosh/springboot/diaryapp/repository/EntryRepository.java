package com.santhosh.springboot.diaryapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santhosh.springboot.diaryapp.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	@Query(value = "select * from entries where userid=:id",nativeQuery=true)
	public List<Entry> findByUserid(long id);
}
