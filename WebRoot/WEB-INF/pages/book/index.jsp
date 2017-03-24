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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
  <meta name="Robots" content="index,follow"/>
  <title>"第三波书店"-网上书店</title>
  <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css"/>
  <script src="${pageContext.request.contextPath}/Scripts/jquery-1.8.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/easyui1.5/jquery.easyui.min.js"></script>
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/icon.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/bootstrap/easyui.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/css/channel.css" rel="stylesheet" />
  <script>
    //obj代表的是一个下拉列表 ，注意是select元素的包装集对象
    //value代表的是值
    //这个函数的功能是，把obj这个select元素里的option的value值
    //为value的项选中
    function findByValue(obj, value) {
      //find方法是在包装集内部进行查询，参数为选择器
      //prop操作元素的属性,这里表示设置selected属性值为selected
      //即实现的效果是该项选中
      obj.find("option[value='" + value + "']").prop("selected", "selected");
    }
    //启动事件
    $(function () {
      //先把排序的下拉列表恢复之前选择的
      findByValue($("#ddlSort"), '@sort');
      //排序的下拉列表被改变后激发
      $("#ddlSort").change(function () {
        var sort = $("#ddlSort").val();//获得select的选中值
        var url = '/books/index?id=@id&pageindex=1&sort=' + sort;
        location.href = url;

      });
    });
    function buy(bookid) {
      var url = "/car/buy/"+bookid;
      $.getJSON(url,null,function(json){
        if(json.success==0){
          alert("购买成功！");
//          location.href="${pageContext.request.contextPath}/";
        }else{
          alert("购买失败！");
        }
      });
    }
    function collection(bookid,bookname) {
      $.get("/car/checkcollection", { "bookid": bookid }, function (json) {
        if (json.success == 0) {
          var url = "/car/Collection";
          var data = { "bookid": bookid };
          $.get(url, data, function (json) {
            if (json.success == 0) {
              $.messager.alert('成功提示', '书名为《' + bookname + '》已经收藏到您的收藏夹中！', 'info');
            } else {
              $.messager.alert('错误提示', '收藏失败!', 'error');
            }
          }, "json");
        } else {
          $.messager.alert('错误提示', '这本书你已经收藏过了 ！！!', 'error');
        }
      }, "json");
    }
  </script>
</head>
<body>
<div id="top">
  <c:set var="totolMPrice" value="0"></c:set>
  <c:set var="totolUPrice" value="0"></c:set>
  <c:set var="buyCount" value="0"></c:set>
  <c:forEach items="${items}" var="item">
    <c:set var="totolMPrice" value="${totolMPrice+item.marketPrice }"></c:set>
    <c:set var="totolUPrice" value="${totolUPrice+item.unitPrice }"></c:set>
    <c:set var="buyCount" value="${buyCount+item.qty }"></c:set>
  </c:forEach>
  <c:choose>
    <c:when test="${sessionScope.name==null}">
      <div class="status">您好，欢迎来到第三波书店^_^
         <span>
           <a href="user/login">【登录】</a>
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

<div id="a_b_04"><img src="${pageContext.request.contextPath}/img/a_b_04.jpg" alt="" /></div>

<div id="breadcrumb">您现在的位置： <a href="${pageContext.request.contextPath}/">首页</a>  >
  <a href="${pageContext.request.contextPath}/books/index/${id}"
  class="red">

  ${categoryName}

  </a></div>

