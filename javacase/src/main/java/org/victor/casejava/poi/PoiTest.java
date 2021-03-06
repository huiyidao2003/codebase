package org.victor.casejava.poi;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
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
public class PoiTest {


    /**poi读取excel，导出**/
    public static void getInviteList(){
        String path = "e:\\temp1.xlsx";
        try {
            InputStream is = new FileInputStream(path);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);


            List<String> parentList1 = Lists.newArrayList();
            XSSFSheet xssfSheet1 = xssfWorkbook.getSheetAt(6);
            for (int rowNum = 0; rowNum <= xssfSheet1.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet1.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell no = xssfRow.getCell(0);

                    //System.out.println(no.getStringCellValue());
                    parentList1.add(no.getStringCellValue());
                }
            }

            Map<String,String> map = Maps.newHashMap();
            XSSFSheet xssfSheet2 = xssfWorkbook.getSheetAt(0);
            for (int rowNum = 1; rowNum <= xssfSheet2.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet2.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell v1 = xssfRow.getCell(0);
                    XSSFCell v2 = xssfRow.getCell(2);

                    map.put(getValue(v1),getValue(v2));
                }
            }


            for (String p:parentList1){
                if(map.containsKey(p)){
                    System.out.println(map.get(p));
                }else{
                    System.out.println("--");
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
        getInviteList();
    }
}
