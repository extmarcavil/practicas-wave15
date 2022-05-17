package ar.com.alehenestroza.joyerialasperlas.mapper;

import ar.com.alehenestroza.joyerialasperlas.dto.request.JoyaDTO;
import ar.com.alehenestroza.joyerialasperlas.model.Joya;

public class JoyaMapper {
    public static Joya dtoToEntity(JoyaDTO joyaDTO) {
        Joya joyaEntity = new Joya();
        joyaEntity.setId(null);
        joyaEntity.setName(joyaDTO.getName());
        joyaEntity.setMaterial(joyaDTO.getMaterial());
        joyaEntity.setWeight(joyaDTO.getWeight());
        joyaEntity.setUniqueQuality(joyaDTO.getUniqueQuality());
        joyaEntity.setHasStone(joyaDTO.getHasStone());
        joyaEntity.setIsAvailable(true);

        return joyaEntity;
    }
    public static Joya updateEntity(Joya joya, JoyaDTO joyaDTO) {
        Joya joyaEntity = new Joya();
        joyaEntity.setId(joya.getId());
        joyaEntity.setName(joyaDTO.getName());
        joyaEntity.setMaterial(joyaDTO.getMaterial());
        joyaEntity.setWeight(joyaDTO.getWeight());
        joyaEntity.setUniqueQuality(joyaDTO.getUniqueQuality());
        joyaEntity.setHasStone(joyaDTO.getHasStone());
        joyaEntity.setIsAvailable(true); // Si no era true, nunca se actualizaría la entidad.

        return joyaEntity;
    }

}
