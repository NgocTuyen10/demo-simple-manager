package tsdv.com.vn.demosimplemanager.service;

import java.util.List;
import java.util.Optional;

import tsdv.com.vn.demosimplemanager.dataset.Member;

public interface MemberService {

	void create(Member member);

	List<Member> findAll();

	void delete(String userid);

	Optional<Member> findOne(String userid);
}
