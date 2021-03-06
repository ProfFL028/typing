package com.proffl.typing.service.impl;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.repository.PracticeRepository;
import com.proffl.typing.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {
    @Autowired
    private PracticeRepository practiceRepository;

    @Override
    public PracticeEntity save(PracticeEntity practiceEntity) {
        return practiceRepository.save(practiceEntity);
    }

    @Override
    public List<PracticeEntity> getListSortByTimeDesc(Integer pageSize, Integer pageIndex) {
        return practiceRepository.getListAndSortByTime(pageSize, pageIndex);
    }
}
