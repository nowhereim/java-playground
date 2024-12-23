package org.example.zoomingle.infrastructure.core.adoption;

import org.example.zoomingle.domain.adoption.model.Image;
import org.example.zoomingle.domain.adoption.repositories.ImageRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdoptionImageRepositoryImpl implements ImageRepository {
    @Override
    public List<Image> saveAll(List<Image> images) {
        return null;
    }
}
