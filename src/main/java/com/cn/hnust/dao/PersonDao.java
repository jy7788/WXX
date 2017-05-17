package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.model.Pager;
import com.cn.hnust.model.Person;


@Repository("personDao")
public class PersonDao extends BaseDao<Person> implements IPersonDao{

	@Override
	public void add(Person p) {
		super.add(p);
	}

	public Person load(int id) {
		return super.findById(Person.class, id);
	}

	public void delete(int id) {
		super.delete(Person.class, id);
	}
	
	@Override
	public void update(Person p) {
		super.update(p);
	}

	public Pager<Person> find(String s) {
		Map<String,Object> params = new HashMap<String, Object>();
		if(s!=null&&!s.equals(""))
			params.put("name", "%"+s+"%");
		return super.find(Person.class, params);
	}

}
