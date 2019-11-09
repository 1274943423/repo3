package com.tensquare.base.controller;


import com.tensquare.base.pojo.Lable;
import com.tensquare.base.service.LableService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Lable")
@CrossOrigin
public class LabelController {

    @Autowired
    private LableService lableService;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",lableService.findAll());
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findById(id));
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result insert(@RequestBody Lable lable){
        lableService.add(lable);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Lable lable,@PathVariable String id){
        lable.setId(id);
        lableService.update(lable);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        lableService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Lable lable){

        return new Result(true,StatusCode.OK,"查詢成功");
    }
}
