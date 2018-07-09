package com.proffl.typing.controller;

import com.proffl.typing.entity.WordDetailEntity;
import com.proffl.typing.service.WordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordDetailController {

    @Autowired
    private WordDetailService wordDetailService;

    @RequestMapping("/api/word_detail/page")
    public @ResponseBody
    List<WordDetailEntity> getWordDetails(
            Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String word
    ) {
        return wordDetailService.get(word);
    }
}
