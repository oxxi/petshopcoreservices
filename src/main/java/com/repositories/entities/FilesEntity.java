package com.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "Files")
@Entity
@IdClass(FilesEntity.class)
public class FilesEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    private Long petId;

    @NonNull
    private String Comments;

    @NonNull
    private int type;

    @NonNull
    private LocalDateTime created;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilesEntity that = (FilesEntity) o;
        return type == that.type && Objects.equals(id, that.id) && Objects.equals(petId, that.petId) && Comments.equals(that.Comments) && created.equals(that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petId, Comments, type, created);
    }



}
