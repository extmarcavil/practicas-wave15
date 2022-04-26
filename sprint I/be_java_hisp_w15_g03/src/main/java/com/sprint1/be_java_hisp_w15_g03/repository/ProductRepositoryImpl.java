package com.sprint1.be_java_hisp_w15_g03.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    Map<Integer, Seller> sellers;

    static int cantPublicacion;

    public ProductRepositoryImpl() {
        this.sellers = new HashMap<>();

        List<Publication> p1 = new ArrayList<>();
        Publication p = new Publication(1, LocalDate.now(), Category.MESA, 300.5D, null, false, null);
        p1.add(p);
        cantPublicacion = 1;
        sellers.put(1, new Seller(1, "v1", new ArrayList<Publication>(p1)));
    }



    @Override
    public boolean userExist(Integer userId) {
        return  !Objects.isNull(sellers.get(userId));
    }

    @Override
    public void savePublication(Integer userId, Publication p) {
        cantPublicacion+=1;
        p.setPostId(cantPublicacion);
        sellers.get(userId).getPublications().add(p);
        System.out.println(sellers.get(userId));

    }
}
