package com.zerobase.fastlms.banner.repository;

import com.zerobase.fastlms.banner.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    Optional<Banner> findById(Long id);

    List<Banner> findByOpenYnTrueOrderBySortValueDesc();
}
