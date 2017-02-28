/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import com.xiangtan.ws.impl.RoleLvWSImplService;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ public final class RoleLvWS_RoleLvWSImplPort_Client
/*     */ {
/*  23 */   private static final QName SERVICE_NAME = new QName("http://impl.ws.xiangtan.com/", "Role_lvWSImplService");
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  29 */     URL wsdlURL = RoleLvWSImplService.WSDL_LOCATION;
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
/*  43 */     RoleLvWSImplService ss = new RoleLvWSImplService(wsdlURL, SERVICE_NAME);
/*  44 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*     */ 
/*  47 */     System.out.println("Invoking getAreasByDesText...");
/*  48 */     String _getAreasByDesText_arg0 = "";
/*  49 */     String _getAreasByDesText_arg1 = "";
/*  50 */     List _getAreasByDesText__return = port.getAreasByDesText(_getAreasByDesText_arg0, _getAreasByDesText_arg1);
/*  51 */     System.out.println("getAreasByDesText.result=" + _getAreasByDesText__return);
/*     */ 
/*  56 */     System.out.println("Invoking updateRoleLv...");
/*  57 */     int _updateRoleLv_arg0 = 0;
/*  58 */     String _updateRoleLv_arg1 = "";
/*  59 */     String _updateRoleLv_arg2 = "";
/*  60 */     String _updateRoleLv_arg3 = "";
/*  61 */     String _updateRoleLv_arg4 = "";
/*  62 */     RoleLv _updateRoleLv__return = port.updateRoleLv(_updateRoleLv_arg0, _updateRoleLv_arg1, _updateRoleLv_arg2, _updateRoleLv_arg3, _updateRoleLv_arg4);
/*  63 */     System.out.println("updateRoleLv.result=" + _updateRoleLv__return);
/*     */ 
/*  68 */     System.out.println("Invoking addRoleLv...");
/*  69 */     String _addRoleLv_arg0 = "";
/*  70 */     String _addRoleLv_arg1 = "";
/*  71 */     String _addRoleLv_arg2 = "";
/*  72 */     String _addRoleLv_arg3 = "";
/*  73 */     RoleLv _addRoleLv__return = port.addRoleLv(_addRoleLv_arg0, _addRoleLv_arg1, _addRoleLv_arg2, _addRoleLv_arg3);
/*  74 */     System.out.println("addRoleLv.result=" + _addRoleLv__return);
/*     */ 
/*  79 */     System.out.println("Invoking getRoleLv...");
/*  80 */     int _getRoleLv_arg0 = 0;
/*  81 */     String _getRoleLv_arg1 = "";
/*  82 */     RoleLv _getRoleLv__return = port.getRoleLv(_getRoleLv_arg0, _getRoleLv_arg1);
/*  83 */     System.out.println("getRoleLv.result=" + _getRoleLv__return);
/*     */ 
/*  88 */     System.out.println("Invoking getAll...");
/*  89 */     String _getAll_arg0 = "";
/*  90 */     List _getAll__return = port.getAll(_getAll_arg0);
/*  91 */     System.out.println("getAll.result=" + _getAll__return);
/*     */ 
/*  96 */     System.out.println("Invoking getRoleLvsByUserid...");
/*  97 */     int _getRoleLvsByUserid_arg0 = 0;
/*  98 */     String _getRoleLvsByUserid_arg1 = "";
/*  99 */     List _getRoleLvsByUserid__return = port.getRoleLvsByUserid(_getRoleLvsByUserid_arg0, _getRoleLvsByUserid_arg1);
/* 100 */     System.out.println("getRoleLvsByUserid.result=" + _getRoleLvsByUserid__return);
/*     */ 
/* 105 */     System.out.println("Invoking deleteByRoleName...");
/* 106 */     String _deleteByRoleName_arg0 = "";
/* 107 */     String _deleteByRoleName_arg1 = "";
/* 108 */     boolean _deleteByRoleName__return = port.deleteByRoleName(_deleteByRoleName_arg0, _deleteByRoleName_arg1);
/* 109 */     System.out.println("deleteByRoleName.result=" + _deleteByRoleName__return);
/*     */ 
/* 114 */     System.out.println("Invoking deleteByRoleId...");
/* 115 */     int _deleteByRoleId_arg0 = 0;
/* 116 */     String _deleteByRoleId_arg1 = "";
/* 117 */     boolean _deleteByRoleId__return = port.deleteByRoleId(_deleteByRoleId_arg0, _deleteByRoleId_arg1);
/* 118 */     System.out.println("deleteByRoleId.result=" + _deleteByRoleId__return);
/*     */ 
/* 123 */     System.out.println("Invoking getRolesByPager...");
/* 124 */     int _getRolesByPager_arg0 = 0;
/* 125 */     int _getRolesByPager_arg1 = 0;
/* 126 */     String _getRolesByPager_arg2 = "";
/* 127 */     List _getRolesByPager__return = port.getRolesByPager(_getRolesByPager_arg0, _getRolesByPager_arg1, _getRolesByPager_arg2);
/* 128 */     System.out.println("getRolesByPager.result=" + _getRolesByPager__return);
/*     */ 
/* 133 */     System.out.println("Invoking getByRoleName...");
/* 134 */     String _getByRoleName_arg0 = "";
/* 135 */     String _getByRoleName_arg1 = "";
/* 136 */     RoleLv _getByRoleName__return = port.getByRoleName(_getByRoleName_arg0, _getByRoleName_arg1);
/* 137 */     System.out.println("getByRoleName.result=" + _getByRoleName__return);
/*     */ 
/* 142 */     System.exit(0);
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.RoleLvWS_RoleLvWSImplPort_Client
 * JD-Core Version:    0.6.2
 */