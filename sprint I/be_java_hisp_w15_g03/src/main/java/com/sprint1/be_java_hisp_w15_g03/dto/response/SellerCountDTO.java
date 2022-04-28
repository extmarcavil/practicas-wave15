package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * US: 02
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerCountDTO extends PersonDTO {

    private Integer followersCount;

}
