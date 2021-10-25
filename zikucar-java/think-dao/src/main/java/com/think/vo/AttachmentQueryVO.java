package com.think.vo;

import com.think.entity.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_attachment
 * @author 
 */
@Data
public class AttachmentQueryVO implements Serializable {

   private Attachment attachment;

   private int page;

   private int size;
}