package com.bootcamp.consecionariahql.Repository;

import com.bootcamp.consecionariahql.Model.Crash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrashRepo extends JpaRepository<Crash, Long> {
}
