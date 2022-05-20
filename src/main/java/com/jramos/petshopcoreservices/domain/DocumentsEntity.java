package com.jramos.petshopcoreservices.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



@Entity
@Table(name = "Documents")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DocumentsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private Long fileId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    private byte[] pictures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsEntity that = (DocumentsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fileId, that.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileId);
    }
}
