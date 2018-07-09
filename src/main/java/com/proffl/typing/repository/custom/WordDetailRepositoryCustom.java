package com.proffl.typing.repository.custom;

public interface WordDetailRepositoryCustom {
    /**
     * delete word_detail whoes typing_duration more than typingDuration.
     * @param typingDuration
     */
    void deletePlus(Integer typingDuration);
}
