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
 * �û�������
 * Created by GongTao on 2017/2/12/012.
 */

@Controller
//@RequestMapping ע��������������������µ����з���֮ǰ��ʹ�ô�ǰ׺
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
        //�����ļ�����Ӧ�����ַ�����
        //response.setCharacterEncoding("utf-8");
        //��ȡ�ڷ�������е� user ���� ��ʹ�� userService �е� login ������ user �������������Ϊ���򷵻� 0 ���Ϊ���򷵻�-1
        int result= userService.login(user)==true ? 0 : -1;
        if (result == 0) {
            //�˴�����¼�ɹ��� user �û���Ϣ�ŵ�Session ��������
            session.setAttribute("user",user);
        }
        //ͨ�� response ��Ӧ����ȡ write ���� �������ؽ���� json �ĸ�ʽ����
        //response.getWriter().write("{\"success\":"+result+" }");
        //
        //response.getWriter().flush();

        //�����¼�ɹ��򷵻���ҳ�� ��ʱ session �������д���һ�� ��Ϊ user ֵΪ��֤�ɹ��� user ����
        return "redirect:/";
    }

    @RequestMapping(value="/exit",method=RequestMethod.GET)
    public String exit(HttpSession session){
        //��� session ������ user ����û���Ϣ
        if(session.getAttribute("user")!=null){
            //�Ƴ��û���Ϣ
            session.removeAttribute("user");
        }
        //�� Session �������е��û���Ϣ�����������Ƴ�֮����ת����ҳ
        return "redirect:/";
    }


}
