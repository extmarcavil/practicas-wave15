package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private Boolean deactivated;

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.deactivated = false;
    }
    
    public Boolean equals(User anUser) {
    	        return this.userId.equals(anUser.getUserId());
    }

    public void deactivate() {
        this.setDeactivated(true);
    }

    public void activate() {
        this.setDeactivated(false);
    }
}
