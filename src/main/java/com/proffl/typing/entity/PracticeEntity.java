package com.proffl.typing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRACTICE")
public class PracticeEntity {
    @Id
    @GeneratedValue
    @Column(name = "PARAM_ID")
    private Integer paramId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "PRACTICE_TIME")
    private LocalDateTime practiceTime;

    @Column(name="PRACTICE_DURATION")
    private Integer practiceDuration;

    @Column(name = "TOTAL_COUNT")
    private Integer totalCount;

    @Column(name = "RIGHT_COUNT")
    private Integer rightCount;

    @Column(name = "ENTER_COUNT")
    private Integer enterCount;

    @Column(name = "BACKSPACE_COUNT")
    private Integer backspaceCount;

    @Override
    public String toString() {
        return "PracticeEntity{" +
                "paramId=" + paramId +
                ", practiceTime=" + practiceTime +
                ", practiceDuration=" + practiceDuration +
                ", totalCount=" + totalCount +
                ", rightCount=" + rightCount +
                ", enterCount=" + enterCount +
                ", backspaceCount=" + backspaceCount +
                '}';
    }

    public Integer getPracticeDuration() {
        return practiceDuration;
    }

    public void setPracticeDuration(Integer practiceDuration) {
        this.practiceDuration = practiceDuration;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public LocalDateTime getPracticeTime() {
        return practiceTime;
    }

    public void setPracticeTime(LocalDateTime practiceTime) {
        this.practiceTime = practiceTime;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    public Integer getEnterCount() {
        return enterCount;
    }

    public void setEnterCount(Integer enterCount) {
        this.enterCount = enterCount;
    }

    public Integer getBackspaceCount() {
        return backspaceCount;
    }

    public void setBackspaceCount(Integer backspaceCount) {
        this.backspaceCount = backspaceCount;
    }
}
