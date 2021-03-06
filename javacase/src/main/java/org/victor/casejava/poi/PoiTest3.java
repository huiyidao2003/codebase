package org.victor.casejava.poi;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 测试处理临时的问题
 * Created by zhengcunwen on 2016/8/25.
 */
public class PoiTest3 {


    /**poi读取excel，导出**/
    public static void getExcel(){
        List<String> uids = Lists.newArrayList(
                "wq1480926369992bj40670390andczukw",
                "wq1481022314058bj10722973iosczukw",
                "wq1481088010648bj60998084andczukw",
                "wq1481435909634bj34502796iosczukw",
                "wq1481535406333bj67527377andczukw"

        );


        String path = "e:\\xingtan_detail.xlsx";
        try {
            InputStream is = new FileInputStream(path);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);


            Map<String,Pair<BigDecimal,BigDecimal>> sheetMap = Maps.newHashMap();
            XSSFSheet xssfSheet1 = xssfWorkbook.getSheetAt(5);
            for (int rowNum = 1; rowNum <= xssfSheet1.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet1.getRow(rowNum);
                if (xssfRow != null) {
                    String suid = getValue(xssfRow.getCell(0));
                    String anchor_id = getValue(xssfRow.getCell(1));
                    String wadiamond = getValue(xssfRow.getCell(4));
                    String income = getValue(xssfRow.getCell(5));

                    if(!sheetMap.containsKey(suid)){
                        sheetMap.put(suid,Pair.of(new BigDecimal(wadiamond),new BigDecimal(income)));
                    }else{
                        Pair<BigDecimal,BigDecimal> temp = sheetMap.get(suid);
                        BigDecimal left = temp.getLeft();
                        BigDecimal right = temp.getRight();

                        sheetMap.put(suid, Pair.of(left.add(new BigDecimal(wadiamond)), right.add(new BigDecimal(income))));
                    }
                }
            }

            for (Map.Entry<String,Pair<BigDecimal,BigDecimal>> entry:sheetMap.entrySet()){
                Pair<BigDecimal,BigDecimal> temp = entry.getValue();
                System.out.println(xssfSheet1.getSheetName() + "\t" + entry.getKey() + "\t" + temp.getRight());
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
        getExcel();
    }
}
