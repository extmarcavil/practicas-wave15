package fixture;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterFixture {

    public static CharacterDTO aCharacterDTO() {
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        return luke;
    }

    public static CharacterDTO otherCharacterDTO() {
        CharacterDTO luke2 = new CharacterDTO();
        luke2.setName("Luke Sad");
        return luke2;
    }
}
