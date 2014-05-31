package com.innovez.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.innovez.core.dto.Idea;

/**
 * Idea service object contract, exposing service for managing ideas.
 * 
 * @author zakyalvan
 *
 */
public interface IdeaService {
	List<Idea> getIdeas(Pageable pageable);
	Idea addIdea(Idea idea);
	Idea updateIdea(Idea idea);
	void deleteIdea(Integer id);
}