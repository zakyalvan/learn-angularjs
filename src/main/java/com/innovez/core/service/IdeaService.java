package com.innovez.core.service;

import java.util.List;

import com.innovez.core.dto.Idea;
import com.innovez.core.entity.IdeaEntity;

public interface IdeaService {
	List<Idea> getIdeas();

    Idea addIdea(Idea idea);

    Idea updateIdea(Idea idea);

    void deleteIdea(Integer id);
}