package com.proffl.typing.entity;

import javax.persistence.*;


@Entity
@Table(name="WORD_DETAIL")
public class WordDetailEntity {
    @Id
    @GeneratedValue
    @Column(name="PARAM_ID")
    private Integer paramId;

    @Column(name="TYPING_DURATION")
    private Integer typingDuration;

    @Column(name="IS_WRONG")
    private Boolean isWrong;

    @Column(name="IS_EXTRA")
    private Boolean isExtra;

    @Column(name="PRACTICE_ID")
    private Integer practiceId;

    @Column(name="BACKSPACE_ENTERED")
    private Boolean backspaceEntered;

    @Column(name="ENTER_ENTERED")
    private Boolean enterEntered;

    @Column(name="INPUT_CHARS")
    private String inputChars;

    @Column(name="INPUT_VALUE")
    private String inputValue;

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    @ManyToOne
    @JoinColumn(name="WORD")
    private WordEntity word;

    @Override
    public String toString() {
        return "WordDetailEntity{" +
                "paramId=" + paramId +
                ", typingDuration=" + typingDuration +
                ", isWrong=" + isWrong +
                ", isExtra=" + isExtra +
                ", practiceId=" + practiceId +
                ", backspaceEntered=" + backspaceEntered +
                ", enterEntered=" + enterEntered +
                ", inputChars='" + inputChars + '\'' +
                ", inputValue='" + inputValue + '\'' +
                ", word=" + word +
                '}';
    }

    public String getInputChars() {
        return inputChars;
    }

    public void setInputChars(String inputChars) {
        if (inputChars != null && inputChars.length() > 100) {
            inputChars = inputChars.substring(this.inputChars.length() - 100);
        }
        this.inputChars = inputChars;
    }

    public Boolean getBackspaceEntered() {
        return backspaceEntered;
    }

    public void setBackspaceEntered(Boolean backspaceEntered) {
        this.backspaceEntered = backspaceEntered;
    }

    public Boolean getEnterEntered() {
        return enterEntered;
    }

    public void setEnterEntered(Boolean enterEntered) {
        this.enterEntered = enterEntered;
    }
    public WordEntity getWord() {
        return word;
    }

    public void setWord(WordEntity word) {
        this.word = word;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public Integer getTypingDuration() {
        return typingDuration;
    }

    public void setTypingDuration(Integer typingDuration) {
        this.typingDuration = typingDuration;
    }

    public Boolean getIsWrong() {
        return isWrong;
    }

    public void setIsWrong(Boolean wrong) {
        isWrong = wrong;
    }

    public Boolean getIsExtra() {
        return isExtra;
    }

    public void setIsExtra(Boolean extra) {
        isExtra = extra;
    }

    public Integer getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }
}
