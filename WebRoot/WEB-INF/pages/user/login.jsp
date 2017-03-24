<%--
  Created by IntelliJ IDEA.
  User: GongTao
  Date: 2017/2/11/011
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
  <meta name="Robots" content="index,follow"/>
  <title>"第三波书店"-网上书店</title>
  <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/css/member.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/Scripts/jquery-1.8.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/easyui1.5/jquery.easyui.min.js"></script>
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/icon.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/bootstrap/easyui.css" rel="stylesheet" />
  <script>
//    function userLogin() {
//      alert("ddd");
//      $('#loginForm').form('submit', {      //表单数据通过 ajax 请求发送到后台进行判断
//        url: '/user/login',
//        onSubmit: function () {
//        },
//        success: function (data) {
//          var data = eval('(' + data + ')');  // change the JSON string to javascript object
//          alert("dsf")
//          if (data.success == 0) {
////            location.reload(true);          //这里重新刷新页面 session 中有值则进入后台欢迎界面
//            $.messager.alert('成功提示', '登录成功！！！', 'info');
//          } else if (data.success == -1) {
//            $.messager.alert('错误提示', '登录失败，请检查用户名或密码!', 'error');
//          }
//        }
//      });
//    }
  </script>
</head>
<body>
<div id="top">
  <c:choose>
    <c:when test="${sessionScope.name==null}">
      <div class="status">您好，欢迎来到第三波书店^_^
         <span>
           <a href="user/login">【登录】</a>
           <a href="user/login">【免费注册】</a>
           <a href="user/login">【购物车】</a>
         </span>
      </div>
    </c:when>
    <c:otherwise>
      <span>
         <a href="user/login">【会员中心】</a>
         <a href="user/login">【购物车】</a>
         <a href="user/login">【退出】</a>
      </span>
    </c:otherwise>
  </c:choose>


  <%--<div class="status">您好，欢迎来到第三波书店^_^--%>
  <%--<span>--%>
  <%--【会员中心】【购物车】【退出】--%>
  <%--</span>--%>
  <%--</div>--%>

  <div class="member">
    <ul>
      <li><a href="#"><img src="${pageContext.request.contextPath}/img/payVIP.gif" height="18" alt="开通VIP"/></a></li>
      <li><a href="#"><img src="${pageContext.request.contextPath}/img/payCoin.gif" height="18" alt="学币中心"/></a></li>
    </ul>
  </div>
</div>

<div id="header">
  <div id="logo"><img src="${pageContext.request.contextPath}/img/logo.gif" alt="第三波书店"/></div>
  <div id="nav">
    <div id="a_b_01"><img src="${pageContext.request.contextPath}/img/a_b_01.gif"/>[<img src="${pageContext.request.contextPath}/img/taobao.gif"/> <a href="#">分站</a>]</div>
    <ul id="mainnav">
      <LI CLASS="CURRENT"><A HREF="INDEX.HTML">首页</A></LI>
      <LI><A HREF="LOGIN.HTML">登录</A></LI>
      <LI><A HREF="REGISTER.HTML">注册</A></LI>
      <LI><A HREF="#">商讯</A></LI>
      <LI><A HREF="#">购物流程</A></LI>
      <LI><A HREF="#">在线客服</A></LI>
      <LI><A HREF="#">积分兑换</A></LI>
      <LI><A HREF="#">书籍求购</A></LI>
      <LI><A HREF="#">帮助</A></LI>
    </ul>
  </div>
</div>

