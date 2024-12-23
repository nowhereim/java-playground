package org.example.zoomingle.domain.adoption.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Image {
    private long id;
    private long adoptionId;
    private boolean isMain;
    private String url;
    private AdoptionType adoptionType;
    private ImageType type;

}

enum ImageType {
    ANIMAL, // 동물
    HOME_ENVIRONMENT, // 집 환경
    SHOP_ENVIRONMENT, // 가게 환경
    BREEDING_ENVIRONMENT // 번식 환경
}

enum AdoptionType {
    HOME, // 가정
    SHOP, // 가게
    BREEDING, // 번식
    SHELTER // 보호소
}
