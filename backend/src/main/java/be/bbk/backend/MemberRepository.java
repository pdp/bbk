package be.bbk.backend;

import be.bbk.domain.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by peterdp on 20/03/2017.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllBy(Pageable pageable);
}
