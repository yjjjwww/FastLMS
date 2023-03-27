package com.zerobase.fastlms.loginhistory.repository;

import com.zerobase.fastlms.loginhistory.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    Optional<List<LoginHistory>> findByUserId(String userId);
}
