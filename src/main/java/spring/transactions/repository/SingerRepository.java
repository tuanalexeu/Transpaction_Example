package spring.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.transactions.entity.Singer;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    @Query("select count(s) from Singer s")
    Long countAllSingers();
}
