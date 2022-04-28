package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;

    /**
     * User
     * Dice si dos usuarios son iguales
     *
     * @param anUser El otro usario a comparar
     */
    public Boolean equals(User anUser) {
    	        return this.userId.equals(anUser.getUserId());
    }
}
