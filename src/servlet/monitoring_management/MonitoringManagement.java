package servlet.monitoring_management;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SickerService;
import service.impl.SickerServiceImpl;

/**
 * Servlet implementation class MonitoringManagement
 */
@WebServlet("/monitoringManagement")
public class MonitoringManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SickerService service = new SickerServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		List<Map<String, Object>> infos = service.selectAllSickerInfo();
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/monitoring-and-management.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码  
        resp.setContentType("text/html;charset=utf-8");  
        //请求解决乱码  
        req.setCharacterEncoding("utf-8");  
        //响应解决乱码  
        resp.setCharacterEncoding("utf-8"); 
		String sickType = req.getParameter("sick");
		String scopeType = req.getParameter("scope");
		List<Map<String, Object>> infos = service.selectSickerInfo(sickType, scopeType);
		req.getSession().setAttribute("infos", infos);
		resp.sendRedirect("/sickness-system/monitoring-and-management.jsp");
		
	}
	
}
