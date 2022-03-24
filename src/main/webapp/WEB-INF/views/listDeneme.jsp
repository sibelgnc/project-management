<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h2 {
	position: absolute;
	margin-top: 20px;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<%@include file="menuHeader.jsp"%>

	<h2>Project Notes List</h2>


	<form:form modelAttribute="notelist" id="formNote"
		action="${pageContext.request.contextPath}/projectManagement/listDeneme">


		<div class="col-md-12" style="margin-top: 80px">



			<div class="table-responsive">
				<table class="table table-bordered table-striped">
					<tr class="header">
						<th width="20%">Date</th>
						<th width="75%">Note Content</th>
						<th width="3%">Delete</th>

					</tr>
					<c:forEach items="${noteForm.notes}" var="note">
						<tr>

							<td>${note.noteDate}</td>

							<td style="word-break: break-all;">${note.content}</td>

							<td><a
								href="${pageContext.request.contextPath}/projectManagement/delete-${note.id}-note"
								title="Delete" class="btn btn-danger btn-xs" role="button"><span
									class="glyphicon glyphicon-trash"></span></a></td>


						</tr>
					</c:forEach>


				</table>
			</div>
		</div>
		<input type="submit" value="Save" />
	</form:form>

	<script type="text/javascript">
 
 
 function save()
 {
	 var form=$("#", "formNote");
	     if(form.valid())
		 {
		   req=$.ajax({
			  url:form.attr('action'),
			  data:form.serialize(),
			  type:post
		   });
		 }
	 
 }
   /* $(document).ready(function()
    {
    	var content=document.getElementById("content");
    	var inputDate=document.getElementById("dateInput");
    	  var i=1;
       $("#add_row").click(function(){
        $('#addr'+i).html("<td></td><td></td>");

        $('#myTable').append('<tr id="addr'+(i+1)+'"></tr>');
        i++; 
    });
       
      
  });*/
    
    /*
    function deleteRow(r) 
    {	
        var index = r.parentNode.parentNode.rowIndex;
        document.getElementById("myTable").deleteRow(index);
    }
    function saveAllNotes()
    {
    	var value = $("#noteform").serialize();
    	  $.ajax({
    	    type: "post",
    	    url: "${pageContext.request.contextPath}/projectManagement/noteList",
    	    data: value
    	});
    }*/
  
    </script>
</body>
</html>
