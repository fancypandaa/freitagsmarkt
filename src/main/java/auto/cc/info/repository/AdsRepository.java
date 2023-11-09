package auto.cc.info.repository;

import auto.cc.info.domain.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends JpaRepository<Ads,Long> {
    Page<Ads> findAll(Pageable pageable);

}
