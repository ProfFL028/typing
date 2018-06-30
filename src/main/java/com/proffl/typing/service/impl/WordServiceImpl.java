package com.proffl.typing.service.impl;

import com.proffl.typing.entity.WordEntity;
import com.proffl.typing.repository.WordRepository;
import com.proffl.typing.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordServiceImpl implements WordService {

    private static List<WordEntity> allWords;

    public static void fullfillAllWords(List<WordEntity> words) {
        allWords = words;
    }

    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<WordEntity> getWrongWords() {
        return null;
    }

    @Override
    public List<WordEntity> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public List<WordEntity> getWords(int wordCount, boolean isRepeat) {
        List<WordEntity> words = new ArrayList<>();

        if (allWords != null && allWords.size() > 0) {
            List<WordEntity> copyedWords = null;
            if (isRepeat) {
                copyedWords = new ArrayList<>();
            } else {
                copyedWords = new ArrayList<>(allWords);
            }
            for (int i = 0; i < wordCount; i++) {
                int totalSize = copyedWords.size();
                Random random = new Random();
                int chooseIndex = random.nextInt(totalSize);
                words.add(copyedWords.get(chooseIndex));
                if (!isRepeat) {
                    copyedWords.remove(chooseIndex);
                }
            }
        }

        return words;
    }
}
