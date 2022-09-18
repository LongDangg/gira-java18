package cybersoft.javabackend.java18.gira.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.javabackend.java18.gira.common.util.DateTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    // Create column variables using annotations
    @Id
    @Type(type="uuid-char") // Declare the typing of variable under database (id will have type char in database)
    @GeneratedValue // Generate random value of type UUID (or other types if applied) for id
    @Column(name="ID") // Declare and map database column/field "ID" to variable id
    protected UUID id;

    @Version // Add this annotation for version field
    @Column(name=Columns.VERSION)
    protected int version;

    @CreatedBy
    @Column(name=Columns.CREATED_BY)
    protected String createdBy;

    // Specify typing and date time format for Json response data
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern=DateTimeUtils.DATETIME_FORMAT)
    @CreatedDate
    // Specify date time format for createdAt variable
    @DateTimeFormat(pattern= DateTimeUtils.DATETIME_FORMAT)
    @Column(name=Columns.CREATED_AT)
    protected LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name=Columns.LAST_MODIFIED_BY)
    protected String lastModifiedBy;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern=DateTimeUtils.DATETIME_FORMAT)
    @DateTimeFormat(pattern= DateTimeUtils.DATETIME_FORMAT)
    @LastModifiedDate
    @Column(name=Columns.LAST_MODIFIED_AT)
    protected LocalDateTime lastModifiedAt;

    // Utility class to store database column names
    @UtilityClass
    static class Columns{
        static final String ID = "ID";

        static final String VERSION = "VERSION";

        static final String CREATED_BY = "CREATED_BY";

        static final String CREATED_AT = "CREATED_AT";

        static final String LAST_MODIFIED_BY = "LAST_MODIFIED_BY";

        static final String LAST_MODIFIED_AT = "LAST_MODIFIED_AT";
    }


}
