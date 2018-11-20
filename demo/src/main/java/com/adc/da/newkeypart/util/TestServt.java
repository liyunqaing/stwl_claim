package com.adc.da.newkeypart.util;

import com.adc.da.checkData.entity.CheckdataEO;
import com.adc.da.checkData.service.CheckdataEOService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.sun.webkit.network.URLs.newURL;

/**
 * @ClassName TestServt
 * @Description TestServt
 * @Author Administrator
 * @DaTe 2018/11/16 0016 13:30
 */
public class TestServt {
    @Autowired
    private CheckdataEOService checkdataEOService;
    public static void main(String[] args) throws Exception {
//        // 服务地址
//        URL url = new URL("http://localhost:8080/verification/rest/certificate");
//        // 设定连接的相关参数
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setDoOutput(true);
//        connection.setRequestMethod("POST");
//        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
//        // 向服务端发送key=value对
//        out.write("certificateNOS=2012011109533586&AppKey=0df9c84524be414696ac5bbeb968716b&signature=60c3722dcb6f8a27fb77b56251a888c5&timestamp=2018");
//        out.flush();
//        out.close();
//
//        // 获取服务端的反馈
//        String strLine = "";
//        String strResponse = "";
//        InputStream in = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        while ((strLine = reader.readLine()) != null) {
//            strResponse += strLine;
//        }
        //模拟得到的数据
//        String simulateStrResponse = "[{\"address\":\"123\",\"id\":\"0\",\"organizationAddress_Producer\":\"123\",\"standardsAndRequirements\":\"123\",\"specifications\":\"123\",\"organizationName_Client\":\"123\",\"organizationAddress_Client\":\"123\",\"organizationName_Producer\":\"123\",\"institutionName\":\"123\",\"institutionApprovalNO\":\"123\",\"validityPeriod\":\"123\",\"businessScope\":\"123\",\"agencyStatus\":\"123\",\"firstDateOfCertification\":\"123\",\"productCategory\":\"123\",\"nameAndUnitMain\":\"123\",\"unifiedCode_Client\":\"123\",\"unifiedCode_Producer\":\"123\",\"nameAndUnitSecondary\":\"123\",\"certificateAnnexDownload\":\"123\",\"informationReportDate\":\"123\",\"certificateExpirationDate\":\"123\",\"certificateDate\":\"123\",\"certificateStatus\":\"无效\",\"certificateNO\":\"2012011109533586\",\"phone\":\"123\",\"changeDate\":\"123\",\"del\":\"网站查询\",\"url\":\"123\"}]";
//        JSONArray jsonArray = JSONArray.parseArray(simulateStrResponse);
//        List<CheckdataEO> list = new ArrayList();
//        if (!jsonArray.isEmpty()) {
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                CheckdataEO checkdataEO = jsonObject.toJavaObject(CheckdataEO.class);
//                list.add(checkdataEO);
//            }
//        }
//        CheckdataEO checkdataEO = list.get(0);
//        System.out.println(checkdataEO.getCertificateNO());
////        System.out.println(list.get(0).getAddress());
//        checkdataEOService.insertSelective(checkdataEO);

    }
}

