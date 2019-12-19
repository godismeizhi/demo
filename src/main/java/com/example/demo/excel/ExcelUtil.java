package com.example.demo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {


    /**
     * 读取excel内容
     *
     * @param excelPath
     * @return
     */
    public static Map<String, List<List<String>>> readExcel(String excelPath) {

        File file = new File(excelPath);

        Workbook workbook = null;

        //判断excel的版本
        try {
            if (excelPath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(new FileInputStream(file));
            } else if (excelPath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回的excel数据
        Map<String, List<List<String>>> excelDataMap = new HashMap<>();

        if (workbook != null) {

            int sheetCount = workbook.getNumberOfSheets();

            //遍历sheet
            for (int i = 0; i < sheetCount; i++) {

                List<List<String>> sheetData = new ArrayList<>();
                Sheet sheet = workbook.getSheetAt(i);


                //遍历行
                for (int rownum = sheet.getFirstRowNum(); rownum <= sheet.getLastRowNum(); rownum++) {

                    List<String> rowData = new ArrayList<>();
                    Row row = sheet.getRow(rownum);

                    if (row == null || row.getFirstCellNum() < 0) {
                        break;
                    }

                    //遍历单元格
                    for (int columnnum = row.getFirstCellNum(); columnnum < row.getLastCellNum(); columnnum++) {

                        Cell cell = row.getCell(columnnum);
                        String cellValue = "";
                        if (cell != null) {
                            // 都按文本格式读取
                            cell.setCellType(CellType.STRING);
                            cellValue = cell.getStringCellValue();
                        }
                        //添加单元格数据
                        rowData.add(cellValue);
                    }
                    //添加行数据
                    sheetData.add(rowData);
                }

                //设置每一个sheet的数据
                excelDataMap.put(sheet.getSheetName(), sheetData);
            }
        }
        return excelDataMap;
    }
}
