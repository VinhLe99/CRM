/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2022-07-24 14:17:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cybersoft.crm.common.Common;

public final class user_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1653719156766L));
    _jspx_dependants.put("jar:file:/D:/JavaWeb/DuAnCRM/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/CRM/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.cybersoft.crm.common.Common");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/plugins/images/favicon.png\">\n");
      out.write("    <title>User-Add</title>\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"assets/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Menu CSS -->\n");
      out.write("    <link href=\"assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- animation CSS -->\n");
      out.write("    <link href=\"assets/css/animate.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- color CSS -->\n");
      out.write("    <link href=\"assets/css/colors/blue-dark.css\" id=\"theme\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- Preloader -->\n");
      out.write("    <div class=\"preloader\">\n");
      out.write("        <div class=\"cssload-speeding-wheel\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top m-b-0\">\n");
      out.write("                <div class=\"navbar-header\"> \n");
      out.write("                    <a class=\"navbar-toggle hidden-sm hidden-md hidden-lg \" href=\"javascript:void(0)\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"top-left-part\">\n");
      out.write("                        <a class=\"logo\" href=\"dashboard.jsp\">\n");
      out.write("                            <b>\n");
      out.write("                                <img src=\"assets/plugins/images/pixeladmin-logo.png\" alt=\"home\" />\n");
      out.write("                            </b>\n");
      out.write("                            <span class=\"hidden-xs\">\n");
      out.write("                                <img src=\"assets/plugins/images/pixeladmin-text.png\" alt=\"home\" />\n");
      out.write("                            </span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"nav navbar-top-links navbar-left m-l-20 hidden-xs\">\n");
      out.write("                        <li>\n");
      out.write("                            <form role=\"search\" class=\"app-search hidden-xs\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Search...\" class=\"form-control\"> \n");
      out.write("                                <a href=\"\">\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-top-links navbar-right pull-right\">\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"dropdown\">\n");
      out.write("                                <a class=\"profile-pic dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"> \n");
      out.write("                                    <img src=\"assets/plugins/images/users/varun.jpg\" alt=\"user-img\" width=\"36\" class=\"img-circle\" />\n");
      out.write("                                    <b class=\"hidden-xs\">Cybersoft</b> \n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li><a href=\"");
      out.print(request.getContextPath() + Common.LOGOUT );
      out.write("\">Logout</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-header -->\n");
      out.write("                <!-- /.navbar-top-links -->\n");
      out.write("                <!-- /.navbar-static-side -->\n");
      out.write("            </nav>\n");
      out.write("        <!-- Left navbar-header -->\n");
      out.write("        <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("            <div class=\"sidebar-nav navbar-collapse slimscrollsidebar\">\n");
      out.write("                <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                    <li style=\"padding: 10px 0 0;\">\n");
      out.write("                        <a href=\"dashboard.jsp\" class=\"waves-effect\"><i class=\"fa fa-clock-o fa-fw\"\n");
      out.write("                                aria-hidden=\"true\"></i><span class=\"hide-menu\">Dashboard</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() + Common.USER_LIST );
      out.write("\" class=\"waves-effect\"><i class=\"fa fa-user fa-fw\"\n");
      out.write("                                aria-hidden=\"true\"></i><span class=\"hide-menu\">Member</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() + Common.PROJECT );
      out.write("\" class=\"waves-effect\"><i class=\"fa fa-table fa-fw\"\n");
      out.write("                                aria-hidden=\"true\"></i><span class=\"hide-menu\">Project</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() + Common.TASK_LIST );
      out.write("\" class=\"waves-effect\"><i class=\"fa fa-table fa-fw\"\n");
      out.write("                                aria-hidden=\"true\"></i><span class=\"hide-menu\">Task</span></a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Left navbar-header end -->\n");
      out.write("        <!-- Page Content -->\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row bg-title\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-4 col-xs-12\">\n");
      out.write("                        <h4 class=\"page-title\">New Member</h4>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("                <!-- .row -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-2 col-12\"></div>\n");
      out.write("                    <div class=\"col-md-8 col-xs-12\">\n");
      out.write("                        <div class=\"white-box\">\n");
      out.write("                            <form class=\"form-horizontal form-material\" action=\"");
      out.print(request.getContextPath() + Common.USER_CREATE);
      out.write("\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-md-12\">Full Name</label>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"text\" placeholder=\"Nguyễn Văn A\" name=\"fullname\"\n");
      out.write("                                            class=\"form-control form-control-line\" required=\"required\"> </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"example-email\" class=\"col-md-12\">Email</label>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"email\" placeholder=\"abc@admin.com\"\n");
      out.write("                                            class=\"form-control form-control-line\" name=\"email\" required=\"required\"\n");
      out.write("                                            id=\"example-email\"> </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-md-12\">Password</label>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"password\" placeholder=\"*********\" name=\"password\" required=\"required\" class=\"form-control form-control-line\"> \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-md-12\">Phone</label>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"text\" placeholder=\"123 456 7890\" name=\"phone\" required=\"required\"\n");
      out.write("                                            class=\"form-control form-control-line\"> </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-sm-12\">Address</label>\n");
      out.write("                                    <div class=\"col-sm-12\">\n");
      out.write("                                        <input type=\"text\" placeholder=\"193 Lac Long Quan, P5,Q6,TPHCM\" name=\"address\" required=\"required\"\n");
      out.write("                                            class=\"form-control form-control-line\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-sm-12\">Role</label>\n");
      out.write("                                    <div class=\"col-sm-12\">\n");
      out.write("\t                                    <select id=\"role\" name=\"role\" data-toggle=\"select\" class=\"form-control form-control-line\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">ADMIN</option>\n");
      out.write("\t                            \t\t\t<option value=\"2\">LEADER</option>\n");
      out.write("\t                            \t\t\t<option value=\"3\">MEMBER</option>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <div class=\"col-sm-12\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-success\">Add</button>\n");
      out.write("                                        <a href=\"");
      out.print(request.getContextPath() + Common.USER_LIST);
      out.write("\" class=\"btn btn-primary\">Back</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-2 col-12\"></div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.container-fluid -->\n");
      out.write("            <footer class=\"footer text-center\"> 2022 &copy; myclass.com </footer>\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"assets/plugins/bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"assets/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- Menu Plugin JavaScript -->\n");
      out.write("    <script src=\"assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js\"></script>\n");
      out.write("    <!--slimscroll JavaScript -->\n");
      out.write("    <script src=\"assets/js/jquery.slimscroll.js\"></script>\n");
      out.write("    <!--Wave Effects -->\n");
      out.write("    <script src=\"assets/js/waves.js\"></script>\n");
      out.write("    <!-- Custom Theme JavaScript -->\n");
      out.write("    <script src=\"assets/js/custom.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}