package com.adc.da.elk.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adc.da.pdf.PDFPage;
import com.adc.da.pdf.PDFUtils;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.elk.entity.UusersEO;
import com.adc.da.elk.service.UusersEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/${restPath}/elk/uusers")
@Api(description = "|UusersEO|")
public class UusersEOController extends BaseController<UusersEO> {

    private static final Logger logger = LoggerFactory.getLogger(UusersEOController.class);

    @Autowired
    private UusersEOService uusersEOService;

   /* @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "helloQueue", durable = "true"),
            exchange = @Exchange(value = "adc-exchange", ignoreDeclarationExceptions = "true"),
            key = "cdf-key"))
*/
    /**
     * @Description:  RabbitMq接收消息
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
    */

    /*@ApiOperation(value = "|RabbitMq接收消息|")
    @GetMapping("/ReceiverHello")
    public void receiverHello(String hello) {
        System.out.println("hello Receiver : " + hello);
    }*/


    /**
     * @Description:  RabbitMq发送消息
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018-11-29
    */

   /* @ApiOperation(value = "|RabbitMq发送消息|")
    @GetMapping("/sendHi")
    public void sendHi() {
        String sendMsg = "Hi " + new Date();
        System.out.println("sendHi : " + sendMsg);
        this.rabbitTemplate.convertAndSend("adc-exchange", "adc-key", sendMsg);
    }*/

    /**
     * @Description:  组件测试：PDF文件导出
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:
    */

    @ApiOperation(value = "|PDF文件测试|")
    @GetMapping("/PDFExport")

    public ResponseMessage PDFExport() throws Exception {
        //获取对象
        UusersEO uusersEO = uusersEOService.selectByPrimaryKey("11");

        //用list记录pdf输入顺序
        List<Element> pdfList = new ArrayList();
        //设置标题
        Paragraph title = new Paragraph("PDF测试文件", PDFUtils.createfontCN(35));
        //居中显示
        title.setAlignment(Element.ALIGN_CENTER);
        Paragraph title2 = new Paragraph("PDF测试文件副标题", PDFUtils.createfontCN(25));
        //左对齐
        title2.setAlignment(Element.ALIGN_LEFT);

        //pdf添加标题
        pdfList.add(title);
        //表格每行四列
        PdfPTable pdfPTable = new PdfPTable(4);

        //第一行：标题
        PdfPCell pdfPCell = new PdfPCell(new Paragraph("姓名", PDFUtils.createfontCN(20)));
        //设置单元格边框 0f表示无边框
        pdfPCell.setBorderWidth(0f);
        //设置单元格内容位置：居中
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPTable.addCell(pdfPCell);

        pdfPTable.addCell(new Paragraph("性别", PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph("年龄", PDFUtils.FONTCN));
        //第二行：对应参数
        pdfPTable.addCell(new Paragraph(uusersEO.getUuid(), PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph(uusersEO.getUuname(), PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph(uusersEO.getUupassword(), PDFUtils.FONTCN));
        //第三行：标题
        pdfPTable.addCell(new Paragraph("姓名", PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph("性别", PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph("年龄", PDFUtils.FONTCN));
        //第四行：对应参数
        pdfPTable.addCell(new Paragraph(uusersEO.getUuid(), PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph(uusersEO.getUuname(), PDFUtils.FONTCN));
        pdfPTable.addCell(new Paragraph(uusersEO.getUupassword(), PDFUtils.FONTCN));
        //表前距
        pdfPTable.setSpacingBefore(50f);
        //添加表
        pdfList.add(pdfPTable);

        //插入图片
        Image image = Image.getInstance("E:\\60.jpg");
        image.scaleToFit(PageSize.A5.rotate());
        //设置图片绝对位置 坐标轴原点位于pdf页面左下角
        image.setAbsolutePosition(0, 0);
        //设置图片绝对大小
        image.scaleAbsolute(200f, 200f);
       /* setRotationDegrees() 按角度旋转
         setRotation()        按弧度旋转*/
        image.setRotation(90);

        //添加图片
        pdfList.add(image);

        //设置生成的PDF文件的存储地址
        File file = new File("e:/pdf/pdfName.pdf");
        file.getParentFile().mkdirs();

        new PDFUtils().createPdf("e:/pdf/pdfName.pdf", pdfList);
        //  return Result.success();


        /**
         * 生成多页PDF文件
         * */
        PDFPage page1 = new PDFPage();
        page1.add(new Paragraph("第一页", PDFUtils.FONTCN));

        PDFPage page2 = new PDFPage();
        page2.add(new Paragraph("第二页", PDFUtils.FONTCN));

        PDFPage page3 = new PDFPage();
        page3.add(new Paragraph("第三页", PDFUtils.FONTCN));

        List<PDFPage> pdfPageList = new ArrayList<>();
        pdfPageList.add(page1);
        pdfPageList.add(page2);
        pdfPageList.add(page3);

        new PDFUtils().createPdfWithNewPage("e:/pdf/pdfName2.pdf", pdfPageList, PageSize.A4);

        return Result.success();
    }

    /**
     * @Description:  通过uusers表跟userage表查询用户id，用户名和年龄
     * @Param:
     * @return:
     * @Author: elk_wangchengxin
     * @Date:  2018/11/28
     */

   /*@ApiOperation(value = "|elkVO1|多表查询1")
   @GetMapping("/searchUusers")
   @RequiresPermissions("user:user:userList")
   public ResponseMessage userAge() throws Exception {
       return Result.success(uusersEOService.userAge());
   }*/

   /**
    * @Description:  查询id尾数为4或者6 的年龄超过25岁的用户的信息
    * @Param:
    * @return:
    * @Author: elk_wangchengxin
    * @Date:  2018/11/28
   */

    /*@ApiOperation(value = "|elkVO2|多表查询2")
    @GetMapping("/searchAge")
    @RequiresPermissions("user:user:ageList")
    public ResponseMessage age() throws Exception {
        return Result.success(uusersEOService.age());
    }*/


}
