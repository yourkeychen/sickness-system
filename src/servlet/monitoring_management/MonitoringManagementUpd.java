package servlet.monitoring_management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SickerService;
import service.impl.SickerServiceImpl;
@WebServlet(name = "monitoringManagement/upd", urlPatterns = { "/monitoringManagement/upd" })
public class MonitoringManagementUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SickerService service = new SickerServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		String id = req.getParameter("id");
		String age = req.getParameter("age");
		String home_address = req.getParameter("home_address");
		String sick = req.getParameter("sick");
		String phone = req.getParameter("phone");
		String work_address = req.getParameter("work_address");
		String scope = req.getParameter("scope");
		int result = service.updSickerInfo(id,age,home_address,sick,phone,work_address,scope);
		if(result > 0) {
			req.getSession().setAttribute("msg", "更新成功！");
		} else {
			req.getSession().setAttribute("msg", "更新失败！");
		}
		resp.sendRedirect("/sickness-system/sicker");
	}

}
