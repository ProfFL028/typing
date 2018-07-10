package com.proffl.typing.repository.custom;

import com.proffl.typing.entity.WordAnalysis;
import com.proffl.typing.entity.WordEntity;

import java.util.List;

public interface WordRepositoryCustom {
    List<WordAnalysis> getAnalyzedWords(Integer pageSize, Integer pageIndex, String filterLetter);

    List<WordEntity> getWrong(int wordCount);
}
