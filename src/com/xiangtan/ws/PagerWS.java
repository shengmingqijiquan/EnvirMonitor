package com.xiangtan.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://ws.xiangtan.com/", name="PagerWS")
@XmlSeeAlso({ObjectFactory.class})
public abstract interface PagerWS
{
  @WebMethod
  @RequestWrapper(localName="getPager", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetPager")
  @ResponseWrapper(localName="getPagerResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetPagerResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract Pager getPager(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);
}

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.PagerWS
 * JD-Core Version:    0.6.2
 */