package com.innovez.core.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.innovez.core.dto.Idea;
import com.innovez.core.entity.IdeaEntity;
import com.innovez.core.repo.IdeaRepository;

/**
 * Default jpa backed implementation of {@link IdeaService}.
 * 
 * @author zakyalvan
 */
@Service
@Transactional(readOnly=true)
public class JpaBackedIdeaService implements IdeaService {
	private Logger logger = Logger.getLogger(JpaBackedIdeaService.class);
	
	@Autowired
	private IdeaRepository ideaRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<Idea> getIdeas() {
		logger.debug("Retrieve ideas.");
		List<IdeaEntity> ideaEntities = ideaRepository.findAll();
		List<Idea> ideas = new ArrayList<Idea>();
		for(IdeaEntity entity : ideaEntities) {
			ideas.add(mapper.map(entity, Idea.class));
		}
		return ideas;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Idea addIdea(Idea idea) {
		logger.debug("Add new idea : " + idea);
		IdeaEntity entity = mapper.map(idea, IdeaEntity.class);
		entity = ideaRepository.save(entity);
		idea.setId(entity.getId());
		return idea;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Idea updateIdea(Idea idea) {
		logger.debug("Update existing idea : " + idea);
		IdeaEntity entity = mapper.map(idea, IdeaEntity.class);
		entity = ideaRepository.save(entity);
		return mapper.map(entity, Idea.class);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteIdea(Integer id) {
		logger.debug("Delete an idea : " + id);
		ideaRepository.delete(id);
	}
}
