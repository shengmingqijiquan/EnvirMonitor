/*    */ package com.xiangtan.ws;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="getRolesByPagerResponse", propOrder={"_return"})
/*    */ public class GetRolesByPagerResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="return")
/*    */   protected List<RoleLv> _return;
/*    */ 
/*    */   public List<RoleLv> getReturn()
/*    */   {
/* 63 */     if (this._return == null) {
/* 64 */       this._return = new ArrayList();
/*    */     }
/* 66 */     return this._return;
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.GetRolesByPagerResponse
 * JD-Core Version:    0.6.2
 */