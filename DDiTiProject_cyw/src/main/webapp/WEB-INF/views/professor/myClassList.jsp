<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="d-flex align-items-center">
		<div class="me-auto p-10">
			<h3 class="page-title">내 강의 목록</h3>
		</div>
</div>

<div class="box-body">
	<div class="table-responsive">
		<div id="example_wrapper"
			class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
			<form id="searchForm" method="post">
			<input type="hidden" name="page" id="page">
			
			<div id="example" class="r-side d-lg-inline-flex" style="margin-left: auto;">
						<select name="status" class="form-select " data-placeholder="Select status">
								<option selected="selected" disabled="disabled">=====선택=====</option>
								<option value="semester" <c:if test="${searchType eq 'semester' }">selected</c:if>>년도/학기</option>
								<option value="classReqCode" <c:if test="${searchType eq 'classReqCode' }">selected</c:if>>이수구분</option>
						</select>
					<input type="text" placeholder="입력하세요" name="searchWord" value="${searchWord }" class="form-control" style="width: 30%; display: inline-block;">	
				<button type="submit" class="waves-effect waves-light btn btn-dark mb-5">조회</button>		
			</div>
		</form>	
			<div class="col-xl-12">
				<div class="box box-solid box-inverse box-info">
			<div class="row">
				<div class="box-body">
							<div class="table-responsive">
								<table class="table">
									<thead class="bg-primary">
										<tr>
											<th>년도/학기</th>
											<th>과목명</th>
											<th>강의실</th>
											<th>강의시간</th>
											<th>이수구분</th>
											<th>수강인원</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="index" value="${pagingVO.startRow + 1}" />
										<c:set var="index" value="${index - 1}" />
									<c:forEach items="${myClassList}" var="mylist">
										<tr>
											<td>${mylist.semester}</td>
											<td><a href="/DYUniv/managementClassRoom/${mylist.classNo}">${mylist.className}</a></td>
											<td>${mylist.roomNo}</td>
											<td>${mylist.classTotalTime}</td>
											<td>
												<c:if test="${mylist.classReqCode eq 'CLR001'}">전공필수</c:if>
												<c:if test="${mylist.classReqCode eq 'CLR002'}">전공선택</c:if>
												<c:if test="${mylist.classReqCode eq 'CLR003'}">교양필수</c:if>
												<c:if test="${mylist.classReqCode eq 'CLR004'}">교양선택</c:if>
											</td>
											<td>${mylist.classMaxMem}</td> 
										</tr>
										<c:set var="index" value="${index + 1}" />
									</c:forEach>
									</tbody>
								</table>
								</div>	
								<div class="col-sm-12 col-md-6" style="float: right; margin-right: 80px">
									<div class="dataTables_paginate paging_simple_numbers"
										id="example1_paginate">
										${pagingVO.pagingHTML }
									</div>
							</div>
						</div>
				
						</div>
					</div>
				</div>
			</div>

	</div>
</div>
<script type="text/javascript">
$(function(){

		/* 페이징 */
		var pagingArea = $("#example1_paginate");
		var searchForm = $("#searchForm");
		
		pagingArea.on("click", "a", function(event){
			event.preventDefault();	// a 태그의 기본 이벤트 동작 방지
			var pageNo = $(this).data("page");
			searchForm.find("#page").val(pageNo);
			
			searchForm.submit();
		});
	
	
});
</script>