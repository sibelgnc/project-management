<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h2 {
    position: absolute;
   
    left: 50%;
    transform: translate(-50%, -50%);
}
#myInput {
  backgorund-image:url('/img/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  position:absolute;
  left:20%;
  width:50%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
</style>
</head>
<body>

	<%@include file="menuHeader.jsp"%>
	<h2>Your Projects</h2>
	<br><br><br>
	
	
	<div class="container">
		<div class="col-md-12" >

	<input type="text" id="myInput" onkeyup="myFunction()" title="Type in a name">
	
	<br><br><br>
	</div>
		<div class="row">

			<div class="col-md-12" >
				
				<div class="table-responsive">
					<table id="mytable" class="table table-bordred table-striped">
						
							<tr class="header">
							
								<th>Project Name</th>
								<th>Manager Name</th>
								<th>Issuedon Date</th>
								<th>Finished Date</th>
								<th>Starting Date</th>
								<th>ConnectionInfo</th>
								<th>Purpose</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>

						

						<c:forEach items="${projects}" var="project">
							<tr>
							    
								<td>${project.projectName}</td>
								<td>${project.managerName}</td>
								<td>${project.issuedOn}</td>
								<td>${project.finishedDate}</td>
								<td>${project.startingDate}</td>
								<td>${project.connectionInfo}</td>
								<td>${project.purpose}</td>
								<td><p data-placement="top" data-toggle="tooltip"
										title="Edit">
										<a href="${pageContext.request.contextPath}/projectManagement/edit-${project.id}-project" title="Edit"  class="btn btn-info btn-xs" role="button"><span class="glyphicon glyphicon-pencil"></span></a>
										
											
										
									</p></td>
								<td><p data-placement="top" data-toggle="tooltip"
										title="Delete">
										<button class="btn btn-danger btn-xs" data-title="Delete"
											data-toggle="modal" data-target="#delete_${project.id}">
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</p></td>
							</tr>



							<div class="modal fade" id="delete_${project.id}" tabindex="-1" role="dialog"
								aria-labelledby="edit" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
											</button>
											<h4 class="modal-title custom_align" id="Heading">Delete
												this entry</h4>
										</div>
										<div class="modal-body">

											<div class="alert alert-danger">
												<span class="glyphicon glyphicon-warning-sign"></span> 
												(Project Name=${project.projectName})<br>
												Are
												you sure you want to delete this Record?
											</div>

										</div>
										<div class="modal-footer ">
										
										
										<a href="${pageContext.request.contextPath}/projectManagement/delete-${project.id}-project" title="Delete"  class="btn btn-danger" role="button"><i class="fa fa-trash-o"></i>Delete</a>
									
											
											<button type="button" class="btn btn-default"
												data-dismiss="modal">
												<span class="glyphicon glyphicon-remove"></span> No
											</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>





						</c:forEach>


					</table>
				</div>
			</div>
		</div>
	</div>

	
<script>
function myFunction() 
{
	
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

</script>



</body>
</html>