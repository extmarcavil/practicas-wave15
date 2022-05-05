package sprint2.socialmeli.unit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.repository.SocialMeliRepository;
import sprint2.socialmeli.service.ISocialMeliService;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest{

    @Mock
    ISocialMeliRepository mockSocialMeliRepository;

    @InjectMocks
    ISocialMeliService socialMeliService;

    @BeforeEach
    public void setUp(){
        //socialMeliRepository = new SocialMeliRepository();
    }

    // T-0003
    @Test
    @DisplayName("")
    public void test03AssertThatTheOrderIsGivenIsTheCorrectOne(){

    }



}
