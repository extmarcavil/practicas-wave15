package com.example.movies.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "migrations", schema = "movies_db")
public class MigrationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "migration")
    private String migration;
    @Basic
    @Column(name = "batch")
    private int batch;

    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMigration() {
        return migration;
    }

    public void setMigration(String migration) {
        this.migration = migration;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MigrationsEntity that = (MigrationsEntity) o;
        return batch == that.batch && Objects.equals(id, that.id) && Objects.equals(migration, that.migration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, migration, batch);
    }
}
