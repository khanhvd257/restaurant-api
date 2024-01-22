package retaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.w3c.dom.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "boolean default true")
    private Boolean status;
    @Column(name = "delete_flag")
    private Boolean deleteFlag = false;

    @CreatedBy
    @Column(
            name = "created_by",
            length = 64,
            updatable = false
    )
    private String createdBy;
    @CreatedDate
    @Column(
            name = "created_time",
            updatable = false
    )
    private LocalDateTime createdTime = LocalDateTime.now();
    @LastModifiedBy
    @Column(
            name = "updated_by",
            length = 64
    )
    private String updatedBy;
    @LastModifiedDate
    @Column(
            name = "updated_time"
    )
    private LocalDateTime updatedTime = LocalDateTime.now();
}
