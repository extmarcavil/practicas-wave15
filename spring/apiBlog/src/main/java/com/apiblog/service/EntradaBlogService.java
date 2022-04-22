package com.apiblog.service;

import com.apiblog.dto.request.EntradaBlogRequestDTO;
import com.apiblog.dto.response.EntradaBlogResponseDTO;
import com.apiblog.model.EntradaBlog;
import com.apiblog.repository.IEntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService {

    //region Variables
    private IEntradaBlogRepository _entradaBlogRepository;
    private ModelMapper _mapper;
    //endregion

    //region Constructor

    public EntradaBlogService(IEntradaBlogRepository entradaBlogRepository) {
        this._entradaBlogRepository = entradaBlogRepository;
        this._mapper = new ModelMapper();
    }

    //endregion

    //region Implementacion

    @Override
    public Integer insertarEntradaBlog(EntradaBlogRequestDTO nuevaEntradaDTO) {
       return _entradaBlogRepository.add(_mapper.map(nuevaEntradaDTO, EntradaBlog.class));
    }

    @Override
    public List<EntradaBlogResponseDTO> todoEntradaBlog() {
        var listType = new TypeToken<List<EntradaBlogResponseDTO>>(){}.getType();
        return _mapper.map(_entradaBlogRepository.getAll(),listType);
    }

    @Override
    public EntradaBlogResponseDTO entradaBlogId(int id) {
        return  _mapper.map(_entradaBlogRepository.findById(id),EntradaBlogResponseDTO.class);
    }

    //endregion
}
