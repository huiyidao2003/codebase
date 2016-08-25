package org.victor.casejava.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 测试处理临时的问题
 * Created by zhengcunwen on 2016/8/25.
 */
public class Temp {


    /**poi读取excel，得到用户推荐信息**/
    public static void getInviteList(){
        String path = "e:\\temp1.xlsx";
        try {
            InputStream is = new FileInputStream(path);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

            int numSheet = xssfWorkbook.getNumberOfSheets();

            // 第一个sheet
            List<String> parentList1 = Lists.newArrayList();
            XSSFSheet xssfSheet1 = xssfWorkbook.getSheetAt(0);
            for (int rowNum = 1; rowNum <= xssfSheet1.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet1.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(0);

                    //System.out.println(no.getStringCellValue());
                    parentList1.add(no.getStringCellValue());
                }
            }

            // 第二个sheet
            List<String> parentList2 = Lists.newArrayList();
            XSSFSheet xssfSheet2 = xssfWorkbook.getSheetAt(1);
            for (int rowNum = 1; rowNum <= xssfSheet2.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet2.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(0);

                    //System.out.println(no.getStringCellValue());
                    parentList2.add(no.getStringCellValue());
                }
            }

            // 第三个个sheet
            List<String> parentList3 = Lists.newArrayList();
            XSSFSheet xssfSheet3 = xssfWorkbook.getSheetAt(2);
            for (int rowNum = 1; rowNum <= xssfSheet3.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet3.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(0);

                    parentList3.add(no.getStringCellValue());
                }
            }
            // 第4个sheet
            List<String> parentList4 = Lists.newArrayList();
            XSSFSheet xssfSheet4 = xssfWorkbook.getSheetAt(3);
            for (int rowNum = 1; rowNum <= xssfSheet4.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet4.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(0);

                    parentList4.add(no.getStringCellValue());
                }
            }

            // 第5个sheet
            List<String> parentList5 = Lists.newArrayList();
            XSSFSheet xssfSheet5 = xssfWorkbook.getSheetAt(4);
            for (int rowNum = 1; rowNum <= xssfSheet5.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet5.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(1);

                    parentList5.add(no.getStringCellValue());
                }
            }


            for (String p5:parentList5){
                boolean mark = false;
                for (String p1:parentList1){
                    if(p5.equals(p1)){
                        mark = true;
                        break;
                    }
                }
                for (String p2:parentList2){
                    if(p5.equals(p2)){
                        mark = true;
                        break;
                    }
                }
                for (String p3:parentList3){
                    if(p5.equals(p3)){
                        mark = true;
                        break;
                    }
                }
                for (String p4:parentList4){
                    if(p5.equals(p4)){
                        mark = true;
                        break;
                    }
                }
                if(!mark){
                    System.out.println(p5);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNickname(){
        String path = "e:\\temp1.xlsx";
        try {
            InputStream is = new FileInputStream(path);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

            int numSheet = xssfWorkbook.getNumberOfSheets();

            // 得到nickNameList
 /*           Map<String,String> nickNameMap = Maps.newHashMap();
            XSSFSheet xssfSheetNickName = xssfWorkbook.getSheetAt(5);
            for (int rowNum = 0; rowNum <= xssfSheetNickName.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheetNickName.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell uid = xssfRow.getCell(0);
                    XSSFCell nickName = xssfRow.getCell(1);

                    nickNameMap.put(uid.getStringCellValue(),getValue(nickName));
                    //System.out.println(uid.getStringCellValue());
                    //System.out.println(nickName.getStringCellValue());

                }
            }*/
            // 得到waquList
            Map<String,String> waquMap = Maps.newHashMap();
            XSSFSheet xssfSheetwaqu = xssfWorkbook.getSheetAt(6);
            for (int rowNum = 0; rowNum <= xssfSheetwaqu.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheetwaqu.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell uid = xssfRow.getCell(0);
                    XSSFCell waqu = xssfRow.getCell(1);
                    waquMap.put(uid.getStringCellValue(),getValue(waqu));
                }
            }


            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(4);
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    String uid = "无";
                    XSSFCell cell = xssfRow.getCell(2);
                    if(cell != null){
                        uid = cell.getStringCellValue();
                    }

                   if(waquMap.containsKey(uid)){
                       String a = waquMap.get(uid);

                       System.out.println(StringUtils.isBlank(a)?" ":a.substring(0,a.length()-2));
                   }else{
                       System.out.println(" ");
                   }
                  /*  if(nickNameMap.containsKey(uid)){
                        String a = nickNameMap.get(uid);

                        System.out.println(StringUtils.isBlank(a)?"无":a + " a");
                    }else{
                        System.out.println("无");
                    }*/


                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**转换cell格式**/
    private static String getValue(XSSFCell hssfCell){
        if(hssfCell == null) return "";
        if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){
            return String.valueOf( hssfCell.getBooleanCellValue());
        }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){
            return String.valueOf( hssfCell.getNumericCellValue());
        }else if (hssfCell.getCellType() ==hssfCell.CELL_TYPE_STRING){
            return String.valueOf(hssfCell.getStringCellValue());
        }else{
            return String.valueOf( hssfCell.getStringCellValue());
        }
    }


    public static void main(String[] args) {
        writeNickname();
    }
}
