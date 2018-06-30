package com.proffl.typing;

import com.proffl.typing.entity.WordEntity;
import com.proffl.typing.service.WordService;
import com.proffl.typing.service.impl.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private WordService wordService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<WordEntity> words = wordService.getAllWords();
        WordServiceImpl.fullfillAllWords(words);
    }
}
