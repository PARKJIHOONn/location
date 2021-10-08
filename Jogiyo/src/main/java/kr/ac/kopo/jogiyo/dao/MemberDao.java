package kr.ac.kopo.jogiyo.dao;

import java.util.List;

import kr.ac.kopo.jogiyo.model.Member;

public interface MemberDao {

	void add(Member item);

	int checkId(String id);

	Member item(String id);

	List<Member> list();

	void update(Member item);

	void delete(String id);

	Member login(String id);

}
