package com.proffl.typing.controller;

import com.proffl.typing.entity.PracticeEntity;
import com.proffl.typing.pojo.PracticeWithWords;
import com.proffl.typing.service.PracticeService;
import com.proffl.typing.service.WordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @Autowired
    private WordDetailService wordDetailService;

    @RequestMapping(value = "/api/practice/save", method = RequestMethod.PUT)
    public @ResponseBody
    String save(@RequestBody PracticeWithWords practiceWithWords) {
        PracticeEntity practice = practiceService.save(practiceWithWords.getPractice());
        int wordsSavedCount = wordDetailService.save(practice, practiceWithWords.getWordDetails());
        return "{wordsSavedCount:"+wordsSavedCount+"}";
    }

    @RequestMapping(value = "/api/practice/get")
    public @ResponseBody
    List<PracticeEntity> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex) {
        List<PracticeEntity> practiceList = practiceService.getListSortByTimeDesc(pageSize, pageIndex);
        return practiceList;
    }
}
