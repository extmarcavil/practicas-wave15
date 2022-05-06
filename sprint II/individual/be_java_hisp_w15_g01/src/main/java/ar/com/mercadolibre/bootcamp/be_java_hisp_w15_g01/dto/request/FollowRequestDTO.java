package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FollowRequestDTO {

    @NotNull(message = Constants.ID_NOT_NULL)
    @Min(value = Constants.ID_VALUE, message = Constants.ID_NOT_ZERO)
    private Long userId;

    @NotNull(message = Constants.ID_NOT_NULL)
    @Min(value = Constants.ID_VALUE, message = Constants.ID_NOT_ZERO)
    private Long userIdToFollow;
}
