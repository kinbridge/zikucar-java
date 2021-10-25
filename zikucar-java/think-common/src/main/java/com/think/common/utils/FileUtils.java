package com.think.common.utils;

import com.think.common.exception.ThinkException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sun.plugin2.ipc.IPCFactory.KB;

/**
 * 文件相关工具类
 *
 * @author bridge
 * 2021/10/24/11:49
 */
@Slf4j
public class FileUtils {

    /**
     * 保存文件
     *
     * @param inputStream 文件流
     * @param path        文件路径
     */
    public static void saveFile(InputStream inputStream, String path,String filename) {

        OutputStream os = null;
        try {
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(path+File.separator+filename);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (Exception e) {
            log.error("file upload {} error", path, e);
            throw new ThinkException(e.getMessage());
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件的后缀名
     */
    public static String getFileSuffix(String originalFilename) {
        //获取最后一个.的位置
        int lastIndexOf = originalFilename.lastIndexOf(".");
        //获取文件的后缀名 .jpg
        return originalFilename.substring(lastIndexOf);
    }
}
