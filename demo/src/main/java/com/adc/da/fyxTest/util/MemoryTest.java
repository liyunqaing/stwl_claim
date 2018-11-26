package com.adc.da.fyxTest.util;

/**
 * @program: stwl_claim2
 * @description: 运行内存检测
 * @author: cuiyuxin
 * @create: 2018-11-19 16:47
 * @version: 2.0.0
 **/
public class MemoryTest {
    //开始内存使用量（kb）
    private static double startMemory;
    //结束内存使用量（kb）
    private static double endMemory;
    /** 
 * @Description:检测初始化  
 * @Param: [] 
 * @return:  
 * @Author: cuiyuxin
 * @Date: 2018/11/19 
*/
    public MemoryTest(){
        this.startMemory=0.0;
        this.endMemory=0.0;
    }
    /** 
     * @Description: 检测记录开始 
     * @Param: [] 
     * @return: void 
     * @Author: cuiyuxin
     * @Date: 2018/11/19 
    */
    public void start(){
        Runtime.getRuntime().gc();
        startMemory=(double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
   }
   /**
    * @Description: 检测记录结束 
    * @Param: [] 
    * @return: void 
    * @Author: cuiyuxin
    * @Date: 2018/11/19 
   */
    public void end(){
        endMemory=(double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
     }
     /** 
      * @Description: 输出记录 
      * @Param: [] 
      * @return: void 
      * @Author: cuiyuxin
      * @Date: 2018/11/19 
     */
     public void show(){
        System.out.println("记录开始时内存使用量"+String.format("%.2f", startMemory)+"KB");
        System.out.println("记录结束时内存使用量"+String.format("%.2f", endMemory)+"KB");
         System.out.println("共使用内存量"+String.format("%.2f", (endMemory-startMemory))+"KB");
    }
}
