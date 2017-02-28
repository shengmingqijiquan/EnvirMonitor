/*    */ package com.xiangtan.ws;
/*    */ 
/*    */ import com.xiangtan.ws.impl.PagerWSImplService;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import javax.xml.namespace.QName;
/*    */ 
/*    */ public final class PagerWS_PagerWSImplPort_Client
/*    */ {
/* 23 */   private static final QName SERVICE_NAME = new QName("http://impl.ws.xiangtan.com/", "PagerWSImplService");
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 29 */     URL wsdlURL = PagerWSImplService.WSDL_LOCATION;
/* 30 */     if ((args.length > 0) && (args[0] != null) && (!"".equals(args[0]))) {
/* 31 */       File wsdlFile = new File(args[0]);
/*    */       try {
/* 33 */         if (wsdlFile.exists())
/* 34 */           wsdlURL = wsdlFile.toURI().toURL();
/*    */         else
/* 36 */           wsdlURL = new URL(args[0]);
/*    */       }
/*    */       catch (MalformedURLException e) {
/* 39 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */ 
/* 43 */     PagerWSImplService ss = new PagerWSImplService(wsdlURL, SERVICE_NAME);
/* 44 */     PagerWS port = ss.getPagerWSImplPort();
/*    */ 
/* 47 */     System.out.println("Invoking getPager...");
/* 48 */     String _getPager_arg0 = "";
/* 49 */     String _getPager_arg1 = "";
/* 50 */     Pager _getPager__return = port.getPager(_getPager_arg0, _getPager_arg1);
/* 51 */     System.out.println("getPager.result=" + _getPager__return);
/*    */ 
/* 56 */     System.exit(0);
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.PagerWS_PagerWSImplPort_Client
 * JD-Core Version:    0.6.2
 */