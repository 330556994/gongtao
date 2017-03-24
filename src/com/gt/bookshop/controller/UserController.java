package com.gt.bookshop.controller;

import com.gt.bookshop.entities.User;
import com.gt.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户控制器
 * Created by GongTao on 2017/2/12/012.
 */

@Controller
//@RequestMapping 注解放在类上则作用与类下的所有方法之前均使用此前缀
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String login(){
        return "user/login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(User user,HttpSession session) throws IOException {
        //设置文件的响应流的字符类型
        //response.setCharacterEncoding("utf-8");
        //获取在方法入参中的 user 对象 并使用 userService 中的 login 方法将 user 对象传入如果返回为真则返回 0 如果为假则返回-1
        int result= userService.login(user)==true ? 0 : -1;
        if (result == 0) {
            //此处将登录成功的 user 用户信息放到Session 作用域中
            session.setAttribute("user",user);
        }
        //通过 response 相应流获取 write 对象 并将返回结果以 json 的格式返回
        //response.getWriter().write("{\"success\":"+result+" }");
        //
        //response.getWriter().flush();

        //如果登录成功则返回主页面 此时 session 作用域中存在一个 键为 user 值为验证成功的 user 对象
        return "redirect:/";
    }

    @RequestMapping(value="/exit",method=RequestMethod.GET)
    public String exit(HttpSession session){
        //如果 session 包含有 user 这个用户信息
        if(session.getAttribute("user")!=null){
            //移除用户信息
            session.removeAttribute("user");
        }
        //将 Session 作用域中的用户信息从作用域中移除之后跳转到首页
        return "redirect:/";
    }


}
