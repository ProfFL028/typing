package com.proffl.typing.repository;

import com.proffl.typing.entity.WordEntity;
import com.proffl.typing.repository.custom.WordRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, String>, WordRepositoryCustom {
}
