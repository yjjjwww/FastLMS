package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.loginhistory.dto.LoginHistoryDto;
import com.zerobase.fastlms.loginhistory.model.LoginHistoryInput;

import java.util.List;

public interface LoginHistoryService {

    boolean add(LoginHistoryInput parameter);

    List<LoginHistoryDto> list(String userId);
}
