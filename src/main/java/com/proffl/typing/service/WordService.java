package com.proffl.typing.service;

import com.proffl.typing.entity.WordAnalysis;
import com.proffl.typing.entity.WordEntity;

import java.util.List;

public interface WordService {
    List<WordEntity> getAllWords();

    /**
     * 取wordCount个字，
     * @param wordCount 取的数量
     * @param isRepeat 是否允许重复
     * @return 取的字组成的集合
     */
    List<WordEntity> getWords(int wordCount, boolean isRepeat);

    /**
     * 取错误的汉字，如果错误的汉字不足wordCount，复制N份，直到达到wordCount
     * @param wordCount 取的数量,
     * @return
     */
    List<WordEntity> getWrongWords(int wordCount);

    /**
     * 取分析后的word数据
     * @param pageSize
     * @param pageIndex
     * @param filterLetter
     * @return
     */
    List<WordAnalysis> getAnalyzedWords(int pageSize, int pageIndex, String filterLetter);
}
