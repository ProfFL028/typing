package com.proffl.typing.service;

import com.proffl.typing.entity.ConfigEntity;

public interface ConfigService {
    ConfigEntity getConfig();

    ConfigEntity updateConfig(ConfigEntity entity);
}
