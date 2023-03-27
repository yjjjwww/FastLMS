package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{
    private final BannerRepository bannerRepository;

    @Override
    public List<BannerDto> listAll() {
        List<Banner> bannerList = bannerRepository.findAll();

        return BannerDto.of(bannerList);
    }

    @Override
    public BannerDto getById(long id) {
        Optional<Banner> banner = bannerRepository.findById(id);

        if (!banner.isPresent()) {
            return null;
        }

        return BannerDto.of(banner.get());
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setTarget(parameter.getTarget());
        banner.setSortValue(parameter.getSortValue());
        banner.setOpenYn(parameter.isOpenYn());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean add(BannerInput parameter) {

        LocalDate today = LocalDate.now();

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDt = today.format(dt);

        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .linkUrl(parameter.getLinkUrl())
                .target(parameter.getTarget())
                .sortValue(parameter.getSortValue())
                .openYn(parameter.isOpenYn())
                .regDt(LocalDate.parse(regDt))
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public List<BannerDto> listOpen() {
        List<Banner> bannerList = bannerRepository.findByOpenYnTrueOrderBySortValueDesc();

        return BannerDto.of(bannerList);
    }

}
