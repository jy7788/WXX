package com.cn.hnust.dao;

import com.cn.hnust.model.Pager;
import com.cn.hnust.model.Person;

public interface IPersonDao {
    public void add(Person p);
    
    public void update(Person p);
    
    public Person load(int id);
    
    public void delete(int id);
    
    public Pager<Person> find(String name);
    
}