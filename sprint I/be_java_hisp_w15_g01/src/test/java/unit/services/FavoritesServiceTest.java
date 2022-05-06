package unit.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoritesCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Favorite;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FavoriteRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.FavoriteServiceImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;

@ExtendWith(MockitoExtension.class)
public class FavoritesServiceTest {
	@Mock
	private UserService userService;
	@Mock
    private PostRepository postRepository;
	@Mock
    private FavoriteRepository favoriteRepository;
@InjectMocks
    private FavoriteServiceImpl service;
    
@Test
void test1() {
	User user = new User(1L, "pepe");
	Mockito.when(userService.findById(1L)).thenReturn(user);
	Favorite f = new Favorite(user, null);
	Mockito.when(favoriteRepository.whoFavorite(user)).thenReturn(List.of(f,f));
	FavoritesCountDTO dto = service.getFavorites(1L);
	Assertions.assertEquals(2, dto.getFavoritesCount());
}

    
	

}
