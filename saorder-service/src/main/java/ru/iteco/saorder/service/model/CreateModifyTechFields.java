package ru.iteco.saorder.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class CreateModifyTechFields {
    @CreatedDate
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    @CreatedBy
    @Column(name = "create_user", nullable = false)
    private String createUser = "";

    @LastModifiedDate
    @Column(name = "last_modify_at", nullable = false)
    private LocalDateTime lastModifydAt = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "last_modify_user", nullable = false)
    private String lastModifyUser = "";

}