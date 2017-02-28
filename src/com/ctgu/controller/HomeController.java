/*    */ package com.ctgu.controller;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class HomeController
/*    */ {
/*    */   @RequestMapping({"/"})
/*    */   public String login(HttpServletRequest request)
/*    */   {
/* 17 */     return "login";
/*    */   }
/*    */ 
/*    */   @RequestMapping({"/index"})
/*    */   public String index(HttpServletRequest request) {
/* 22 */     return "index";
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.ctgu.controller.HomeController
 * JD-Core Version:    0.6.2
 */