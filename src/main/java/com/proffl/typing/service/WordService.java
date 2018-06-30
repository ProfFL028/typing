package com.proffl.typing.service;

import com.proffl.typing.entity.WordEntity;

import java.util.List;

public interface WordService {
    List<WordEntity> getWrongWords();

    List<WordEntity> getAllWords();

    /**
     * 取wordCount个字，
     * @param wordCount 取的数量
     * @param isRepeat 是否允许重复
     * @return 取的字组成的集合
     */
    List<WordEntity> getWords(int wordCount, boolean isRepeat);
}
