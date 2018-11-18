package com.adc.da.test.service;

import com.adc.da.test.dao.DemoEODao;
import com.adc.da.test.dao.PartsEODao;
import com.adc.da.test.entity.DemoEO;
import com.adc.da.test.entity.DemoVo;
import com.adc.da.test.entity.PartsEO;
import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("voService")
public class VoService {

    private static final Logger logger = LoggerFactory.getLogger(VoService.class);

    @Autowired
    private DemoEODao daoDemo;

    @Autowired
    private PartsEODao daoPar;

    //配置事务的隔离级别和传播行为
    //多表删除
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    public int moreTbaleDelete(String aid) throws Exception{
        String uId = daoDemo.queryidByAid(aid);
        String pId = daoPar.queryidByAid(aid);

        int k = daoDemo.deleteAByaid(aid);
        int i = daoDemo.deleteByPrimaryKey(uId);
        int j = daoPar.deleteByPrimaryKey(pId);


        return i+j+k;
    }

    //多表修改
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    public int moreTableUpdate(DemoVo demoVo) throws Exception{
        String aid = demoVo.getId();
        String uid = daoDemo.queryidByAid(aid);
        String pid = daoPar.queryidByAid(aid);

        DemoEO demoEO = new DemoEO();
        demoEO.setId(uid);
        demoEO.setUername(demoVo.getUername());
        demoEO.setPassword(demoVo.getPassword());
        int i = daoDemo.updateByPrimaryKeySelective(demoEO);

        PartsEO partsEO = new PartsEO();
        partsEO.setId(pid);
        partsEO.setParts(demoVo.getParts());
        partsEO.setPartsName(demoVo.getPartsName());
        int j = daoPar.updateByPrimaryKeySelective(partsEO);


        return i+j;
    }

    //多表插入
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    public int moreTableInsert(DemoVo demoVo) throws Exception{
        String aid = UUID.randomUUID();
        String uid = UUID.randomUUID();
        String pid = UUID.randomUUID();

        DemoEO demoEO = new DemoEO();
        demoEO.setId(uid);
        demoEO.setUername(demoVo.getUername());
        demoEO.setPassword(demoVo.getPassword());
        int i = daoDemo.insertSelective(demoEO);

        PartsEO partsEO = new PartsEO();
        partsEO.setId(pid);
        partsEO.setParts(demoVo.getParts());
        partsEO.setPartsName(demoVo.getPartsName());
        int j = daoPar.insertSelective(partsEO);

        int k = daoDemo.insertAById(aid, uid, pid);

        return i+j+k;
    }

}
