package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.repository.ISocialMeliRepository;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;

    public SocialMeliService(ISocialMeliRepository repository) {
        this.repository = repository;
    }
}
