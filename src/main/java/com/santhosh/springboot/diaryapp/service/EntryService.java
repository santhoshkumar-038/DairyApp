package com.santhosh.springboot.diaryapp.service;

import java.util.List;

import com.santhosh.springboot.diaryapp.entity.Entry;

public interface EntryService {
	public Entry saveEntry(Entry entry);
	public Entry updateEntry(Entry entry);
	public void deleteEntry(Entry entry);
	public Entry findById(long id);
	public List<Entry> getEntrys();
	public List<Entry> findByUserid(long id);
}
