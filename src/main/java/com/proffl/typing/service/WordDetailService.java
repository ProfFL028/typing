package com.proffl.typing.service;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.entity.WordDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface WordDetailService {
    int save(PracticeEntity practice, WordDetailEntity[] wordDetails);

    Page<WordDetailEntity> page(String word, Pageable pageable);
}
