package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;

import java.util.List;

public interface BannerService {
    List<BannerDto> listAll();

    BannerDto getById(long id);

    boolean set(BannerInput parameter);

    boolean add(BannerInput parameter);

    boolean del(String idList);

    List<BannerDto> listOpen();
}
