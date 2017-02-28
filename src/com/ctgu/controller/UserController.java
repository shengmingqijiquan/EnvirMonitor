/*     */ package com.ctgu.controller;
/*     */ 
/*     */ import com.xiangtan.ws.RoleLvWS;
import com.xiangtan.ws.UserinfoLv;
import com.xiangtan.ws.UserinfoLvWS;
import com.xiangtan.ws.impl.RoleLvWSImplService;
import com.xiangtan.ws.impl.UserinfoLvWSImplService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ @Controller
/*     */ public class UserController
/*     */ {
/*     */   @RequestMapping(value={"user/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String list(HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*  29 */     Integer curPage = Integer.valueOf(request.getParameter("curPage") == null ? 1 : Integer.valueOf(request.getParameter("curPage")).intValue());
/*  30 */     Integer flag = Integer.valueOf(request.getParameter("flag") == null ? 1 : Integer.valueOf(request.getParameter("flag")).intValue());
/*     */ 
/*  32 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/*  33 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/*     */ 
/*  35 */     List users = port.getAll("admin");
/*     */ 
/*  38 */     int pageSize = 3;
/*     */ 
/*  40 */     int counts = users.size();
/*  41 */     int pages = counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1;
/*     */ 
/*  43 */     List list = new ArrayList();
/*  44 */     if (flag.intValue() == 1) {
/*  45 */       list = port.getUsersByPager(pageSize, 1, "admin");
/*  46 */       curPage = Integer.valueOf(1);
/*  47 */     } else if (flag.intValue() == 2) {
/*  48 */       if (curPage.intValue() > 1) {
/*  49 */         list = port.getUsersByPager(pageSize, curPage.intValue() - 1, "admin");
/*  50 */         curPage = Integer.valueOf(curPage.intValue() - 1);
/*     */       }
/*     */       else {
/*  53 */         list = port.getUsersByPager(pageSize, curPage.intValue(), "admin");
/*     */       } } else if (flag.intValue() == 3) {
/*  55 */       if (curPage.intValue() < counts / pageSize + 1) {
/*  56 */         list = port.getUsersByPager(pageSize, curPage.intValue() + 1, "admin");
/*  57 */         curPage = Integer.valueOf(curPage.intValue() + 1);
/*     */       }
/*     */       else {
/*  60 */         list = port.getUsersByPager(pageSize, curPage.intValue(), "admin");
/*     */       } } else if (flag.intValue() == 4) {
/*  62 */       list = port.getUsersByPager(pageSize, pages, "admin");
/*  63 */       curPage = Integer.valueOf(pages);
/*     */     } else {
/*  65 */       list = port.getUsersByPager(pageSize, 1, "admin");
/*     */     }
/*     */ 
/*  68 */     model.addAttribute("users", list);
/*  69 */     model.addAttribute("key", "value");
/*  70 */     model.addAttribute("curPage", curPage);
/*  71 */     model.addAttribute("counts", Integer.valueOf(counts));
/*  72 */     model.addAttribute("pageSize", Integer.valueOf(pageSize));
/*  73 */     model.addAttribute("pages", Integer.valueOf(pages));
/*     */ 
/*  75 */     return "user/index";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/insert"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String insert(Model model) {
/*  80 */     RoleLvWSImplService ss = new RoleLvWSImplService();
/*  81 */     RoleLvWS port = ss.getRoleLvWSImplPort();
/*  82 */     List list = port.getAllRoles("admin");
/*     */ 
/*  85 */     model.addAttribute("roles", list);
/*     */ 
/*  87 */     return "user/addUser";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String add(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("realname") String realname, @RequestParam("email") String email, @RequestParam("tel") String tel, @RequestParam("department") String department, @RequestParam("note") String note, @RequestParam("roleIds") String[] roleIds)
/*     */   {
/* 101 */     StringBuilder rids = new StringBuilder();
/* 102 */     for (int i = 0; (i < roleIds.length - 1) && (roleIds.length > 1); i++) {
/* 103 */       rids.append(roleIds[i]);
/* 104 */       rids.append(",");
/*     */     }
/* 106 */     if (roleIds.length > 0) {
/* 107 */       rids.append(roleIds[(roleIds.length - 1)]);
/*     */     }
/*     */ 
/* 110 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 111 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 112 */     UserinfoLv user = port.add(username, password, email, tel, realname, department, note, rids.toString(), "admin");
/* 113 */     System.out.println(rids);
/* 114 */     if (user != null)
/*     */     {
/* 116 */       return "添加用户成功！";
/*     */     }
/* 118 */     return "添加用户失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/lookfor"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String lookfor()
/*     */   {
/* 124 */     return "user/lookforUser";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/search"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String search(@RequestParam("name") String name, @RequestParam("truename") String truename, @RequestParam("department") String department, Model model)
/*     */   {
/* 133 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 134 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/*     */ 
/* 136 */     List list = port.getUserinfoLvsLikeSth(name, department, truename, "admin");
/* 137 */     model.addAttribute("users", list);
/* 138 */     return "user/lookforUser";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/del"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String edit(@RequestParam("id") int id)
/*     */   {
/* 146 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 147 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 148 */     boolean result = port.deleteUserinfoLv(id, "admin");
/* 149 */     if (result == true) {
/* 150 */       return "删除用户成功！";
/*     */     }
/* 152 */     return "删除用户失败！";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String detail(@RequestParam("id") int id, Model model)
/*     */   {
/* 159 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 160 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 161 */     UserinfoLv user = port.getUserinfoLv(id, "admin");
/*     */ 
/* 163 */     model.addAttribute("user", user);
/* 164 */     return "user/detailUser";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String edit(@RequestParam("id") int id, Model model)
/*     */   {
/* 170 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 171 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 172 */     UserinfoLv user = port.getUserinfoLv(id, "admin");
/*     */ 
/* 174 */     model.addAttribute("user", user);
/*     */ 
/* 176 */     RoleLvWSImplService rss = new RoleLvWSImplService();
/* 177 */     RoleLvWS rport = rss.getRoleLvWSImplPort();
/* 178 */     List list = rport.getAllRoles("admin");
/*     */ 
/* 180 */     List userRoleLvs = rport.getRoleLvsByUserid(id, "admin");
/*     */ 
/* 183 */     model.addAttribute("roles", list);
/* 184 */     model.addAttribute("userRoles", userRoleLvs);
/* 185 */     System.out.println(new StringBuilder().append("roles  ").append(list.size()).toString());
/* 186 */     return "user/editUser";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"user/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"text/plain;charset=UTF-8"})
/*     */   @ResponseBody
/*     */   public String update(@RequestParam("id") int id, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("realname") String realname, @RequestParam("email") String email, @RequestParam("tel") String tel, @RequestParam("department") String department, @RequestParam("note") String note, @RequestParam("roleIds") String[] roleIds)
/*     */   {
/* 201 */     StringBuilder rids = new StringBuilder();
/* 202 */     for (int i = 0; (i < roleIds.length - 1) && (roleIds.length > 1); i++) {
/* 203 */       rids.append(roleIds[i]);
/* 204 */       rids.append(",");
/*     */     }
/* 206 */     if (roleIds.length > 0) {
/* 207 */       rids.append(roleIds[(roleIds.length - 1)]);
/*     */     }
/*     */ 
/* 210 */     UserinfoLvWSImplService ss = new UserinfoLvWSImplService();
/* 211 */     UserinfoLvWS port = ss.getUserinfoLvWSImplPort();
/* 212 */     UserinfoLv user = port.update(id, username, password, email, tel, realname, department, note, rids.toString(), "admin");
/* 213 */     System.out.println(rids);
/* 214 */     if (user != null)
/*     */     {
/* 216 */       return "修改用户成功！";
/*     */     }
/* 218 */     return "修改用户失败！";
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.ctgu.controller.UserController
 * JD-Core Version:    0.6.2
 */