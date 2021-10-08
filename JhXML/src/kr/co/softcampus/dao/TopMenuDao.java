package kr.co.softcampus.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.BoardInfoBean;

@Repository //역할을 명시하기 위해서 사용 dao=repository
public class TopMenuDao {
	
	@Autowired  //쿼리문이 작성되어있는 topmenumapper를 주입받을 수 있게 하기위해 사용
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardInfoBean> getTopMenuList() {
		List<BoardInfoBean> topMenuList = sqlSessionTemplate.selectList("topmenu.get_topmenu_list");
		return topMenuList;
	}
}
