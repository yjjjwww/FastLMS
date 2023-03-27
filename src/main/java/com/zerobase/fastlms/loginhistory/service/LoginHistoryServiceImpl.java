package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.loginhistory.dto.LoginHistoryDto;
import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import com.zerobase.fastlms.loginhistory.model.LoginHistoryInput;
import com.zerobase.fastlms.loginhistory.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl implements LoginHistoryService{

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public boolean add(LoginHistoryInput parameter) {
        LoginHistory loginHistory = LoginHistory.builder()
                .userId(parameter.getUserId())
                .clientIp(parameter.getClientIp())
                .userAgent(parameter.getUserAgent())
                .loginDt(parameter.getLoginDt())
                .build();

        loginHistoryRepository.save(loginHistory);
        return true;
    }

    @Override
    public List<LoginHistoryDto> list(String userId) {
        Optional<List<LoginHistory>> optionalLoginHistoryList =
        loginHistoryRepository.findByUserId(userId);

        if (!optionalLoginHistoryList.isPresent()) {
            return null;
        }

        List<LoginHistoryDto> loginHistoryDtoList = new ArrayList<>();

        for (LoginHistory loginHistory : optionalLoginHistoryList.get()) {
            loginHistoryDtoList.add(LoginHistoryDto.of(loginHistory));
        }

        return loginHistoryDtoList;
    }
}
