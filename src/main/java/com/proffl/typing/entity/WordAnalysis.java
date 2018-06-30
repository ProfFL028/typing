package com.proffl.typing.entity;

import javax.persistence.*;

@SqlResultSetMapping(name="wordAnalysisMapping", classes = @ConstructorResult(
        targetClass = WordAnalysis.class,
        columns = {
                @ColumnResult(name="word"),
                @ColumnResult(name="input_chars"),
                @ColumnResult(name="avg_duration", type=Double.class),
                @ColumnResult(name="min_duration", type=Double.class),
                @ColumnResult(name="max_duration", type=Double.class),
                @ColumnResult(name="wrongCount", type=Integer.class),
                @ColumnResult(name="extraCount", type=Integer.class)
        }
))
@NamedNativeQuery(name="selectWordAnalysis", query = "")
@Entity
public class WordAnalysis {
    @Id
    @Column(name = "WORD")
    private String word;
    @Column(name="INPUT_CHARS")
    private String inputChars;
    @Column(name="AVG_DURATION")
    private Double avgDuration;
    @Column(name="MIN_DURATION")
    private Double minDuration;
    @Column(name="MAX_DURATION")
    private Double maxDuration;
    @Column(name="WRONG_COUNT")
    private Integer wrongCount;
    @Column(name="EXTRA_COUNT")
    private Integer extraCount;

    public WordAnalysis() {
    }

    public WordAnalysis(String word, String inputChars, Double avgDuration, Double minDuration, Double maxDuration, Integer wrongCount, Integer extraCount) {
        this.word = word;
        this.inputChars = inputChars;
        this.avgDuration = avgDuration;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.wrongCount = wrongCount;
        this.extraCount = extraCount;
    }

    @Override
    public String toString() {
        return "WordAnalysis{" +
                "word='" + word + '\'' +
                ", inputChars='" + inputChars + '\'' +
                ", avgDuration=" + avgDuration +
                ", minDuration=" + minDuration +
                ", maxDuration=" + maxDuration +
                ", wrongCount=" + wrongCount +
                ", extraCount=" + extraCount +
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

    public Double getAvgDuration() {
        return avgDuration;
    }

    public void setAvgDuration(Double avgDuration) {
        this.avgDuration = avgDuration;
    }

    public Double getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Double minDuration) {
        this.minDuration = minDuration;
    }

    public Double getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Double maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(Integer wrongCount) {
        this.wrongCount = wrongCount;
    }

    public Integer getExtraCount() {
        return extraCount;
    }

    public void setExtraCount(Integer extraCount) {
        this.extraCount = extraCount;
    }
}
