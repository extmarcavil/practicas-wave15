package unit.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FavoriteRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FavoriteRepositoryImpl;

public class FavoritesRepositoryTest {
	private FavoriteRepository favoriteRepository = new FavoriteRepositoryImpl();
	
	@Test
	void test1() {
		Boolean result = favoriteRepository.existFavorite(null, null);
		Assertions.assertFalse(result);
	}

}
