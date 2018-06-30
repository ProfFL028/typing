package com.proffl.typing.service.impl;

import com.proffl.typing.entity.ConfigEntity;
import com.proffl.typing.repository.ConfigRepository;
import com.proffl.typing.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigRepository configRepository;

    @Override
    public ConfigEntity getConfig() {
        List<ConfigEntity> configs = configRepository.findAll();
        if (configs.size() >= 1) {
            return configs.get(0);
        }
        return new ConfigEntity();
    }

    @Override
    public ConfigEntity updateConfig(ConfigEntity entity) {
        return configRepository.saveAndFlush(entity);
    }
}
