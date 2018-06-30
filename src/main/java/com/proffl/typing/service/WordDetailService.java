package com.proffl.typing.service;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.entity.WordDetailEntity;

public interface WordDetailService {
    int save(PracticeEntity practice, WordDetailEntity[] wordDetails);
}
