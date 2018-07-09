package com.proffl.typing.repository.custom.impl;

import com.proffl.typing.repository.custom.WordDetailRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class WordDetailRepositoryImpl implements WordDetailRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deletePlus(Integer typingDuration) {
        entityManager.createNativeQuery("delete from word_detail where typing_duration>=?1").setParameter(1, typingDuration).executeUpdate();
    }

}
