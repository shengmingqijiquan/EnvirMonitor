/*    */ package com.xiangtan.ws;
/*    */ 
/*    */ import com.xiangtan.ws.impl.AreaWSImplService;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import java.util.List;
/*    */ import javax.xml.namespace.QName;
/*    */ 
/*    */ public final class AreaWS_AreaWSImplPort_Client
/*    */ {
/* 23 */   private static final QName SERVICE_NAME = new QName("http://impl.ws.xiangtan.com/", "AreaWSImplService");
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 29 */     URL wsdlURL = AreaWSImplService.WSDL_LOCATION;
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
/* 43 */     AreaWSImplService ss = new AreaWSImplService(wsdlURL, SERVICE_NAME);
/* 44 */     AreaWS port = ss.getAreaWSImplPort();
/*    */ 
/* 47 */     System.out.println("Invoking getSubAreasByCode...");
/* 48 */     String _getSubAreasByCode_arg0 = "";
/* 49 */     String _getSubAreasByCode_arg1 = "";
/* 50 */     List _getSubAreasByCode__return = port.getSubAreasByCode(_getSubAreasByCode_arg0, _getSubAreasByCode_arg1);
/* 51 */     System.out.println("getSubAreasByCode.result=" + _getSubAreasByCode__return);
/*    */ 
/* 56 */     System.out.println("Invoking getAreaByCode...");
/* 57 */     String _getAreaByCode_arg0 = "";
/* 58 */     String _getAreaByCode_arg1 = "";
/* 59 */     Area _getAreaByCode__return = port.getAreaByCode(_getAreaByCode_arg0, _getAreaByCode_arg1);
/* 60 */     System.out.println("getAreaByCode.result=" + _getAreaByCode__return);
/*    */ 
/* 65 */     System.exit(0);
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.AreaWS_AreaWSImplPort_Client
 * JD-Core Version:    0.6.2
 */