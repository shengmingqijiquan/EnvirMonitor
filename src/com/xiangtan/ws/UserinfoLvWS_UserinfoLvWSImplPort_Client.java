/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import com.xiangtan.ws.impl.UserinfoLvWSImplService;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ public final class UserinfoLvWS_UserinfoLvWSImplPort_Client
/*     */ {
/*  23 */   private static final QName SERVICE_NAME = new QName("http://impl.ws.xiangtan.com/", "Userinfo_lvWSImplService");
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  29 */     URL wsdlURL = UserinfoLvWSImplService.WSDL_LOCATION;
/*  30 */     if ((args.length > 0) && (args[0] != null) && (!"".equals(args[0]))) {
/*  31 */       File wsdlFile = new File(args[0]);
/*     */       try {
/*  33 */         if (wsdlFile.exists())
/*  34 */           wsdlURL = wsdlFile.toURI().toURL();
/*     */         else
/*  36 */           wsdlURL = new URL(args[0]);
/*     */       }
/*     */       catch (MalformedURLException e) {
/*  39 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/*  43 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService(wsdlURL, SERVICE_NAME);
/*  44 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/*     */ 
/*  47 */     System.out.println("Invoking getUserinfoLvsLikeSth...");
/*  48 */     String _getUserinfoLvsLikeSth_arg0 = "";
/*  49 */     String _getUserinfoLvsLikeSth_arg1 = "";
/*  50 */     String _getUserinfoLvsLikeSth_arg2 = "";
/*  51 */     String _getUserinfoLvsLikeSth_arg3 = "";
/*  52 */     List _getUserinfoLvsLikeSth__return = port.getUserinfoLvsLikeSth(_getUserinfoLvsLikeSth_arg0, _getUserinfoLvsLikeSth_arg1, _getUserinfoLvsLikeSth_arg2, _getUserinfoLvsLikeSth_arg3);
/*  53 */     System.out.println("getUserinfoLvsLikeSth.result=" + _getUserinfoLvsLikeSth__return);
/*     */ 
/*  58 */     System.out.println("Invoking update...");
/*  59 */     int _update_arg0 = 0;
/*  60 */     String _update_arg1 = "";
/*  61 */     String _update_arg2 = "";
/*  62 */     String _update_arg3 = "";
/*  63 */     String _update_arg4 = "";
/*  64 */     String _update_arg5 = "";
/*  65 */     String _update_arg6 = "";
/*  66 */     String _update_arg7 = "";
/*  67 */     String _update_arg8 = "";
/*  68 */     String _update_arg9 = "";
/*  69 */     UserinfoLv _update__return = port.update(_update_arg0, _update_arg1, _update_arg2, _update_arg3, _update_arg4, _update_arg5, _update_arg6, _update_arg7, _update_arg8, _update_arg9);
/*  70 */     System.out.println("update.result=" + _update__return);
/*     */ 
/*  75 */     System.out.println("Invoking getUserinfoLv...");
/*  76 */     int _getUserinfoLv_arg0 = 0;
/*  77 */     String _getUserinfoLv_arg1 = "";
/*  78 */     UserinfoLv _getUserinfoLv__return = port.getUserinfoLv(_getUserinfoLv_arg0, _getUserinfoLv_arg1);
/*  79 */     System.out.println("getUserinfoLv.result=" + _getUserinfoLv__return);
/*     */ 
/*  84 */     System.out.println("Invoking getUsersByPager...");
/*  85 */     int _getUsersByPager_arg0 = 0;
/*  86 */     int _getUsersByPager_arg1 = 0;
/*  87 */     String _getUsersByPager_arg2 = "";
/*  88 */     List _getUsersByPager__return = port.getUsersByPager(_getUsersByPager_arg0, _getUsersByPager_arg1, _getUsersByPager_arg2);
/*  89 */     System.out.println("getUsersByPager.result=" + _getUsersByPager__return);
/*     */ 
/*  94 */     System.out.println("Invoking login...");
/*  95 */     String _login_arg0 = "";
/*  96 */     String _login_arg1 = "";
/*  97 */     UserinfoLv _login__return = port.login(_login_arg0, _login_arg1);
/*  98 */     System.out.println("login.result=" + _login__return);
/*     */ 
/* 103 */     System.out.println("Invoking getAll...");
/* 104 */     String _getAll_arg0 = "";
/* 105 */     List _getAll__return = port.getAll(_getAll_arg0);
/* 106 */     System.out.println("getAll.result=" + _getAll__return);
/*     */ 
/* 111 */     System.out.println("Invoking getUserinfoLvsByGroupid...");
/* 112 */     int _getUserinfoLvsByGroupid_arg0 = 0;
/* 113 */     String _getUserinfoLvsByGroupid_arg1 = "";
/* 114 */     List _getUserinfoLvsByGroupid__return = port.getUserinfoLvsByGroupid(_getUserinfoLvsByGroupid_arg0, _getUserinfoLvsByGroupid_arg1);
/* 115 */     System.out.println("getUserinfoLvsByGroupid.result=" + _getUserinfoLvsByGroupid__return);
/*     */ 
/* 120 */     System.out.println("Invoking getUserinfoLvByName...");
/* 121 */     String _getUserinfoLvByName_arg0 = "";
/* 122 */     String _getUserinfoLvByName_arg1 = "";
/* 123 */     UserinfoLv _getUserinfoLvByName__return = port.getUserinfoLvByName(_getUserinfoLvByName_arg0, _getUserinfoLvByName_arg1);
/* 124 */     System.out.println("getUserinfoLvByName.result=" + _getUserinfoLvByName__return);
/*     */ 
/* 129 */     System.out.println("Invoking add...");
/* 130 */     String _add_arg0 = "";
/* 131 */     String _add_arg1 = "";
/* 132 */     String _add_arg2 = "";
/* 133 */     String _add_arg3 = "";
/* 134 */     String _add_arg4 = "";
/* 135 */     String _add_arg5 = "";
/* 136 */     String _add_arg6 = "";
/* 137 */     String _add_arg7 = "";
/* 138 */     String _add_arg8 = "";
/* 139 */     UserinfoLv _add__return = port.add(_add_arg0, _add_arg1, _add_arg2, _add_arg3, _add_arg4, _add_arg5, _add_arg6, _add_arg7, _add_arg8);
/* 140 */     System.out.println("add.result=" + _add__return);
/*     */ 
/* 145 */     System.out.println("Invoking deleteUserinfoLv...");
/* 146 */     int _deleteUserinfoLv_arg0 = 0;
/* 147 */     String _deleteUserinfoLv_arg1 = "";
/* 148 */     boolean _deleteUserinfoLv__return = port.deleteUserinfoLv(_deleteUserinfoLv_arg0, _deleteUserinfoLv_arg1);
/* 149 */     System.out.println("deleteUserinfoLv.result=" + _deleteUserinfoLv__return);
/*     */ 
/* 154 */     System.exit(0);
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.UserinfoLvWS_UserinfoLvWSImplPort_Client
 * JD-Core Version:    0.6.2
 */