<%@page import="com.cybersoft.crm.common.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/plugins/images/favicon.png">
    <title>Project-table</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href=".assets/css/custom.css">
</head>

<body>
	<script>
		function show() {		
			var row_id = event.target.parentNode.parentNode.id;
			var data = document.getElementById(row_id).querySelectorAll(".row");
			var project_id = data[0].innerHTML;
			var project_name = data[1].innerHTML;
			var description = data[2].innerHTML;
			var start_date = data[3].innerHTML;
			var end_date = data[4].innerHTML;	
			document.form.project_id.value = project_id;
			document.form.project_name.value = project_name;
			document.form.description.value = description;
			document.form.start_date.value = start_date;
			document.form.end_date.value = end_date;
		}
	</script>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
                <div class="navbar-header"> 
                    <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="top-left-part">
                        <a class="logo" href="<%=request.getContextPath() + Common.HOMEPAGE %>">
                            <b>
                                <img src="assets/plugins/images/pixeladmin-logo.png" alt="home" />
                            </b>
                            <span class="hidden-xs">
                                <img src="assets/plugins/images/pixeladmin-text.png" alt="home" />
                            </span>
                        </a>
                    </div>
                    <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                        <li>
                            <form role="search" class="app-search hidden-xs">
                                <input type="text" placeholder="Search..." class="form-control"> 
                                <a href="">
                                    <i class="fa fa-search"></i>
                                </a>
                            </form>
                        </li>
                    </ul>
                    <ul class="nav navbar-top-links navbar-right pull-right">
                        <li>
                            <div class="dropdown">
                                <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#"> 
                                    <img src="assets/plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle" />
                                    <b class="hidden-xs">Cybersoft</b> 
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="divider"></li>
                                    <li><a href="<%=request.getContextPath() + Common.LOGOUT%>">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-header -->
                <!-- /.navbar-top-links -->
                <!-- /.navbar-static-side -->
            </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="<%=request.getContextPath() + Common.HOMEPAGE %>" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() + Common.USER_LIST %>" class="waves-effect"><i class="fa fa-user fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Member</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() + Common.PROJECT %>" class="waves-effect"><i class="fa fa-table fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Project</span></a>
                    </li>
                    <li><a href="<%=request.getContextPath() + Common.TASK_LIST %>" class="waves-effect"><i class="fa fa-table fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Task</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title" >Project List</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="<%=request.getContextPath() + Common.PROJECT_CREATE %>" class="btn btn-sm btn-success">Add</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th style="display:none;">Id</th>
                                            <th>Name Project</th>
                                            <th>Description</th>
                                            <th>Start Date</th>
                                            <th>End Date</th>
                                            <th>Action</th>
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="count" value="0" scope="page" />
                                    <c:forEach items="${list}" var="item"> 
                                    	<c:set var="count" value="${count + 1}" scope="page"/>                                    
                                        <tr id="${item.id}">
                                        	<td><c:out value="${count}"></c:out></td>              
                                            <td class="row" style="display:none;">${item.id}</td>                        
											<td class="row">${item.project_name}</td>
											<td class="row">${item.description}</td>
											<td class="row">${item.start_date}</td>
											<td class="row">${item.end_date}</td>											
                                            <td>
                                            	<form action="<%=request.getContextPath() + Common.PROJECT_DETAIL%>" method="get" class="btn">
													<input type="hidden" value="${item.id}" name="project_id"/>
													<button type="submit" class="btn btn-sm btn-info">Choose</button>
												</form>
												<input type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#modal-edit" value="Update" onclick="show()" />
                                                <form action="<%=request.getContextPath() + Common.PROJECT_DELETE %>" method="get" class="btn">
													<input type="hidden" value="${item.id}" name="project_id"/>
													<button type="submit" class="btn btn-sm btn-danger">Delete</button>
												</form>                                                
                                            </td>
                                       	 </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2022 &copy; myclass.com </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- Begin Modal-->
    <div id="modal-edit" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true" data-backdrop="false">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<div class="px-3">
						<form action="<%=request.getContextPath() + Common.PROJECT_UPDATE %>" method="post" name="form">
							<div class="form-group">
								<input class="form-control" type="hidden" name="project_id">
							</div>
							<div class="form-group">
								<label for="username">Project name:</label> <input class="form-control"
									type="text" name="project_name"/>
							</div>
							<div class="form-group">
								<label for="description">Description:</label> <input
									class="form-control" type="text" name="description"/>
							</div>
							<div class="form-group" >
								<label for="start_date">Start date:</label> <input type="date"
									class="form-control" name="start_date" 
									readonly="readonly" />
							</div>							
							<div class="form-group">
								<label for="end_date">End date:</label> <input class="form-control" type="date"
									id="text" name="end_date">
							</div>
							<div class="form-group text-center">
								<button class="btn btn-primary" type="submit">Continue</button>
								<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
							</div>
						</form>
					</div>
				</div>
				<!-- // END .modal-body -->
			</div>
			<!-- // END .modal-content -->
		</div>
		<!-- // END .modal-dialog -->
	</div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="assets/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="assets/js/jquery.slimscroll.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <!--Wave Effects -->
    <script src="assets/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="assets/js/custom.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</body>

</html>