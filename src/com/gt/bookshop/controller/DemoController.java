package com.gt.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by GongTao  on 2017/2/19/019.
 */
@Controller
public class DemoController {
    @RequestMapping("/hello")
    public String getPage(){
        return "hello";
    }

    @RequestMapping("/test/*/*/ak")
    public String testAntPath(){
        System.out.print("test antpath");
        return "demo/result";
    }

    @RequestMapping("/test/pathvariable/{id}")
    public String testPathvarible(@PathVariable() Integer id,Model model){
        System.out.print("test Pathvarible");
        model.addAttribute("id",id);
        return "demo/result";
    }

    @RequestMapping(value = "/test/restful/order",method = RequestMethod.POST)
    public String testRestfulPost(){
        System.out.print("testRestfulPost ...");
        return "demo/result";
    }

    @RequestMapping(value = "/test/restful/order/{id}",method = RequestMethod.GET)
    public String testRestfulGet(@PathVariable("id") Integer id){
        System.out.print("testRestfulGet ... id为"+id);
        return "demo/result";
    }

    @RequestMapping(value = "test/restful/order/{id}",method = RequestMethod.PUT)
    public String testRestfulPut(@PathVariable("id") Integer id){
        System.out.print("testRestfulPut ... id为"+id);
        return "demo/result";
    }

    //使用 restful 风格的 url

    @RequestMapping(value = "test/restful/order/{id}",method = RequestMethod.DELETE)
    public String testRestfulDelete(@PathVariable("id") Integer id){
        System.out.print("testRestfulDelete ... id为"+id);
        return "demo/result";
    }

    @RequestMapping(value="test/requestParam",method=RequestMethod.GET)
    public String testRequestParams(@RequestParam(value = "name") String name,@RequestParam(value = "age") int age){
        System.out.print("testRequestParams,name:"+name+",age:"+age);
        return "demo/result";
    }





}
