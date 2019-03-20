package tsdv.com.vn.demosimplemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsdv.com.vn.demosimplemanager.dataset.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}