<div id="container">
  <div id="intro">
    <div id="basket">
      <c:choose>
        <c:when test="${items==null}">
          目前您的购物篮是空的
        </c:when>
        <c:otherwise>
          共购买${buyCount}本书，应付${totolUPrice}元
        </c:otherwise>
      </c:choose>
    </div>
    <!--调用结束-->
    <div class="child_menu">
      <h2 class="white">图书分类</h2>
      <ul>
        <c:forEach items="${categories}" var="c">
          <li><a href="${pageContext.request.contextPath}/books/index/${c.id}">${c.name}</a></li>
        </c:forEach>
        <li><a href="${pageContext.request.contextPath}/ClearBooks/index">清仓货物</a></li>
      </ul>
    </div>

    <div class="history">
      <h2>最近的浏览记录</h2>
      <ul>
        <li><span>&middot;</span><a href="#">暮光之城-月食</a></li>
        <li><span>&middot;</span><a href="#">家小团圆（张爱玲...</a></li>
        <li><span>&middot;</span><a href="#">完全图解哇野外求...</a></li>
        <li><span>&middot;</span><a href="#">近代女性服饰演变...</a></li>
        <li><span>&middot;</span><a href="#">【6折】碧血剑</a></li>
      </ul>
    </div>
  </div>

  <div class="main">
    <div class="list_asc">
      <!--choice order type-->
      <div class="type_choice f_left">
        排序方式
        <select name="sort" id="ddlSort">
          <option  value="a.id asc">默认升序</option>
          <option value="a.id desc">默认降序</option>
          <option value="unitprice asc">价格升序</option>
          <option value="unitprice desc">价格降序</option>
          <option value="PublishDate asc">出版日期升序</option>
          <option value="PublishDate desc">出版日期降序</option>
        </select>
      </div>
      <!--page no-->
      <div class="turn_area f_right">
        <a href="@string.Format("/books/index?id={0}&pageindex=1&sort={1}"
        ,id,sort
        )">!< </a>
        <a href="@string.Format("/books/index?id={0}&pageindex={1}&sort={2}"
        ,id,prevpage,sort
        )"><< </a>
                <span id="turn_page">第@(pageindex)页
                    共@(pagecount)页 记录总数：@recordcount

                </span>
        <a href="@string.Format("/books/index?id={0}&pageindex={1}&sort={2}"
        ,id,nextpage,sort
        )">
        >> </a>
        <a href="@string.Format("/books/index?id={0}&pageindex={1}&sort={2}"
        ,id,pagecount,sort
        )">>! </a>
      </div>

    </div>
    <c:forEach items="${books}" var="b">
      <dl class="list_area">
        <dt>
          <a href="${pageContext.request.contextPath}/books/detail/${b.id}">
            <img src="${pageContext.request.contextPath}/img/BookCovers/${b.ISBN}.jpg"
                 width="100" height="100"
                 alt="${b.title}" /></a>
        </dt>
        <dd>
          <h2 class="b_title">
            <a href="${pageContext.request.contextPath}/books/detail/${b.id}">
                ${b.title}
            </a></h2>
          <!--将书籍的id 写入span-->
          <div class="b_score">顾客评分：
            <span id="book_id_15">${b.bookRating}</span></div>
          <div class="b_property">作者：${b.author} 编著<br />
            出版社：${b.publisher.name}<br />
            出版时间：<fmt:formatDate value="${b.publishDate}" pattern="yyyy-MM-dd"/></div>

          <div class="b_buy" >
                	<span class="gray del">
                        ${b.marketPrice}</span>
            　<span class="red">
              ${b.unitPrice}</span>
            　折扣：
              ${b.unitPrice/b.marketPrice}
            折　节省：${b.marketPrice-b.unitPrice}
            <a href="javascript:void(0)" onclick="buy(${b.id})">
              <img src="${pageContext.request.contextPath}/img/btn_goumai.gif"
                   onmouseover="this.src='/img/btn_goumai_click.gif'"

                   onmouseout="this.src='/img/btn_goumai.gif'"
                      />
            </a>
            <a href="javascript:void(0)" onclick="collection(@book.Id,'@book.Title')">
              <img src="${pageContext.request.contextPath}/img/btn_zancun.gif"
                   onmouseout="this.src='/img/btn_zancun.gif'"
                   onmouseover="this.src='/img/btn_zancun_click.gif'" />
            </a>
          </div>
        </dd>
      </dl>
    </c:forEach>

    <div class="pages">
      <a href="#" title="前一页" class="first"><<</a>
      <a href="#" title="" class="current">1</a>
      <a href="#" title="">2</a>
      <a href="#" title="">3</a>
      <a href="#" title="">4</a>
      <a href="#" title="">5</a>
      <a href="javascript:void(0)" class="more">...</a>
      <a href="#" title="">106</a>
      <a href="#" title="">107</a>
      <a href="#" title="">108</a>
      <a href="#" title="">109</a>
      <a href="#" title="">110</a>
      <a href="#" title="后一页" class="end">>></a>
    </div>

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
