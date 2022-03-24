<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menuHeader.jsp"%>
<div class="col-md-12" style="margin-top:80px" >
<form:form modelAttribute="noteform" id="noteform" action="#">

<input name='name"+i+"' type='date' placeholder='Name' class='form-control input-md'  /> 
<textarea class='form-control' rows='5' id='comment'></textarea><button  class='btn btn-danger btn-sm' onclick='deleteRow(this)'><span class='glyphicon glyphicon-trash'></span></button>
<a id='add_row' class="pull-right btn btn-default">Save All Notes</a>

<div class="table-responsive">
<table id="myTable" class="table table-bordered table-striped">
  <tr class="header">
                                <th>Date</th>
								<th>Note Content</th>
								<th>Delete</th>
								
                    </tr>
                     <c:forEach items="${notes}" var="note">
							<tr>
							    
								<td>${note.noteDate}</td>
								<td>${note.content}</td>
							
							  <td><button  class='btn btn-danger btn-sm' onclick='deleteRow(this)'><span class="glyphicon glyphicon-trash">
							  </span></button></td>
									
									
							</tr>
						</c:forEach>
						<tr id='addr1'></tr>

					</table>
</div>
</form:form>
</div>
<script type="text/javascript">
  
    $(document).ready(function(){
    	  var i=1;
       $("#add_row").click(function(){
        $('#addr'+i).html("<td><input name='name"+i+"' type='date' placeholder='Name' class='form-control input-md'  /> </td><td><textarea class='form-control' rows='5' id='comment'></textarea></td><td class='deleterow'><button  class='btn btn-danger btn-sm' onclick='deleteRow(this)'><span class='glyphicon glyphicon-trash'></span></button></td>");

        $('#myTable').append('<tr id="addr'+(i+1)+'"></tr>');
        i++; 
    });
       /*$("#delete_row").click(function(){
      	 if(i>1){
  		 $("#addr"+(i-1)).html('');
  		 i--;
  		 }
  	 });*/
      
  });
    
    
    function deleteRow(r) 
    {	
        var index = r.parentNode.parentNode.rowIndex;
        document.getElementById("myTable").deleteRow(index);
    }
    
    </script>
</body>
</html>