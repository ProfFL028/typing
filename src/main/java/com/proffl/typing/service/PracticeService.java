package com.proffl.typing.service;

import com.proffl.typing.entity.PracticeEntity;

import java.util.List;

public interface PracticeService {
    PracticeEntity save(PracticeEntity practiceEntity);

    List<PracticeEntity> getListSortByTimeDesc(Integer pageSize, Integer pageIndex);
}
