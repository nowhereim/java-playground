package org.example.zoomingle.infrastructure.core.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Comment("생성일시")
    private LocalDateTime createdDatetime;

    @LastModifiedDate
    @Comment("수정일시")
    private LocalDateTime modifyDatetime;

    @Comment("삭제일시")
    private LocalDateTime deleteDatetime;
}
