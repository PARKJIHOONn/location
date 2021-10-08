package kr.ac.kopo.jogiyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.jogiyo.dao.MemberDao;
import kr.ac.kopo.jogiyo.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

   @Autowired
   MemberDao dao;
   
   @Override
   public void add(Member item) {
      dao.add(item);
   }

@Override
public boolean checkId(String id) {
	if(dao.checkId(id) > 0)
		return false;
	else
		return true;
}

@Override
public Member item(String id) {
	return dao.item(id);
}

@Override
public List<Member> list() {
	return dao.list();
}

@Override
public void update(Member item) {
	dao.update(item);
	
}

@Override
public void delete(String id) {
	dao.delete(id);
	
}

@Override
public Member login(String id) {
	return dao.login(id);
}

}