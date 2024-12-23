package org.example.zoomingle.domain.adoption.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;
import org.example.zoomingle.domain.adoption.model.Image;
import org.example.zoomingle.domain.adoption.repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
            // 파일이 비어있는지 체크
            if (file.isEmpty()) {
                throw new IllegalArgumentException("이미지 파일이 비어있습니다.");
            }

            // 원본 파일명 가져오기
            String originalFilename = file.getOriginalFilename();


            // 확장자 추출
            String extension = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf('.'));


            // 파일 이름 중복 방지를 위한 UUID 생성
            String uuid = UUID.randomUUID().toString();


            // 새로운 파일 이름을 UUID로 변경 (확장자 유지)
            String newFileName = uuid + extension;

            // 임시 저장 경로 설정
            String tempDir = "temp-images";
            Path uploadPath = Paths.get(tempDir);

            // 디렉토리가 없으면 생성
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 파일 저장
            try (InputStream inputStream = file.getInputStream()) {
                Path filePath = uploadPath.resolve(newFileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING); // 파일 복사
                return newFileName;
            } catch (IOException e) {
                throw new IOException("이미지 파일 저장 실패: " + originalFilename , e);

        }
    }

        public HomeAdoption registerImage(HomeAdoption homeAdoption) {
            //TODO: 여기는 s3에 저장에 저장하고 디비에도 저장하는 로직이 들어가야함

            //temp-images에 저장된 이미지가 존재한다면 s3에 저장하고 삭제
            //temp-images에 저장된 이미지가 존재하지 않는다면 예외처리


            // 임시 저장 경로 설정
            Path uploadPath = Paths.get("temp-images");

            for(Image image : homeAdoption.getAdoptionAnimalImages()){

                //이거 전부 파사드에서 처리하는게 맞을 듯. 유스케이스들이 너무 많아질듯.
                filesExistsCheck(uploadPath, image);
                //여기서 s3 저장 로직 실행
                fileDelete(uploadPath, image);
            }
            for (Image image : homeAdoption.getHomeEnvironmentImages()) {
                filesExistsCheck(uploadPath, image);
                //여기서 s3 저장 로직 실행
                fileDelete(uploadPath, image);

            }

        return homeAdoption;

    }

    private void filesExistsCheck(Path uploadPath, Image image) {
        if (Files.notExists(uploadPath.resolve(image.getUrl())))
            throw new IllegalArgumentException("파일이 존재하지 않습니다: " + uploadPath.resolve(image.getUrl()));
    }

    private void fileDelete(Path uploadPath, Image image) {
        try {
            Files.delete(uploadPath.resolve(image.getUrl()));
        } catch (IOException e) {
            throw new IllegalArgumentException("파일이 존재하지 않아 삭제에 실패했습니다.: " + uploadPath.resolve(image.getUrl()));
        }
    }

    public void removeImage(HomeAdoption homeAdoption, Image image) {

    }

    public void modifyImage(HomeAdoption homeAdoption, Image image) {

    }
}
