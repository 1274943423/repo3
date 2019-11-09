package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Lable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;


@Service
public class LableService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

   public List<Lable> findAll(){
       return labelDao.findAll();
   }
   public Lable findById(String id){
       return labelDao.findById(id).get();
   }
    public void add(Lable lable){
       lable.setId(idWorker.nextId()+"");
       labelDao.save(lable);
    }
    public void update(Lable lable){
       labelDao.save(lable);
    }
    public void delete(String id){
       labelDao.deleteById(id);
    }

}
