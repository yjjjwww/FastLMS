package com.zerobase.fastlms.loginhistory.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LoginHistoryInput {
    String userId;
    String clientIp;
    String userAgent;
    LocalDateTime loginDt;
}
