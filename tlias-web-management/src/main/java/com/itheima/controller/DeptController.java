package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*查询所有部门*/
    @GetMapping( "/depts")
    public Result list(){
        System.out.println("查询全部部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }

    /*
    * 根据ID删除部门
    * 注意事项：一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错
    * */

    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据id删除部门");
        deptService.deleteById(id);
        return Result.success();
    }

    /*添加部门*/
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加新的部门");
        deptService.add(dept);
        return Result.success();
    }

    /*根据id查询部门*/
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据id查询部门");
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result modifyDept(@RequestBody Dept dept){
        System.out.println("修改部门");
        deptService.modifyDept(dept);
        return Result.success();
    }



}
