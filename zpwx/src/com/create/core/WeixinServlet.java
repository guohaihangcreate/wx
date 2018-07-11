package com.create.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.create.util.WxCheckUtil;
@WebServlet("/wx_c")
public class WeixinServlet extends HttpServlet {

	public WeixinServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		PrintWriter out = resp.getWriter();
		if(WxCheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}
}
