package com.example.ch4_user_currency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.entity
 * <li>fileName       : BaseEntity
 * <li>date           : 24. 11. 28.
 * <li>description    : 생성일, 수정일 컬럼을 위한 추상 엔티티
 * </ul>
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
