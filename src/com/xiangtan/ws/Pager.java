/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="pager", propOrder={"currentPage", "pageSize", "totalCount", "totalPage"})
/*     */ public class Pager
/*     */ {
/*     */   protected int currentPage;
/*     */   protected int pageSize;
/*     */   protected int totalCount;
/*     */   protected int totalPage;
/*     */ 
/*     */   public int getCurrentPage()
/*     */   {
/*  50 */     return this.currentPage;
/*     */   }
/*     */ 
/*     */   public void setCurrentPage(int value)
/*     */   {
/*  58 */     this.currentPage = value;
/*     */   }
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/*  66 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int value)
/*     */   {
/*  74 */     this.pageSize = value;
/*     */   }
/*     */ 
/*     */   public int getTotalCount()
/*     */   {
/*  82 */     return this.totalCount;
/*     */   }
/*     */ 
/*     */   public void setTotalCount(int value)
/*     */   {
/*  90 */     this.totalCount = value;
/*     */   }
/*     */ 
/*     */   public int getTotalPage()
/*     */   {
/*  98 */     return this.totalPage;
/*     */   }
/*     */ 
/*     */   public void setTotalPage(int value)
/*     */   {
/* 106 */     this.totalPage = value;
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.Pager
 * JD-Core Version:    0.6.2
 */