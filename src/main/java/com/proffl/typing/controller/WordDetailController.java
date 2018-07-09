package com.proffl.typing.controller;

import com.proffl.typing.entity.WordDetailEntity;
import com.proffl.typing.service.WordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordDetailController {

    @Autowired
    private WordDetailService wordDetailService;

    @RequestMapping("/api/word_detail/page")
    public @ResponseBody
    Page<WordDetailEntity> getWordDetails(
            Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String word
    ) {
        return wordDetailService.page(word, pageable);
    }

    @RequestMapping(value = "/api/word_detail/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer paramId) {
        wordDetailService.delete(paramId);
    }

    @RequestMapping(value = "/api/word_detail/deletePlus", method = RequestMethod.DELETE)
    public void delete5Plus(@RequestParam(required = false, defaultValue = "3000") Integer typingDuration) {
        wordDetailService.deletePlus(typingDuration);
    }
}
