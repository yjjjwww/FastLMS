package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerDto {
    Long id;

    String bannerName;
    String filename;
    String urlFilename;
    String linkUrl;
    String target;
    int sortValue;
    boolean openYn;
    LocalDate regDt;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .linkUrl(banner.getLinkUrl())
                .target(banner.getTarget())
                .sortValue(banner.getSortValue())
                .openYn(banner.isOpenYn())
                .regDt(banner.getRegDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for (Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }
}
