package day0827;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = simpleDateFormat.format(date);
		Cookie cookie = new Cookie("lastAccessTime", time);
		cookie.setMaxAge(2*60);
		resp.addCookie(cookie);
		
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for(Cookie cookie2:cookies){
				if (cookie2.getName().equals("lastAccessTime")) {
					lastAccessTime = cookie2.getValue();
				}
			}
		}
		
		resp.setContentType("text/html;charset=utf-8");
		if (lastAccessTime == null) {
			resp.getWriter().println("第一次访问");
		}else {
			resp.getWriter().println("上次访问时间：" + lastAccessTime);
		}
	}

}
