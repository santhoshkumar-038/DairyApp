package com.santhosh.springboot.diaryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santhosh.springboot.diaryapp.entity.Entry;
import com.santhosh.springboot.diaryapp.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	public EntryRepository getEntryRepository() {
		return entryRepository;
	}

	public void setEntryRepository(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
		entryRepository.delete(entry);
	}

	@Override
	public Entry findById(long id) {
		return entryRepository.findById(id).get();
	}

	@Override
	public List<Entry> getEntrys() {
		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findByUserid(long id) {
		return entryRepository.findByUserid(id);
	}

}
