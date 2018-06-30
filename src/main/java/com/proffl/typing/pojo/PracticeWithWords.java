package com.proffl.typing.pojo;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.entity.WordDetailEntity;

import java.util.Arrays;

public class PracticeWithWords {
    private PracticeEntity practice;
    private WordDetailEntity[] wordDetails;

    @Override
    public String toString() {
        return "PracticeWithWords{" +
                "practice=" + practice +
                ", wordDetails=" + Arrays.toString(wordDetails) +
                '}';
    }

    public PracticeEntity getPractice() {
        return practice;
    }

    public void setPractice(PracticeEntity practice) {
        this.practice = practice;
    }

    public WordDetailEntity[] getWordDetails() {
        return wordDetails;
    }

    public void setWordDetails(WordDetailEntity[] wordDetails) {
        this.wordDetails = wordDetails;
    }
}
