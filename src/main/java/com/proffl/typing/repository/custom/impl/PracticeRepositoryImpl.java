package com.proffl.typing.repository.custom.impl;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.repository.custom.PracticeRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class PracticeRepositoryImpl implements PracticeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<PracticeEntity> getListAndSortByTime(Integer pageSize, Integer pageIndex) {
        Query query = entityManager.createQuery("From PracticeEntity as p order by p.practiceTime desc");
        query.setFirstResult(pageSize * (pageIndex - 1));
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
