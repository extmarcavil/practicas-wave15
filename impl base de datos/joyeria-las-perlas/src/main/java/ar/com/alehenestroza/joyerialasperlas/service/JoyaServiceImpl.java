package ar.com.alehenestroza.joyerialasperlas.service;

import ar.com.alehenestroza.joyerialasperlas.dto.request.JoyaDTO;
import ar.com.alehenestroza.joyerialasperlas.exception.JoyaNotFoundException;
import ar.com.alehenestroza.joyerialasperlas.mapper.JoyaMapper;
import ar.com.alehenestroza.joyerialasperlas.model.Joya;
import ar.com.alehenestroza.joyerialasperlas.repository.JoyaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements JoyaService {
    private final JoyaRepository joyaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll().stream()
                .filter(Joya::getHasStone)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long saveJoya(JoyaDTO joya) {
        Joya newJoya = JoyaMapper.dtoToEntity(joya);
        return joyaRepository.save(newJoya).getId();
    }

    @Transactional
    @Override
    public Long deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (!isValidJoya(joya)) throw new JoyaNotFoundException("No existe una joya con ese ID.");
        joya.setIsAvailable(false);
        return joyaRepository.save(joya).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Joya update(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (!isValidJoya(joya)) throw new JoyaNotFoundException("No existe una joya con ese ID.");
        joya = JoyaMapper.updateEntity(joya, joyaDTO);
        return joyaRepository.save(joya);
    }

    private boolean isValidJoya(Joya joya) {
        return joya != null && joya.getIsAvailable();
    }
}
