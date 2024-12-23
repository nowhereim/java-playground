package org.example.zoomingle.domain.adoption.repositories;

import org.example.zoomingle.domain.adoption.model.Image;

import java.util.List;

public interface ImageRepository {
    List<Image> saveAll(List<Image> images);
}
