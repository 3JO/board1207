<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<%@include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">

		<h1>RESULT</h1>

		<h3>처리되었습니다</h3>

		<script>
			alert("SUCCESS");
			self.location = "/board/list"
		</script>


		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Dashboard</li>
		</ol>


	</section>

	<!-- Main content -->

	<section class="content">

		<a href="/board/update?bno=1"> <input type="submit" value="수정"></a>
		<a href="/board/remove?bno=1"><input type="submit" value="삭제"></a>

	</section>



</div>
<!-- /.content-wrapper -->
<%@include file="../include/footer.jsp"%>
<script>
	
</script>
</body>
</html>


