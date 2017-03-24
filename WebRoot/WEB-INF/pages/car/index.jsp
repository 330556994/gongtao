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
  <link href="${pageContext.request.contextPath}/css/member.css" rel="stylesheet" type="text/css"/>
  <script src="${pageContext.request.contextPath}/Scripts/jquery-1.8.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/easyui1.5/jquery.easyui.min.js"></script>
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/icon.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/bootstrap/easyui.css" rel="stylesheet" />
  <script>
    function deleteBook(bookid) {
      if(confirm('真的要删除么?')==true){
        var url = "/car/delete/"+bookid;
        $.getJSON(url,null,function(json){
          if(json.success==0){
            alert('删除成功');location.href='/car';
          }else{
            alert('删除失败');location.href='/car';
          }
        });
      }
    }
    function update(bookid,qty){
      var url="car/update/"+bookid+"/"+qty;
      $.getJSON(url,null,function(json){
        if(json.success==0){
          if(json.success==0){
            alert('修改成功');location.href='/car';
          }else{
            alert('修改失败');location.href='/car';
          }
        }
      });
    }
  </script>
</head>
<body>
<div id="top">
  <c:set var="totolMPrice" value="0"></c:set>
  <c:set var="totolUPrice" value="0"></c:set>
  <c:set var="buyCount" value="0"></c:set>
  <c:forEach items="${items}" var="item">
    <c:set var="totolMPrice" value="${totolMPrice+item.marketPrice*item.qty }"></c:set>
    <c:set var="totolUPrice" value="${totolUPrice+item.unitPrice*item.qty }"></c:set>
    <c:set var="buyCount" value="${buyCount+item.qty }"></c:set>
  </c:forEach>
  <c:choose>
    <c:when test="${sessionScope.name==null}">
      <div class="status">您好，欢迎来到第三波书店^_^
         <span>
           <a href="book/login">【登录】</a>
           <a href="user/login">【免费注册】</a>
           <a href="car">【购物车】</a>
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
    <div id="basket">
      <a href="#">
        <c:choose>
          <c:when test="${items.size()==0}">
            目前您的购物篮是空的
          </c:when>
          <c:otherwise>
            共购买${buyCount}本书，应付${totolUPrice}元
          </c:otherwise>
        </c:choose>
      </a></div>
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

    <div id="s_b_03">
      <a href="#">赖世雄美语从头学</a><br />
      <a href="#">沪江团购 ，价格更优惠</a></div>
    <!--link start-->
  </div>

  <div id="action_area">
    <table width="96%" border="0" cellspacing="3" cellpadding="0" align="center" class="data_table">
      <thead>
      <tr>
        <th scope="col">商品名</th>
        <th scope="col" width="10%">原价</th>
        <th scope="col" width="10%">优惠价</th>
        <th scope="col" width="10%">打折</th>
        <th scope="col" width="10%">数量</th>
        <th scope="col" width="10%">操作</th>
      </tr>
      </thead>
      <tbody id="basket_data" >
        <c:forEach items="${items}" var="is">
            <tr>
              <td class="name">
                <a href="books/detail/${is.id}">
                ${is.title}
                </a>
              </td>
              <td>${is.marketPrice}</td>
              <td>${is.unitPrice}</td>
              <td>${is.unitPrice/is.marketPrice} 折</td>
              <td>
                <input type="hidden" value="${is.id}" name="id" />
                <input type="text" id="qty" name="qty" value="${is.qty}" />
              </td>
              <td>
                <a onclick="deleteBook(${is.id})" href="javascript:void(0)">删除</a>
                <input type="submit" value="更新"  />
                <a href="javascript:void(0)"
                   onclick="update(${is.id},$('#qty').val())">更新</a>
              </td>
            </tr>
        </c:forEach>
      </tbody>
      <tfoot><tr><td colspan="6">
        继续挑选商品  市场总价 ${totolMPrice} 元，
        会员总价 ${totolUPrice}
        您共节省 ${totolMPrice-totolUPrice}  元</td>
      </tr></tfoot></table>


    <p class="form_sub basker_ok_link">
      <a href="javascript:void(0)" onclick="window.history.go(-1)">继续购物</a><a href="javascript:void(0)" onclick="window.history.go(-1)">清空购物车</a>
      <input type="submit" value="" class="basker_ok" onclick="location.href = '/IntegralGoods/index'" />
    </p>

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
