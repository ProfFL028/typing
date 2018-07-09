package com.proffl.typing.repository;

import com.proffl.typing.entity.WordDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDetailRepository extends JpaRepository<WordDetailEntity, Integer>, PagingAndSortingRepository<WordDetailEntity, Integer> {
    List<WordDetailEntity> findByWordWord(String word);

    Page<WordDetailEntity> findByWordWord(String word, Pageable pageable);
}
