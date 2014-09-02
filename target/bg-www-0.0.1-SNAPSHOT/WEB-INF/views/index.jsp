<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"  type="text/css" />
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"  type="text/css" />
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>바스켓볼 게스트</title>
</head>
<body>
<div class="container">
  <h3>
    회원가입/로그인
  </h3>
  <hr>
  <form:form name="memberForm" id="form" method="post" modelAttribute="member">
    <div class="form-group">
      <section>
	      <form:input path="email" type="text" class="form-control" placeholder="아이디" id="email"/>
	      <form:input path="pwd" type="text" class="form-control" placeholder="비밀번호" id="pwd"/>
      </section>
      <section>
	      <button type="submit" class="btn btn-primary btn-lg" id="signin" onclick="memberForm.action='/bg-www/signin';return true;">
	       	Login
	      </button>
	      <button type="submit" class="btn btn-primary btn-lg" id="signup" onclick="memberForm.action='/bg-www/signup';return true;">
	       	SignUp
	      </button>
      </section>
    </div>
  </form:form>
</div>
<script type="text/javascript">
</script>
</body>
</html>