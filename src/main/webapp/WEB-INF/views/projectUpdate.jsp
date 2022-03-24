<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




</head>
<%@include file="menuHeader.jsp" %>
<body>
<div class="container">
	<div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form:form class="form-horizontal" action="${pageContext.request.contextPath}/projectManagement/update" method="post" role="form"  modelAttribute="updatedProject">
          <fieldset>
            <legend class="text-center">Project Information</legend>
    
            <!-- Project Name input-->
            <form:input id="projectId" name="projectId" type="hidden" path="id" />
            <div class="form-group">
              <label class="col-md-3 control-label" for="projectName">Project Name:</label>
              <div class="col-md-9">
              	
                <form:input id="projectName" name="projectName" type="text" placeholder="Project Name" class="form-control" path="projectName" /> 
              </div>
            </div>
    
            <!-- Project Manager input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="projectManager">Project Manager</label>
              <div class="col-md-9">
                <form:input id="projectManager" name="projectManager" type="text" placeholder="Project Manager" class="form-control" path="managerName"/>
              </div>
            </div>
    
          
          <!-- IssuedOn Date input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="issuedOn">IssuedOn Date</label>
              <div class="col-md-9">
                <form:input id="issuedOn" name="issuedOn" type="date" placeholder="IssuedOn Date" class="form-control" path="issuedOn"  />
              </div>
            </div>
          
          <!-- Starting Date input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="startingDate">Starting Date</label>
              <div class="col-md-9">
                <form:input id="startingDate" name="startingDate" type="date" placeholder="Starting Date" class="form-control" path="startingDate"/>
              </div>
            </div>
          
              <!-- Finished Date input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="finishedDate">Finished Date</label>
              <div class="col-md-9">
                <form:input id="finishedDate" name="finishedDate" type="date" placeholder="Finished Date" class="form-control" path="finishedDate"/>
              </div>
            </div>
      
      
              <!-- Project purpose body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="projectPurpose">Project Purpose</label>
              <div class="col-md-9">
                <form:textarea class="form-control" id="projectPurpose" name="projectPurpose" placeholder="Project Purpose" rows="5" path="purpose"/>
              </div>
            </div>
      
            <!-- Connection Information body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="connectInfo">Project Connection Information</label>
              <div class="col-md-9">
                <form:textarea class="form-control" id="connectInfo" name="connectInfo" placeholder="Project Connection Information" rows="5" path="connectionInfo"/>
              </div>
            </div>
    
            <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
             
						
                <button type="submit" class="btn btn-primary btn-lg">Update Project</button>
              </div>
            </div>
          </fieldset>
          </form:form>
        </div>
      </div>
	</div>
</div>
</body>
</html>