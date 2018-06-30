package com.proffl.typing.repository;

import com.proffl.typing.entity.PracticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity, Integer> {
}
