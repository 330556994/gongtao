<%--
  Created by IntelliJ IDEA.
  User: GongTao
  Date: 2017/2/11/011
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 导入头部文件 -->
<%@ include file="layout/head.html"%>

<div id="container" style="height: auto">
  <div id="intro">
    <div id="basket"><a href="car">
      <c:choose>
        <c:when test="${items==null}">
          目前您的购物篮是空的
        </c:when>
        <c:otherwise>
          共购买${buyCount}本书，应付${totolUPrice}元
        </c:otherwise>
      </c:choose>
    </a></div>
    <div id="search">
      <form action="" method="post" target="_blank">
        <input type="text" id="keyword" class="search_key" />
        <input type="submit" id="s_submit" class="search_sub" value="" />
      </form>
    </div>
    <div id="alltype">
      <!--这里调用分部视图显示图书分类-->
      <%--@{--%>
      <%--//呈现 由action返回的分部视图--%>
      <%--Html.RenderAction("showcategory", "commonview");--%>
      <%--}--%>

      <!--调用结束-->
      <h1 class="all_type black"><a href="#">查看所有分类>></a></h1>
      <div id="subnav">
        <ul class="black">
          <c:forEach items="${categories}" var="c">
          <li><a href="books/index/${c.id}">${c.name}</a></li>
          </c:forEach>
        </ul>
      </div>

    </div>
    <!--link start-->
    <div id="choice_pub">
      <select name="publishs" id="publishs" class="n_select">
        <option>>>根据出版社选择图书</option>
        <c:forEach items="${publishers}" var="p" >
          <option value="${p.id}">${p.name}</option>
        </c:forEach>

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

  <!--middle content-->
  <div id="content">
    <div id="magic"><img src="${pageContext.request.contextPath }/img/a_b_02.jpg" alt="幻灯图片" width="480" height="200" /></div>
    <div id="a_b_02">
      <a href="#">电子词典专柜上线</a>
      <a href="#">Lucy陪你说真人口语英语对译软件</a>
      <a href="#" class="red">哇~这东西真便宜，大家快来抢啊！</a>
    </div>
    <!--comment books start-->
    <div id="comment_book">
      <ul>
        <c:forEach items="${homeBooks}" var="homeb">
          <li>
            <a href="books/detail/${homeb.id}">
              <img src="${pageContext.request.contextPath }/img/BookCovers/${homeb.ISBN}.jpg" alt="${homeb.title}" />
            </a>
            <a href="books/detail/${homeb.id}">
              <c:choose>
                <c:when test="${fn:length(homeb.title)>11 }">
                  ${ fn:substring(homeb.title ,0,11)}
                </c:when>
                <c:otherwise>
                  ${homeb.title}
                </c:otherwise>
              </c:choose>
            </a>
          </li>
        </c:forEach>
      </ul>
    </div>
    <!--comment books end-->
  </div>

  <!--sidebar content-->
  <div id="sidebar">
    <ul id="notice">
      <li><a href="#">国庆期间货物延期配送公告</a></li>
      <li><a href="#">英语高级口语资格考试</a></li>
      <li><a href="#">英语高级口语资格考试</a></li>
      <li><a href="#">英语高级口语资格考试</a></li>
    </ul>
    <div id="order_find">
      <form action="" method="post" target="_blank">
        <label>订单号：</label><input type="text" id="keyword" class="order_key" />
        <input type="submit" id="s_submit" class="order_sub" value="查询状态" />
      </form>
    </div>
    <div class="service">
      <p><a href="#"><img src="${pageContext.request.contextPath }/img/QQ_01.gif" /></a>
        <a href="#"><img src="${pageContext.request.contextPath }/img/QQ_02.gif" /></a>
        <a href="#"><img src="${pageContext.request.contextPath }/img/QQ_02.gif" /></a></p>
      <p><a href="#"><img src="${pageContext.request.contextPath }/img/taobao_01.gif" /></a>
        <a href="#"><img src="${pageContext.request.contextPath }/img/taobao_02.gif" /></a></p>
    </div>
    <!--hot books start-->
    <div class="sidedt hots">
      <h1>新书排行</h1>
      <ul>
        <c:forEach items="${newBooks}" var="nb">
        <li>
          <a href="books/detail/${nb.id}">
            <c:choose>
              <c:when test="${fn:length(nb.title)>15 }">
                ${ fn:substring(nb.title ,0,15)}...
              </c:when>
              <c:otherwise>
                ${nb.title}
              </c:otherwise>
            </c:choose>
          </a>
        </li>
        </c:forEach>
      </ul>
    </div>
    <!--hot books end-->
    <!--laster books start-->
    <div class="sidedt laster">
      <h1>热销排行</h1>
      <ul>
        <c:forEach items="${hotBooks}" var="hb">
          <li>
            <a href="books/detail/${hb.id}">
              <c:choose>
                <c:when test="${fn:length(hb.title)>15 }">
                  ${ fn:substring(hb.title ,0,15)}...
                </c:when>
                <c:otherwise>
                  ${hb.title}
                </c:otherwise>
              </c:choose>
            </a>
          </li>
        </c:forEach>
      </ul>
    </div>
    <!--laster books end-->
  </div>
</div>

<!-- 导入尾部文件 -->
<%@ include file="layout/foot.html"%>
