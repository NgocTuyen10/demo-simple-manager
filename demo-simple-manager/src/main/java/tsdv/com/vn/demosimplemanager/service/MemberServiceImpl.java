package tsdv.com.vn.demosimplemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsdv.com.vn.demosimplemanager.dataset.Member;
import tsdv.com.vn.demosimplemanager.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository repository; 
	@Override
	@Transactional
	public void create(Member member) {
		Optional<Member> tmp = repository.findById(member.getUserid());
		if(tmp != null) {
			throw new DuplicateKeyException("Duplicate userid");
		}
		repository.save(member);
	}

	@Override
	public List<Member> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String userid) {
		repository.deleteById(userid);
	}

	@Override
	public Optional<Member> findOne(String userid) {
		return repository.findById(userid);
	}
}
