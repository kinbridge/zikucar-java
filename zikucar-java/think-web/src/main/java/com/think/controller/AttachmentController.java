package com.think.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.think.common.BaseController;
import com.think.common.utils.DateUtils;
import com.think.common.utils.FileUtils;
import com.think.common.utils.ThinkStrUtils;
import com.think.common.views.Result;
import com.think.common.views.ResultPage;
import com.think.entity.Attachment;
import com.think.entity.ThinkBaseInfo;
import com.think.service.IAttachmentService;
import com.think.service.IThinkBaseInfoService;
import com.think.vo.AttachmentListVO;
import com.think.vo.AttachmentQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@Slf4j
@RestController
@RequestMapping("/attach")
public class AttachmentController extends BaseController<Attachment> {

    public static final String BASE_PATH = "C:\\Users\\Administrator\\Desktop\\tmp\\attach";


    @Autowired
    private IAttachmentService service;
    @Autowired
    private IThinkBaseInfoService baseInfoService;

    public IAttachmentService getIService() {
        return service;
    }


    @PostMapping("/pageList")
    public ResultPage listPage(@RequestBody AttachmentQueryVO queryVO) {

        IPage<Attachment> attachmentIPage = service.pageList(queryVO.getAttachment(), queryVO.getPage(), queryVO.getSize());
        ResultPage page = new ResultPage();
        page.setPage(queryVO.getPage());
        page.setSize(queryVO.getSize());
        page.setTotal(attachmentIPage.getTotal());
        List<AttachmentListVO> listDatas = new ArrayList<>();
        if(!CollectionUtils.isEmpty(attachmentIPage.getRecords())){
            attachmentIPage.getRecords().forEach(attachment -> {
                attachment.setOnlineUrl("/think/attach/getImage?id="+attachment.getPkId());
                AttachmentListVO attachmentListVO = new AttachmentListVO();
                BeanUtils.copyProperties(attachment,attachmentListVO);
                ThinkBaseInfo base = baseInfoService.getById(attachment.getThinkBaseInfoId());
                if(base != null){
                    attachmentListVO.setHref(base.getHref());
                    attachmentListVO.setTitle(base.getTitle());
                }
                listDatas.add(attachmentListVO);
            });
        }
        page.setData(listDatas);
        page.setCode(200);
        return page;
    }

    /**
     * 单据附件上传
     *
     * @param billId   单据id
     * @param formType 单据类型
     * @param file     上传的文件
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result uploadFormFile(@RequestParam(value = "billId") Long billId,
                                 @RequestParam(value = "formType") Long formType,
                                 @RequestParam("file") MultipartFile[] file) throws Exception {
        try {
            List<Attachment> attachments = new ArrayList<>();
            String yearMonth = DateUtils.format(new Date(), "yyyyMM");
            // 文件上传后的路径
            for (MultipartFile f : file) {
                Attachment attachment = new Attachment();
                String uuid = ThinkStrUtils.getUUID();
                // 上传简单文件名
                String originalFilename = f.getOriginalFilename();
                String fileType = FileUtils.getFileSuffix(originalFilename);
                // 存储路径
                String filePath = BASE_PATH + File.separator + yearMonth;
                FileUtils.saveFile(f.getInputStream(), filePath,uuid+fileType);
                attachment.setSize(f.getSize());
                attachment.setThinkBaseInfoId(billId);
                attachment.setThinkTypeId(formType);
                if(StringUtils.hasText(originalFilename) && originalFilename.contains(".")){
                    attachment.setOriginName(originalFilename.split("\\.")[0]);
                }
                attachment.setFileName(uuid);
                attachment.setUrl(filePath+File.separator+uuid+fileType);
                attachment.setFileType(fileType);
                attachment.setCreateBy(1);
                attachment.setCreateDate(new Date());
                attachments.add(attachment);
            }
            if (!CollectionUtils.isEmpty(attachments)) {
                service.saveBatch(attachments);
            }
            // 返回图片路径
            return Result.success(attachments);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }


    @GetMapping("/getImage")
    public void IoReadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        try {
            //获取图片存放路径
            String id = request.getParameter("id");
            Attachment attachment = service.getById(Long.valueOf(id));
            ips = new FileInputStream(new File(attachment.getUrl()));
            response.setContentType("image/png");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        } finally {
            if (out != null) {
                out.close();
            }
            if (ips != null) {
                ips.close();
            }
        }
    }


}
