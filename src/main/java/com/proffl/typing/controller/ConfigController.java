package com.proffl.typing.controller;

import com.proffl.typing.entity.ConfigEntity;
import com.proffl.typing.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping("/api/config/get")
    public @ResponseBody ConfigEntity getConfig() {
        return configService.getConfig();
    }

    @RequestMapping(value = "/api/config/put", method = RequestMethod.PUT)
    public @ResponseBody ConfigEntity updateConfig(@RequestBody ConfigEntity configEntity) {
        System.out.println(configEntity);
        return configService.updateConfig(configEntity);
    }
}
