package com.proffl.typing.repository.custom;

import com.proffl.typing.entity.WordAnalysis;

import java.util.List;

public interface WordRepositoryCustom {
    List<WordAnalysis> getAnalyzedWords(Integer pageSize, Integer pageIndex, String filterLetter);
}
