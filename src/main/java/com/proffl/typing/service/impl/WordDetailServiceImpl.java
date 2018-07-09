package com.proffl.typing.service.impl;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.entity.WordDetailEntity;
import com.proffl.typing.repository.WordDetailRepository;
import com.proffl.typing.service.WordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordDetailServiceImpl implements WordDetailService {
    @Autowired
    private WordDetailRepository wordAnalysisRepository;

    @Override
    public int save(PracticeEntity practice, WordDetailEntity[] wordDetails) {
        int updateCount = 0;
        for (WordDetailEntity wordDetail: wordDetails) {
            if (wordDetail.getInputChars().length() > 0) {
                wordDetail.setPracticeId(practice.getParamId());
                wordAnalysisRepository.save(wordDetail);

                updateCount++;
            } else {
                break;
            }
        }
        return updateCount;
    }

    @Override
    public Page<WordDetailEntity> page(String word, Pageable pageable) {
        return this.wordAnalysisRepository.findByWordWord(word, pageable);
    }
}
