package com.proffl.typing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORD")
public class WordEntity {

    @Id
    private String word;

    @Column(name = "INPUT_CHARS")
    private String inputChars;

    public WordEntity() {
    }

    public WordEntity(String word, String inputChars) {
        this.word = word;
        this.inputChars = inputChars;
    }

    @Override
    public String toString() {
        return "WordEntity{" +
                "word='" + word + '\'' +
                ", inputChars='" + inputChars + '\'' +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getInputChars() {
        return inputChars;
    }

    public void setInputChars(String inputChars) {
        this.inputChars = inputChars;
    }
}