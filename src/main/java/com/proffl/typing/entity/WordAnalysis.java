package com.proffl.typing.entity;

import javax.persistence.*;

@SqlResultSetMapping(name = "wordAnalysisMapping", classes = @ConstructorResult(
        targetClass = WordAnalysis.class,
        columns = {
                @ColumnResult(name = "word"),
                @ColumnResult(name = "input_chars"),
                @ColumnResult(name = "avg_duration", type = Double.class),
                @ColumnResult(name = "min_duration", type = Double.class),
                @ColumnResult(name = "max_duration", type = Double.class),
                @ColumnResult(name = "wrong_count", type = Integer.class),
                @ColumnResult(name = "extra_count", type = Integer.class),
                @ColumnResult(name = "backspace_count", type = Integer.class),
                @ColumnResult(name = "enter_count", type = Integer.class)
        }
))
@NamedNativeQuery(name = "selectWordAnalysis", query = "select a.word, a.input_chars, b.avg_duration, b.min_duration, b.max_duration, b.wrong_count, b.extra_count, b.backspace_count, b.enter_count from word a left join(\n" +
        "SELECT word, avg(typing_duration) avg_duration, min(typing_duration) min_duration, max(typing_duration) max_duration, sum(is_wrong) wrong_count, sum(is_extra) extra_count, sum(backspace_entered) backspace_count, sum(enter_entered) enter_count  FROM word_detail group by word\n" +
        ") b on a.word=b.word order by b.avg_duration desc")
@Entity
public class WordAnalysis {
    @Id
    @Column(name = "WORD")
    private String word;
    @Column(name = "INPUT_CHARS")
    private String inputChars;
    @Column(name = "AVG_DURATION")
    private Double avgDuration;
    @Column(name = "MIN_DURATION")
    private Double minDuration;
    @Column(name = "MAX_DURATION")
    private Double maxDuration;
    @Column(name = "WRONG_COUNT")
    private Integer wrongCount;
    @Column(name = "EXTRA_COUNT")
    private Integer extraCount;
    @Column(name="BACKSPACE_COUNT")
    private Integer backspaceCount;
    @Column(name = "ENTER_COUNT")
    private Integer enterCount;

    public WordAnalysis() {
    }

    public WordAnalysis(String word, String inputChars, Double avgDuration, Double minDuration, Double maxDuration, Integer wrongCount, Integer extraCount, Integer backspaceCount, Integer enterCount) {
        this.word = word;
        this.inputChars = inputChars;
        this.avgDuration = avgDuration;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.wrongCount = wrongCount;
        this.extraCount = extraCount;
        this.backspaceCount = backspaceCount;
        this.enterCount = enterCount;
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
                ", backspaceCount=" + backspaceCount +
                ", enterCount=" + enterCount +
                '}';
    }

    public Integer getBackspaceCount() {
        return backspaceCount;
    }

    public void setBackspaceCount(Integer backspaceCount) {
        this.backspaceCount = backspaceCount;
    }

    public Integer getEnterCount() {
        return enterCount;
    }

    public void setEnterCount(Integer enterCount) {
        this.enterCount = enterCount;
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
