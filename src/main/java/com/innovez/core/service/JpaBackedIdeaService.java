package com.innovez.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.innovez.core.dto.Idea;
import com.innovez.core.repo.IdeaRepository;

@Service
@Transactional(readOnly=true)
public class JpaBackedIdeaService implements IdeaService {
	@Autowired
	private IdeaRepository ideaRepository;
	
	@Override
	public List<Idea> getIdeas() {
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Idea addIdea(Idea idea) {
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Idea updateIdea(Idea idea) {
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteIdea(Integer id) {
		
	}
}
