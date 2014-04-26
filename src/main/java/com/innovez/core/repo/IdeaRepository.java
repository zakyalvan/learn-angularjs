package com.innovez.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovez.core.entity.IdeaEntity;

public interface IdeaRepository extends JpaRepository<IdeaEntity, Integer> {
}
