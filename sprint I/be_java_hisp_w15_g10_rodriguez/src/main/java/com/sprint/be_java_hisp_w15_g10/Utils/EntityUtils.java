package com.sprint.be_java_hisp_w15_g10.Utils;

import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import com.sprint.be_java_hisp_w15_g10.Model.IIdInterface;
import com.sprint.be_java_hisp_w15_g10.Repository.EntityRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EntityUtils<T extends IIdInterface> {
    private final ModelMapper modelMapper;
    private final EntityRepository<T> entityRepository;

    public EntityUtils(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        entityRepository = new EntityRepository<>();
    }

    public <D extends DTOEntity> D convertToDto(T obj, D dto) {
        return (D) modelMapper.map(obj, dto.getClass());
    }

    public T convertToEntity(DTOEntity dto, T obj) {
        return (T) modelMapper.map(dto, obj.getClass());
    }

    public <D extends DTOEntity> List<D> convertToListOfDTO(List<T> listObj, D dto){
        return listObj.stream().map(l -> convertToDto(l, dto)).collect(Collectors.toList());
    }

    public List<T> convertToListOfEntity(List<DTOEntity> llisDTO, T obj){
        return llisDTO.stream().map(ls -> convertToEntity(ls, obj)).collect(Collectors.toList());
    }

    public T getObjectByIdOrThrow(int id, RuntimeException exception) {
        return entityRepository.getById(id).orElseThrow(() -> exception);
    }

    public List<T> getAllObjects(){
        return entityRepository.getAll();
    }

    public <D extends DTOEntity, M> boolean addObject(T newObject, M field){
        T object = entityRepository.exist(field);;
        if(object == null){
            object = newObject;
            object.setId(entityRepository.getNextId());
            entityRepository.add(object);
            return true;
        }
        return false;
    }
}
