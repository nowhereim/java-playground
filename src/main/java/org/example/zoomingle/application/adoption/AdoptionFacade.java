package org.example.zoomingle.application.adoption;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;
import org.example.zoomingle.domain.adoption.services.HomeAdoptionService;
import org.example.zoomingle.domain.adoption.services.ImageService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdoptionFacade {
    private final HomeAdoptionService homeAdoptionService;
    private final ImageService imageService;

    //@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) 이거 예전에 봤던 비동기처리할 떄 쓰는거
    public HomeAdoption registerHomeAdoption(
            HomeAdoption homeAdoption) {
        return homeAdoptionService.registerHomeAdoption(
                imageService.registerImage(homeAdoption));
    }

    public HomeAdoption findByIdHomeAdoption(Long id) {
        return homeAdoptionService.findByIdHomeAdoption(id);
    }

    public void modifyHomeAdoption(HomeAdoption homeAdoption) {
        homeAdoptionService.modifyHomeAdoption(homeAdoption);
    }

    public void deleteHomeAdoption(HomeAdoption homeAdoption) {
        homeAdoptionService.deleteHomeAdoption(homeAdoption);
    }

    public List<HomeAdoption> findAllHomeAdoption() {
        return homeAdoptionService.findAllHomeAdoption();
    }

    public String uploadImage(MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }
}