<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/camping/common.jsp"%>
<%@ include file="/WEB-INF/views/user/menuBar.jsp"%>
<div class="container">       
<c:forEach items="${clist}" var="product" varStatus="i">    
<c:if test="${product.camp_category == 1 }">   <!-- 1 : 카라반 -->
      <div class="row" style="width:350px; margin:10px; float:left;">
        <div class="col">
          <div class="card" style="border:1px solid grey; width:300px; height:410px;">
          <div style="width:300px;height:300px;">
          		<c:forEach items="${product.picture }" var="pic" begin="0" end="0"> 
          			<a href="/detail/${product.camp_id}"><img class="card-img-top img" src="/image/${pic.pic_name}" alt="Card image" style="width:298px; height:298px;"></a>
          		 </c:forEach>
           </div>
             <div class="card-body">
		          <h4>${product.camp_title}</h4>
		          <p class="card-text">${product.address}</p>
	        </div>
          </div>
        </div>
      </div>
</c:if>
</c:forEach>
</div>

<div style="clear:both;"></div>
<%@ include file="../includes/footer.jsp"%>