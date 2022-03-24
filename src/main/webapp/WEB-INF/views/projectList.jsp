<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

#myInput {


  /*background-position: 10px 10px;
  background-repeat: no-repeat;*/
  width: 100%;
  left:20%;
  right:20%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
/*
#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}*/
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
<h2>Your Project List</h2>

<div class="col-md-12" style="margin-top:80px" >


<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search according to project name..." title="Type in a name" >


<div class="table-responsive">
<table id="myTable" class="table table-bordered table-striped">
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
								<th>Notes</th>
								<th>Tasks</th>
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
										<td><p data-placement="top" data-toggle="tooltip"
										title="Notes">
										<a href="${pageContext.request.contextPath}/projectManagement/notes-${project.id}-project" title="Notes"  class="btn btn-success btn-xs" role="button"><span class="glyphicon glyphicon-comment"></span></a>
									</p></td>
									<td><p data-placement="top" data-toggle="tooltip"
										title="Tasks">
										<a href="${pageContext.request.contextPath}/projectManagement/tasks-${project.id}-project" title="Tasks"  class="btn btn-warning btn-xs" role="button"><span class="glyphicon glyphicon-tasks"></span></a>
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
<script>
function myFunction() {
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
