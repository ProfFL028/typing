package com.proffl.typing.repository.custom.impl;

import com.proffl.typing.entity.WordAnalysis;
import com.proffl.typing.repository.custom.WordRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class WordRepositoryImpl implements WordRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<WordAnalysis> getAnalyzedWords(Integer pageSize, Integer pageIndex) {
        Query query = entityManager.createNamedQuery("selectWordAnalysis");
        query.setFirstResult(pageSize * (pageIndex - 1));
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
