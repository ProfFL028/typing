package com.proffl.typing.controller;

import com.proffl.typing.entity.WordAnalysis;
import com.proffl.typing.entity.WordEntity;
import com.proffl.typing.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordController {
    @Autowired
    private WordService wordService;

    @RequestMapping("/api/word/get_words")
    public @ResponseBody
    List<WordEntity> getWords(
            @RequestParam(required = false, defaultValue = "210") Integer wordCount,
            @RequestParam(required = false, defaultValue = "false") Boolean isRepeat) {
        return wordService.getWords(wordCount, isRepeat);
    }

    @RequestMapping("/api/word/get_analyzed_words")
    public @ResponseBody
    List<WordAnalysis> getAnalyzedWords(
            @RequestParam(required = false, defaultValue = "30") Integer pageSize,
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex
    ) {
        return wordService.getAnalyzedWords(pageSize, pageIndex);
    }
}
