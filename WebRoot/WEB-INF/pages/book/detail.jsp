<%--
  Created by IntelliJ IDEA.
  User: GongTao
  Date: 2017/2/11/011
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
  <meta name="Robots" content="index,follow"/>
  <title>"第三波书店"-网上书店</title>
  <link href="${pageContext.request.contextPath}/css/channel.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/css/answer.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/Scripts/jquery-1.8.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/easyui1.5/jquery.easyui.min.js"></script>
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/icon.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/easyui1.5/themes/bootstrap/easyui.css" rel="stylesheet" />
  <script>
    function buy(bookid) {
      var url = "/car/buy/"+bookid;
      $.getJSON(url,null,function(json){
        if(json.success==0){
          alert("购买成功！");
//          location.href="/";
        }else{
          alert("购买失败！");
        }
      });


    }

    function collection(bookid, bookname) {

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
  <c:set var="totolUPrice" value="0"></c:set>
  <c:set var="buyCount" value="0"></c:set>
  <c:forEach items="${items}" var="item">
    <c:set var="totolUPrice" value="${totolUPrice+item.unitPrice }"></c:set>
    <c:set var="buyCount" value="${buyCount+item.qty }"></c:set>
  </c:forEach>
  <div class="status">您好，欢迎来到第三波书店^_^
    <c:choose>
      <c:when test="${sessionScope.name==null}">
         <span>
           <a href="user/login">【登录】</a>
           <a href="user/login">【免费注册】</a>
           <a href="/car">【购物车】</a>
         </span>
      </c:when>
      <c:otherwise>
      <span>
         <a href="user/login">【会员中心】</a>
         <a href="/car">【购物车】</a>
         <a href="user/login">【退出】</a>
      </span>
      </c:otherwise>
    </c:choose>
  </div>
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
  <div id="intro">
    <div id="basket"><a href="car">
      <c:choose>
        <c:when test="${items==null}">
          目前您的购物篮是空的
        </c:when>
        <c:otherwise>
          共购买${buyCount}本书，应付${totolUPrice}元
        </c:otherwise>
      </c:choose></a>
    </div>

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

  <div class="book_view">
    <h1 class="b_title">${book.title}</h1>
    <div class="b_exa">
      <span class="book_group">${book.title}</span>
      <span class="book_status">正在阅读（150 人），已经阅读（4521 人） <span><a href="#">放入书架</a></span> <a href="#">什么是书架？</a></span>
    </div>

    <!--book basic start-->
    <dl class="put_book">
      <dt>
        <img src="${pageContext.request.contextPath}/img/BookCovers/${book.ISBN}.jpg"
        alt="${book.ISBN}" />
      <div class="chakan">
        <img src="${pageContext.request.contextPath}/img/zoom.gif" />
        <a class="gray878787a"
           href="#" name="bigpicture">点击查看大图</a></div>
      </dt>
      <dd>
        <div id="book_editor">作　　者： ${book.author}  著
          <br />出 版 社： ${book.publisher.name}</div>
        <ul id="book_attribute">
          <li>出版时间： <fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd"/>  </li>
          <li>字　　数： </li>
          <li>版　　次： 1</li>

          <li>页　　数： 540</li>
          <li>印刷时间： 2009-5-1</li>
          <li>开　　本： 16开</li>
          <li>印　　次： 1</li>
          <li>纸　　张： 胶版纸</li>
          <li>I S B N    ： ${book.ISBN}</li>

          <li>包　　装： 平装</li>
        </ul>

        <div id="book_categroy">
          所属分类：

          <a
                  href="/books/index/${book.categoryId}"
          target="_blank" class="blue12a">
          ${book.category.name}</a>
        </div>

        <div id="book_price">
                    <span class="gray87">定价：
                        <span class="del"> ${book.marketPrice}</span></span>
                    <span class="red">当当价：${book.unitPrice}</span>
          折扣：<span class="redc30"> ${book.unitPrice/book.marketPrice*100} 折</span>
          节省：${book.marketPrice-book.unitPrice})
        </div>

        <div id="book_point">
          <span >送积分：<span id="pointsTag" >354</span></span>　<a target="_blank" href="#2">积分说明</a> <br />
          <a href="javascript:void(0)" onclick="buy(${book.id})">
            <img src="${pageContext.request.contextPath}/img/btn_goumai.gif"
                 onmouseover="this.src='/img/btn_goumai_click.gif'"
                 onmouseout="this.src='/img/btn_goumai.gif'" /></a>
          <a href="javascript:void(0)" onclick="collection(${book.id},'${book.title}')">
            <img src="${pageContext.request.contextPath}/img/btn_zancun.gif"
                 onmouseover="this.src='/img/btn_zancun_click.gif'"
                 onmouseout="this.src='/img/btn_zancun.gif'" /></a>
        </div>

        <div id="book_count">
          顾客评分：<span id="book_id_15">5</span>
          共有商品评论0条  <a href="#">查看评论摘要</a>
        </div>


      </dd>
    </dl>
    <!--book basic end-->
    <!--book intro start-->
    <dl class="book_intro">
      <dt>编辑推荐</dt>
      <dd>中国健康类图书第一品牌“国医健康绝学系列”2009年重磅新品
        《求医不如求己家庭医学全书》是一本保佑全家老小平平安安的健康红宝书。里面汇集了将近200种家庭常见疾病的自助调治方案，它们特别简单、特别安全、特别适合家庭使用。严格按照书中的方法去做，每个人身体的绝大多数问题都能得到解决。
        　　中里巴人先生健康养生绝学使用说明书，一看就懂，最安全、最有效、最省钱。
        本书几大特色：</dd>
    </dl>

    <dl class="book_intro">
      <dt>内容简介</dt>
      <dd>
        ${book.contentDescription}
      </dd>

    </dl>

    <dl class="book_intro">
      <dt>目录</dt>
      <dd>
        @Html.Raw(Model.TOC)
      </dd>
    </dl>


    <!--book intro end-->

    <!--recommed start-->
    <div class="comm_answer">
      <!--review head start-->
      <div id="div_product_reviews">
        <div class="total_comm">
          <div class="comm_title">
            <h2>商品评论 共<em>814</em>条
              <span class="look_comm"> (<a href="#" name='reviewList'  target='_blank'>查看所有评论</a>)</span></h2>
          </div>

          <div class="total_body">
            <div class="people_average">
              <div class="average_left"><p>购买过的顾客平均评分</p>

                <span class="a_red28b pd">@number</span>
                @if(flag==true){
                <span class="red_bold">星半</span>
                }
                else{
                <span class="red_bold">星</span>
                }
                @for(int i=0;i<number;i++){
                <img src='/img/star_red.gif' />
                }
                @if(flag==true){
                <img src='/img/star_redgray_big.gif' />
                }
              </div>
              <span class="span_jt" id="div_window_star"><input class="button_down1" value=""  type="button" /></span>
            </div>

            <div id="div_product_summary" >

              <div class="people_heart">心情指数:<em>249</em>人 开心
                                <span id="div_emotion_hover"  >
                                    <input class="button_down1"   type="button" />
                                </span>
              </div>
              <div id="Div1" class="people_read" >阅读场所:<em>180</em>人 床上
                                <span id="div_location_hover"  >
                                    <input class="button_down1"   type="button" />
                                </span>
              </div>
            </div>

            <div class="write_comm">
              <a id="reviewTipa"  href="#"><img src="${pageContext.request.contextPath}/img/button_write_comm.gif" border="0" title="写评论" /></a>
            </div>


          </div>
        </div>
      </div>
      <!--review head end-->

      <!--the one reviews start-->
      <div class="comm_list">
        <h3>
          <img src="${pageContext.request.contextPath}/img/label_1.gif"  title="精彩评论" /><a href="#" target="_blank" name="reviewDetail">非常不错的一本书</a>
          <span>发表于 2009-04-29 22:46</span>
        </h3>

        哦耶，终于拿到书了。&nbsp;<br/>实物比照片显示的要漂亮，颜色是看上去很舒服的红色。&nbsp;<br/>书很厚，是塑封的，里面有两张挂图，一张标准穴位图，一张足部反射区图，还有一张配套的光盘，用DVD机试了一下，是中里老师讲的。嗯，
      </div>
      <!--the one reviews end-->

    </div>
    <!--recommed end-->


  </div>
  <!--right content end-->
</div>



<div id="footer" style="height: 100px;">
  <!--contac us-->
  <div class="telephone">
    <strong>热线</strong> 021-61508168　<strong>传真</strong> 021-61508168-8020　 <br/>
    <strong>Q Q</strong>375013071  13483528    562655482  1143735195（技术)<br/>
    <strong>MSN</strong> hjservice@hotmail.com   <strong>信箱</strong> shop@hjenglish.com<br/>
    <strong>帮助</strong> <a href="/help/help.aspx" target="_blank">银行汇款帐户</a> <a href="/help/help.aspx#help_post"
                                                                                target="_blank">邮局汇款地址</a> <a
          href="/help/help.aspx#help_ship" target="_blank">送货方式及费用</a> <a
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


</body>
</html>
