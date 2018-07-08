package com.proffl.typing.repository.custom;

import com.proffl.typing.entity.PracticeEntity;

import java.util.List;

public interface PracticeRepositoryCustom {
    List<PracticeEntity> getListAndSortByTime(Integer pageSize, Integer pageIndex);
}
