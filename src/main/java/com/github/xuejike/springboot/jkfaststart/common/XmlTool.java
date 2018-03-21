package com.github.xuejike.springboot.jkfaststart.common;

import com.bidanet.bdcms.core.exception.CheckException;
import com.thoughtworks.xstream.XStream;

public class XmlTool {

    public static String toXml(Object obj){
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        return xstream.toXML(obj);
    }
    public static Object fromXml(String xml,String error,Class ... classes){
        XStream xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.processAnnotations(classes);
        try{
            Object o = xstream.fromXML(xml);

            return o;
        }catch (Exception e){
            if (error==null){
                return null;
            }else{
                throw new CheckException(error);
            }
        }
    }
    public static Object fromXml(String xml, Class... classes){
        return fromXml(xml,null, classes);
    }
}
