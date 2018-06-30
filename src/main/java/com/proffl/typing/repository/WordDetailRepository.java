package com.proffl.typing.repository;

import com.proffl.typing.entity.WordDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordDetailRepository extends JpaRepository<WordDetailEntity, Integer> {
}
