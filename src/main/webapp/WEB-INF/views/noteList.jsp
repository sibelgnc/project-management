<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

h2 {
    position: absolute;
    margin-top:20px;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>
</head>
<body>
<%@include file="menuHeader.jsp"%>

<h2>Project Notes List</h2>
<form:form modelAttribute="additionNote" id="noteform" action="${pageContext.request.contextPath}/projectManagement/noteAdd">


<div class="col-md-12" style="margin-top:80px" >


<form:input type="hidden" path="projectNotes.projectName" value="${additionNote.projectNotes.projectName }"></form:input>
<div class="table-responsive"><label><font size="2px">Project Name:${additionNote.projectNotes.projectName }</font></label></div>
<div class="table-responsive">
<table id="myTable" class="table table-bordered table-striped">
                    <tr class="header">
                                <th>Date</th>
								<th>Note Content</th>
								<th>Add</th>
                    </tr>
                    <tr>
                       
                    <td>
                    
                   
                    <form:input  type="date"  class="form-control input-md"  path="noteDate" value="<fmt:formatDate type='date'  value=''  pattern='dd/MM/yyyy'/>" /> </td>
                    <td><form:textarea class='form-control' rows='1' id='comment' path="content"></form:textarea></td>
                    <td><button  class='btn btn-info btn-lg' type="submit"><span class='glyphicon glyphicon-plus'></span></button></td>
                    </tr>
                    </table>
                    </div>
                    <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                    <tr class="header">
                                <th>Date</th>
								<th>Note Content</th>
								<th>Delete</th>
								
                    </tr>
                     <c:forEach items="${notes}" var="note">
							<tr>
							    
								<td>${note.noteDate}</td>
								<td>${note.content}</td>
							
							  <td><a href="${pageContext.request.contextPath}/projectManagement/delete-${note.id}-note" title="Delete"  class="btn btn-danger btn-xs" role="button"><span class="glyphicon glyphicon-trash"></span></a></td>
									
									
							</tr>
						</c:forEach>
					

					</table>
</div>
</div>
</form:form>

<script type="text/javascript">
  /*
    $(document).ready(function(){
    	  var i=1;
       $("#add_row").click(function(){
        $('#addr'+i).html("<td><input name='name"+i+"' type='date' placeholder='Name' class='form-control input-md'  /> </td><td><textarea class='form-control' rows='5' id='comment'></textarea></td><td class='deleterow'><button  class='btn btn-danger btn-sm' onclick='deleteRow(this)'><span class='glyphicon glyphicon-trash'></span></button></td>");

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