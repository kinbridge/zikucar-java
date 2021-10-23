package com.think.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.ThinkType;
import com.think.mapper.ThinkTypeMapper;
import com.think.service.IThinkTypeService;
import org.springframework.stereotype.Service;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class ThinkTypeServiceImpl extends ServiceImpl<ThinkTypeMapper, ThinkType> implements IThinkTypeService {

}