<div id="container">
  <!--left content-->
  <div id="intro">
    <div id="basket"><a href="#">目前您的购物篮是空的</a></div>
    <div id="search">
      <form action="" method="post" target="_blank">
        <input type="text" id="keyword" class="search_key" />
        <input type="submit" id="s_submit" class="search_sub" value="" />
      </form>
    </div>
    <div id="alltype">
      <h1 class="all_type black"><a href="#">查看所有分类>></a></h1>
      <div id="subnav">
        <ul class="black">
          <li><a href="#">VIP中心</a></li>
          <li><a href="#">新品上架</a></li>
          <li><a href="#">新书热卖</a></li>
          <li><a href="#">畅销排行</a></li>
          <li><a href="#">商务英语</a></li>
          <li><a href="#">英语口译</a></li>
          <li><a href="#">日语考试</a></li>
          <li><a href="#">实用日语</a></li>
          <li><a href="#">英语考试</a></li>
          <li><a href="#">实用英语</a></li>
          <li><a href="#">出国留学</a></li>
          <li><a href="#">英文原版</a></li>
          <li><a href="#">考研图书</a></li>
          <li><a href="#">所有图书</a></li>
          <li><a href="#">在线读书</a></li>
          <li><a href="#">电子词典</a></li>
          <li><a href="#">计算机类</a></li>
          <li><a href="#">科普读物</a></li>
          <li><a href="#">建筑门类</a></li>
        </ul>
      </div>
      <!--subnav end-->
    </div>
    <!--link start-->
    <div id="choice_pub">
      <select name="publishs" id="publishs" class="n_select">
        <option>>>根据出版社选择图书</option>
        <option>北京师范大学出版社</option>
        <option>电子工业出版社</option>
      </select>

      <select name="publishs" id="special" class="n_select">
        <option>>>根据专题选择图书</option>
        <option>国庆出游专题</option>
        <option>新年计划专题</option>
      </select>
    </div>

    <div id="s_b_03"><a href="#">赖世雄美语从头学</a><br /><a href="#">沪江团购 ，价格更优惠</a></div>
    <!--link start-->
  </div>

  <div id="action_area">
    <h2 class="action_type">
      <img src="${pageContext.request.contextPath}/img/login_in.gif" alt="会员登录" /></h2>
    <p class="state">欢迎光临第三波书店网站，本站为淘宝网旗下专业在线书店！<br />您可以使用第三波书店的用户名，直接登录。</p>

    <form id="loginForm" action="/user/login" method="post">
      <table>
        <tr style="height:50px">
          <th style="font-size:20px; ">账 号:</th>
          <td><input type="text" class="easyui-textbox" style="width:100%;height:30px;"  prompt='请填写用户名'  id="LoginName" name="loginId"/></td>
        </tr>
        <tr>
          <th style="font-size:20px; ">密 码:</th>
          <td><input type="text" class="easyui-passwordbox" style="width:100%;height:30px;"  prompt='请填写密码'  id="LoginPassword" name="loginPwd"/></td>
        </tr>

        <tr style="height:50px">
          <td colspan="2" style="text-align:center">
            <%--<a class="easyui-linkbutton" id="userLogin" onclick="userLogin()"--%>
               <%--data-options="iconCls:'icon-ok'"--%>
               <%--href="javascript:void(0)"--%>
               <%--style="width:80px">登录</a>--%>
              <input type="submit" value="登陆">
            <a class="easyui-linkbutton" id="adminRegister"
               data-options="iconCls:'icon-add'"
               href="javascript:void(0)"
               onclick="addNewAdmin()"
               style="width:80px">用户注册</a>
          </td>
        </tr>
      </table>
    </form>
  </div>

</div>

<div id="footer">
  <!--contac us-->
  <div class="telephone">
    <strong>热线</strong> 021-61508168　<strong>传真</strong> 021-61508168-8020　 <br/>
    <strong>Q Q</strong>375013071  13483528    562655482  1143735195（技术)<br/>
    <strong>MSN</strong> hjservice@hotmail.com   <strong>信箱</strong> shop@hjenglish.com<br/>
    <strong>帮助</strong> <a href="${pageContext.request.contextPath}/help/help.aspx" target="_blank">银行汇款帐户</a> <a href="${pageContext.request.contextPath}/help/help.aspx#help_post"
                                                                                target="_blank">邮局汇款地址</a> <a
          href="${pageContext.request.contextPath}/help/help.aspx#help_ship" target="_blank">送货方式及费用</a> <a
          href="http://www.hjenglish.com/down/faq_2.htm" target="_blank">如何进行下载</a>
  </div>
  <!---->
  <div class="imp_link">
    <img src="${pageContext.request.contextPath}/img/alipay.gif" alt="支付宝支付"/><img src="${pageContext.request.contextPath}/img/online_pay.gif" alt="在线支付"/><br/>
    <a href="http://www.hjenglish.com/about/aboutus.htm" target="_blank">网站介绍</a>　<a
          href="http://www.hjenglish.com/about/partner.htm" target="_blank">合作伙伴</a>　<a href="#"
                                                                                        target="_blank">网站地图</a>　<a
          href="#" target="_blank">联系我们</a><br/>
    <a href="#" target="_blank">增值电信业务经营许可证沪B2-20040503</a></div>
</div>

<div id="child_site">
  <span>您是第 @HttpContext.Current.Application["total"] 个访客</span>
  '<span>当前在线：@HttpContext.Current.Application["online"] </span>
  <strong>分站</strong>　 <a href="#" target="_blank">沪江网</a>  <a href="#" target="_blank">听说</a>  <a href="#"
                                                                                                   target="_blank">口译</a> 
  <a href="#" target="_blank">CET</a>  <a href="#" target="_blank">考研</a>  <a href="#" target="_blank">雅思</a>  <a
        href="#" target="_blank">托福</a>  <a href="#" target="_blank">日语</a>  <a href="#" target="_blank">法语</a>  <a
        href="#" target="_blank">下载</a>  <a href="#" target="_blank">文库</a>  <a href="#" target="_blank">部落</a>  <a
        href="#" target="_blank">博客</a>  <a href="#" target="_blank">词典</a>  <a href="#" target="_blank">IT新闻</a>  <a
        href="#" target="_blank">博客园</a>  <a title="新世界日语" href="#" target="_blank">新世界日语</a>  <a title="2010考研书籍推荐专题"
                                                                                                  href="#"
                                                                                                  target="_blank">2010考研书籍</a>
</div>
</body>
</html>
