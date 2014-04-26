package com.innovez.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.innovez.core.dto.Idea;
import com.innovez.core.notif.NotifyClients;
import com.innovez.core.service.IdeaService;

@Controller
@RequestMapping(value="/")
public class IdeaController {
	private Logger logger = Logger.getLogger(IdeaController.class);
	
	@Autowired
	private IdeaService ideaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewIdeas() {
		logger.debug("Handle view ideas request.");
		return "ideas/list";
	}
	
	@RequestMapping(value="/ideas", method=RequestMethod.GET)
	public List<Idea> listIdeas() {
		return ideaService.getIdeas();
	}
	
	@NotifyClients
	@RequestMapping(value="/ideas", method=RequestMethod.POST)
	public Idea add(Idea idea) {
		logger.debug("Handle add idea request.");
		return ideaService.addIdea(idea);
	}
	
	@NotifyClients
	@RequestMapping(value="/ideas/{id}", method=RequestMethod.PUT)
	public Idea update(@PathVariable Integer id, @RequestBody Idea idea) {
		logger.debug("Handle update idea request.");
		return ideaService.updateIdea(idea);
	}
	
	@NotifyClients
	@RequestMapping(value="/ideas/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		logger.debug("Handle delete request.");
		ideaService.deleteIdea(id);
	}
}