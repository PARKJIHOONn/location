package kr.ac.kopo.jogiyo.service;

import java.util.List;

import kr.ac.kopo.jogiyo.model.Member;

public interface MemberService {

	void add(Member item);

	boolean checkId(String id);

	Member item(String id);

	List<Member> list();

	void update(Member item);

	void delete(String id);

	Member login(String id);


}
