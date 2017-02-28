/*     */ package com.ctgu.controller;
/*     */ 
/*     */ import com.xiangtan.ws.RoleLv;
/*     */ import com.xiangtan.ws.RoleLvWS;
/*     */ import com.xiangtan.ws.impl.RoleLvWSImplService;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class RoleController
/*     */ {
/*     */   @RequestMapping(value={"role/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String list(HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*  24 */     Integer curPage = Integer.valueOf(request.getParameter("curPage") == null ? 1 : Integer.valueOf(request.getParameter("curPage")).intValue());
/*  25 */     Integer flag = Integer.valueOf(request.getParameter("flag") == null ? 1 : Integer.valueOf(request.getParameter("flag")).intValue());
/*     */ 
/*  27 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/*  28 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*     */ 
/*  30 */     List roles = port.getAllRoles("admin");
/*     */ 
/*  33 */     int pageSize = 3;
/*     */ 
/*  35 */     int counts = roles.size();
/*     */ 
/*  37 */     int pages = counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1;
/*     */ 
/*  39 */     List list = new ArrayList();
/*  40 */     if (flag.intValue() == 1) {
/*  41 */       list = port.getRolesByPager(pageSize, 1, "admin");
/*  42 */       curPage = Integer.valueOf(1);
/*  43 */     } else if (flag.intValue() == 2) {
/*  44 */       if (curPage.intValue() > 1) {
/*  45 */         list = port.getRolesByPager(pageSize, curPage.intValue() - 1, "admin");
/*  46 */         curPage = Integer.valueOf(curPage.intValue() - 1);
/*     */       }
/*     */       else {
/*  49 */         list = port.getRolesByPager(pageSize, curPage.intValue(), "admin");
/*     */       } } else if (flag.intValue() == 3) {
/*  51 */       if (curPage.intValue() < counts / pageSize + 1) {
/*  52 */         list = port.getRolesByPager(pageSize, curPage.intValue() + 1, "admin");
/*  53 */         curPage = Integer.valueOf(curPage.intValue() + 1);
/*     */       }
/*     */       else {
/*  56 */         list = port.getRolesByPager(pageSize, curPage.intValue(), "admin");
/*     */       } } else if (flag.intValue() == 4) {
/*  58 */       list = port.getRolesByPager(pageSize, counts / pageSize + 1, "admin");
/*  59 */       curPage = Integer.valueOf(counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1);
/*     */     } else {
/*  61 */       list = port.getRolesByPager(pageSize, 1, "admin");
/*     */     }
/*     */ 
/*  64 */     model.addAttribute("roles", list);
/*  65 */     model.addAttribute("key", "value");
/*  66 */     model.addAttribute("curPage", curPage);
/*  67 */     model.addAttribute("counts", Integer.valueOf(counts));
/*  68 */     model.addAttribute("pageSize", Integer.valueOf(pageSize));
/*  69 */     model.addAttribute("pages", Integer.valueOf(pages));
/*  70 */     return "role/index";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/insertCommand"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String insertCommand(@RequestParam("name") String name, @RequestParam(value="command", required=false) String[] command) {
/*  77 */     StringBuilder commands = new StringBuilder();
/*     */ 
/*  79 */     System.out.println(command.length);
/*  80 */     for (int i = 0; i < command.length; i++) {
/*  81 */       commands.append(new StringBuilder().append(command[i]).append("||").toString());
/*     */     }
/*  83 */     System.out.println(commands);
/*     */ 
/*  85 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/*  86 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*  87 */     RoleLv role = port.addRoleLv(name, "command", commands.toString(), "admin");
/*  88 */     if (role != null)
/*     */     {
/*  90 */       System.out.println(role.getId());
/*  91 */       return "添加命令角色成功！";
/*     */     }
/*  93 */     return "添加命令角色失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/addCommand"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   public String addCommand()
/*     */   {
/* 100 */     return "role/addCommand";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/insertRegion"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String insertCommand(@RequestParam("name") String name) {
/* 107 */     StringBuilder commands = new StringBuilder();
/*     */ 
/* 109 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/* 110 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/* 111 */     RoleLv role = port.addRoleLv(name, "region", commands.toString(), "admin");
/*     */ 
/* 113 */     if (role != null)
/*     */     {
/* 115 */       System.out.println(role.getId());
/* 116 */       return "添加区域角色成功！";
/*     */     }
/* 118 */     return "添加区域角色失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/addRegion"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addRegion()
/*     */   {
/* 125 */     return "role/addRegion";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/del"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String edit(@RequestParam("id") int id) {
/* 132 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/* 133 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/* 134 */     boolean result = port.deleteByRoleId(id, "admin");
/* 135 */     if (result == true) {
/* 136 */       return "删除用户成功！";
/*     */     }
/* 138 */     return "删除用户失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET}, produces={"text/plain;charset=UTF-8"})
/*     */   public String edit(@RequestParam("id") int id, Model model)
/*     */   {
/* 145 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/* 146 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/* 147 */     RoleLv role = port.getRoleLv(id, "admin");
/*     */ 
/* 149 */     model.addAttribute("role", role);
/*     */ 
/* 151 */     if ("command".equals(role.getType()))
/*     */     {
/* 153 */       System.out.println(role.getDesText());
/* 154 */       return "role/editCommand";
/*     */     }
/* 156 */     return "role/editRegion";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/updateCommand"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String updateCommand(@RequestParam("id") int id, @RequestParam("roleName") String roleName, @RequestParam("type") String type, @RequestParam("command") String[] commands)
/*     */   {
/* 167 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/* 168 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*     */ 
/* 170 */     StringBuilder desText = new StringBuilder();
/* 171 */     for (int i = 0; i < commands.length; i++) {
/* 172 */       desText.append(new StringBuilder().append(commands[i]).append("||").toString());
/*     */     }
/*     */ 
/* 175 */     RoleLv role = port.updateRoleLv(id, roleName, type, desText.toString(), "admin");
/*     */ 
/* 177 */     if (role != null)
/*     */     {
/* 179 */       return "修改命令角色成功！";
/*     */     }
/* 181 */     return "修改命令角色失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"role/updateRegion"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String updateRegion(@RequestParam("id") int id, @RequestParam("roleName") String roleName, @RequestParam("type") String type, @RequestParam("command") String[] commands)
/*     */   {
/* 192 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/* 193 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*     */ 
/* 195 */     StringBuilder desText = new StringBuilder();
/* 196 */     for (int i = 0; i < commands.length; i++) {
/* 197 */       desText.append(new StringBuilder().append(commands[i]).append("||").toString());
/*     */     }
/*     */ 
/* 200 */     RoleLv role = port.updateRoleLv(id, roleName, type, desText.toString(), "admin");
/*     */ 
/* 202 */     if (role != null)
/*     */     {
/* 204 */       return "修改区域角色成功！";
/*     */     }
/* 206 */     return "修改区域角色失败！";
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.ctgu.controller.RoleController
 * JD-Core Version:    0.6.2
 */