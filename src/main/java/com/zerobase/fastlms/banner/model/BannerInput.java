package com.zerobase.fastlms.banner.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BannerInput {
    Long id;

    String bannerName;
    String filename;
    String urlFilename;
    String linkUrl;
    String target;
    int sortValue;
    boolean openYn;
    LocalDate regDt;

    String idList;
}
