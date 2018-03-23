package com.github.xuejike.springboot.print.driver.file;

import com.bidanet.bdcms.core.common.SpringWebTool;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Service("localFileDrive")
public class LocalFileDrive extends BaseFileDrive implements FileDrive {
    protected static final String path="/upload";
    protected static final String filePath="file";
    protected static final String imgPath="img";

    protected static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private String getSavePath(String subPath){

        String tempPath = path + "/" + subPath + "/" + simpleDateFormat.format(new Date());
        String realPath = SpringWebTool.getRealPath(tempPath);
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        return tempPath;
    }
    private String getFileSavePath(){
        return getSavePath(filePath);
    }
    private String getImgSavePath(){
        return getSavePath(imgPath);
    }

    @Override
    public String upload(File file, String saveName) throws IOException {
        String fileSavePath = getFileSavePath();
        String s = fileSavePath + "/" + saveName;
        FileUtils.moveFile(file,new File(SpringWebTool.getRealPath(s)));
        return SpringWebTool.getWebRootUrl() +s;
    }

    @Override
    public String upload(File file) throws IOException {
        String fileName = createRandomName(file.getName());
        return upload(file,fileName);

    }
    @Override
    public String upload(InputStream in, String oldName) throws IOException {
        String fileName = createRandomName(oldName);
        return uploadToFileName(in,fileName);
    }
    @Override
    public String uploadToFileName(InputStream in, String newName) throws IOException {
        String fileSavePath = getFileSavePath();
        String s = fileSavePath + "/" + newName;
        File file = new File(SpringWebTool.getRealPath(s));
        FileUtils.copyInputStreamToFile(in,file);
        return SpringWebTool.getWebRootUrl()+s;
    }

    @Override
    public String uploadToFileName(InputStream in, String newName, String prefix) throws IOException {
        return null;
    }

    @Override
    public File uploadToLocation(InputStream in, String newName) throws IOException {
        String fileSavePath = getFileSavePath();
        String s = fileSavePath + "/" + createRandomName(newName);
        File file = new File(SpringWebTool.getRealPath(s));
        FileUtils.copyInputStreamToFile(in,file);
        return file;
    }

    @Override
    public String uploadImg(File file, String saveName) throws IOException {
        String fileSavePath = getImgSavePath();
        String s = fileSavePath + "/" + saveName;
        if(!new File(SpringWebTool.getRealPath(s)).exists()) {
            FileUtils.moveFile(file, new File(SpringWebTool.getRealPath(s)));
        }
        return SpringWebTool.getWebRootUrl()+s;
    }

    @Override
    public String uploadImg(File file) throws IOException {
        
        String fileName = createRandomName(file.getName());
        return upload(file,fileName);

    }

    @Override
    public String uploadImgToFileName(InputStream in, String saveName) throws IOException {
        return null;
    }

    @Override
    public String uploadImg(InputStream in, String oldName) throws IOException {
        return null;
    }

    @Override
    public String uploadImg(InputStream in, String oldName, String prefix) throws IOException {
       return null;
    }

    @Override
    public String uploadTempImgPackage(File file, String saveName,String directoryName) throws IOException {
        String tempPath = path + "/" + imgPath + "/" +directoryName;
        String realPath = SpringWebTool.getRealPath(tempPath);
        File fil = new File(realPath);
        if (!fil.exists()){
            fil.mkdirs();
        }
        String s = tempPath + "/" + saveName;
        if(!new File(SpringWebTool.getRealPath(s)).exists()) {
            FileUtils.moveFile(file, new File(SpringWebTool.getRealPath(s)));
        }
        System.out.println(s);
        return SpringWebTool.getRealPath(tempPath);
    }
}
