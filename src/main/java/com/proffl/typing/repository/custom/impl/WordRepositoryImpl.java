package com.proffl.typing.repository.custom.impl;

import com.proffl.typing.entity.WordAnalysis;
import com.proffl.typing.entity.WordEntity;
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
    public List<WordAnalysis> getAnalyzedWords(Integer pageSize, Integer pageIndex, String filterLetter) {
        Query query = entityManager.createNativeQuery("select a.word word, a.input_chars input_chars, b.avg_duration avg_duration, b.min_duration min_duration, b.max_duration max_duration, b.wrong_count wrong_count, b.extra_count extra_count, b.backspace_count backspace_count, b.enter_count enter_count from word a left join(SELECT word, avg(typing_duration) avg_duration, min(typing_duration) min_duration, max(typing_duration) max_duration, sum(is_wrong) wrong_count, sum(is_extra) extra_count, sum(backspace_entered) backspace_count, sum(enter_entered) enter_count  FROM word_detail group by word) b on a.word=b.word where a.input_chars like '%" + filterLetter + "%' order by b.avg_duration desc", WordAnalysis.class);
        query.setFirstResult(pageSize * (pageIndex - 1));
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<WordEntity> getWrong(int wordCount) {
        Query query = entityManager.createNativeQuery("select a.word, input_chars from word a inner join (select word, avg(typing_duration + case when is_wrong then 1000 else 0 end + case when is_extra then 500 else 0 end) dur from word_detail group by word  order by dur desc limit 0, "+wordCount+") b on a.word=b.word", WordEntity.class);
        return query.getResultList();
    }
}
