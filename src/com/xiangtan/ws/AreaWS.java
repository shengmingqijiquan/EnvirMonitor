package com.xiangtan.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://ws.xiangtan.com/", name="AreaWS")
@XmlSeeAlso({ObjectFactory.class})
public abstract interface AreaWS
{
  @WebMethod
  @RequestWrapper(localName="getSubAreasByCode", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetSubAreasByCode")
  @ResponseWrapper(localName="getSubAreasByCodeResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetSubAreasByCodeResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<Area> getSubAreasByCode(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);

  @WebMethod
  @RequestWrapper(localName="getAreaByCode", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAreaByCode")
  @ResponseWrapper(localName="getAreaByCodeResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAreaByCodeResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract Area getAreaByCode(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);
}

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.AreaWS
 * JD-Core Version:    0.6.2
 */