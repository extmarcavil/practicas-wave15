package com.sprint.be_java_hisp_w15_g10.Repository;


import com.sprint.be_java_hisp_w15_g10.Model.IIdInterface;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class EntityRepository<T extends IIdInterface> implements IGetters<T>, IAdd<T> {

    private final List<T> list;
    private int index;

    public EntityRepository(){
        index=1;
        list = new ArrayList<T>();
    }

    @Override
    public List<T> getAll(){
        return list;
    }

    @Override
    public Optional<T> getById(int id){
        return list.stream()
                .filter(obj -> obj.getId()==id)
                .findFirst();
    }

    @Override
    public void add(T obj){
        list.add(obj);
    }

    @Override
    public int getNextId(){
        return index++;
    }

    @Override
    public <M> T exist(M field) {
        return list.stream()
                .filter(obj->obj.compares(field))
                .findFirst()
                .orElse(null);
    }

}
