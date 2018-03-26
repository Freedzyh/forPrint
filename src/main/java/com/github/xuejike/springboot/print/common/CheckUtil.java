package com.github.xuejike.springboot.print.common;

import com.bidanet.bdcms.core.common.JsonParseTool;
import com.bidanet.bdcms.core.exception.CheckException;
import com.github.xuejike.springboot.print.entity.dto.FileDto;
import com.google.common.base.Strings;
import org.springframework.util.StringUtils;

import java.util.List;

public class CheckUtil {

    public static void checkNull(Object obj, String msg) {
        if (obj == null) {
            throw new CheckException(msg);
        }

        if (StringUtils.isEmpty(obj)) {
            throw new CheckException(msg);
        }
    }


    public static void checkUpFileUrl(String url,String errorMessage) {

        if (StringUtils.isEmpty(url)) {
            throw new CheckException(errorMessage);
        }
        List<FileDto> list = JsonParseTool.parseArray(url,FileDto.class,"上传文件解析异常");

        if(list.size()<=0){
            throw new CheckException(errorMessage);
        }

    }



    public static String getUpFileUrl(String url) {

        List<FileDto> list= JsonParseTool.parseArray(url,FileDto.class,"解析异常");
        if(list.size()>0&&(!Strings.isNullOrEmpty(list.get(0).getUrl()))) {
            return list.get(0).getUrl();
        }

        return null;
    }

}
