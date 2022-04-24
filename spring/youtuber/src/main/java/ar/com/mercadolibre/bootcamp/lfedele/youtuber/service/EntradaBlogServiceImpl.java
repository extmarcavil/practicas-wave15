package ar.com.mercadolibre.bootcamp.lfedele.youtuber.service;

import ar.com.mercadolibre.bootcamp.lfedele.youtuber.dto.EntradaBlogDto;
import ar.com.mercadolibre.bootcamp.lfedele.youtuber.exceptions.EntradaBlogConIdDuplicadoException;
import ar.com.mercadolibre.bootcamp.lfedele.youtuber.exceptions.EntradaBlogInexistenteException;
import ar.com.mercadolibre.bootcamp.lfedele.youtuber.model.EntradaBlog;
import ar.com.mercadolibre.bootcamp.lfedele.youtuber.repository.EntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogServiceImpl implements  EntradaBlogService{
    private final EntradaBlogRepository entradaBlogRepository;
    private final ModelMapper modelMapper;

    public EntradaBlogServiceImpl(EntradaBlogRepository entradaBlogRepository) {
        this.entradaBlogRepository = entradaBlogRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Long save(EntradaBlogDto entradaBlogDto) {
        Long id = entradaBlogDto.getId();
        if (entradaBlogRepository.existsById(id)) {
            throw new EntradaBlogConIdDuplicadoException(id);
        }
        EntradaBlog model = modelMapper.map(entradaBlogDto, EntradaBlog.class);
        entradaBlogRepository.save(model);
        return model.getId();
    }

    @Override
    public EntradaBlogDto findById(Long id) {
        return entradaBlogRepository
                .findById(id)
                .map(e -> modelMapper.map(e, EntradaBlogDto.class))
                .orElseGet(() -> { throw new EntradaBlogInexistenteException(id); });
    }

    @Override
    public List<EntradaBlogDto> findAll() {
        return entradaBlogRepository
                .findAll()
                .stream()
                .map(e -> modelMapper.map(e, EntradaBlogDto.class))
                .collect(Collectors.toList());
    }
}
