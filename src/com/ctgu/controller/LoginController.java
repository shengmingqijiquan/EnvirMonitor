/*    */ package com.ctgu.controller;
/*    */ 
/*    */ import com.xiangtan.ws.UserinfoLv;
/*    */ import com.xiangtan.ws.UserinfoLvWS;
/*    */ import com.xiangtan.ws.impl.UserinfoLvWSImplService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class LoginController
/*    */ {
/*    */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String indexlogin(HttpServletRequest request)
/*    */   {
/* 21 */     String username = request.getParameter("username");
/* 22 */     String password = request.getParameter("password");
/* 23 */     if ((username == null) || ("".equals(username)) || (password == null) || ("".equals(password)))
/*    */     {
/* 25 */       return "redirect:/";
/*    */     }
/*    */ 
/* 28 */     UserinfoLv userinfoLv = null;
/*    */     try {
/* 30 */       UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 31 */       UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 32 */       userinfoLv = port.login(username, password);
/*    */     } catch (Exception e) {
/* 34 */       return "redirect:/";
/*    */     }
/*    */ 
/* 37 */     if (userinfoLv == null) {
/* 38 */       return "redirect:/";
/*    */     }
/* 40 */     HttpSession session = request.getSession();
/* 41 */     session.setMaxInactiveInterval(86400);
/* 42 */     session.setAttribute("user", userinfoLv);
/* 43 */     return "index";
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.ctgu.controller.LoginController
 * JD-Core Version:    0.6.2
 */