package com.company.repository;

import com.company.model.Client;
import com.company.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResumeImp implements CRUDRepository<Resume> {

    List<Resume> listResume = new ArrayList<Resume>();


    @Override
    public void save(Resume object) {
        listResume.add(object);
    }

    @Override
    public void showScreen() {
        for (Resume resume : listResume) {
            System.out.println(resume.toString());
        }

    }

    @Override
    public Optional<Resume> search(String id) {
        boolean flagShow = false;

        for (Resume resume : listResume) {
            if (resume.getId().equals(id)) {
                System.out.println("Factura numero:" + resume.getId());
                System.out.println("Contenido:" + resume.toString());
                flagShow = true;
                return Optional.of(resume);
            }
        }
        System.out.println("No encontro el id de la factura a mostrar");
        return Optional.empty();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Resume> getAll() {
        return null;
    }
}
