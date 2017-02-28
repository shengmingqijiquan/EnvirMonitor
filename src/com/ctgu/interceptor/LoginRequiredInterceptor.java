/*    */ package com.ctgu.interceptor;
/*    */ 
/*    */ import com.xiangtan.ws.UserinfoLv;
/*    */ import java.io.PrintStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ public class LoginRequiredInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception modelAndView)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 31 */     System.out.println("gw");
/*    */ 
/* 33 */     String contextPath = request.getContextPath();
/* 34 */     String url = request.getServletPath().toString();
/* 35 */     HttpSession session = request.getSession();
/* 36 */     UserinfoLv user = (UserinfoLv)session.getAttribute("user");
/* 37 */     if (user == null)
/*    */     {
/* 39 */       response.sendRedirect(contextPath + "/");
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.ctgu.interceptor.LoginRequiredInterceptor
 * JD-Core Version:    0.6.2
 */