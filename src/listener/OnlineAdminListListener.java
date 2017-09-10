package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import vo.Admin;

public class OnlineAdminListListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Admin> onlineAdminList = new ArrayList<Admin>();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onlineAdminList", onlineAdminList);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
