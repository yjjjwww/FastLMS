package com.zerobase.fastlms.loginhistory.dto;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginHistoryDto {
    LocalDateTime loginDt;
    String clientIp;
    String userAgent;

    public static LoginHistoryDto of(LoginHistory loginHistory) {
        return LoginHistoryDto.builder()
                .loginDt(loginHistory.getLoginDt())
                .clientIp(loginHistory.getClientIp())
                .userAgent(loginHistory.getUserAgent())
                .build();
    }
}
