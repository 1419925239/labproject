package com.lab.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author 刘高伟
 * @Classname ParseExcel
 * @Description TODO
 * @Date 2020/2/26 14:37
 */
public class ParseExcel {
    /**
     * 解析文件的方法.
     * @param inputStream 文件输入流, 要解析的Excel文件输入流
     * @param suffix 文件后缀名, xls或xlsx. 代码决定使用什么方式解析Excel.
     * @param startRow 从第几行开始读取数据.
     * @return List<String[]> 集合中的一个元素对应一行解析的数据.
     * 		元素为字符串数组类型. 数组中的每个元素对应一列数据.
     * @throws IOException
     */
    public List<String[]> parseExcel(InputStream inputStream, String suffix, int startRow)
            throws IOException {

        // 1. 定义excel对象变量
        Workbook workbook = null;

        // 2. 判断后缀.决定使用的解析方式. 决定如何创建具体的对象
        if("xls".equals(suffix)){
            // 2003
            workbook = new HSSFWorkbook(inputStream);
        }else if("xlsx".equals(suffix)){
            // 2007
            workbook = new XSSFWorkbook(inputStream);
        }else{
            // 未知内容
            return null;
        }

        // 获取工作表  excel分为若干个表. sheet
        Sheet sheet = workbook.getSheetAt(0);

        if(sheet == null){
            return null;
        }

        // 获取表格中最后一行的行号
        int lastRowNum = sheet.getLastRowNum();

        // 最后一行的行号大于startRow
        if(lastRowNum <= startRow){
            return null;
        }


        List<String[]> resultList = new ArrayList<String[]>();

        // 定义行变量和单元格变量
        Row row = null;
        Cell cell = null;
        // 循环读取
        for(int rowNum = startRow; rowNum <= lastRowNum; rowNum++){
            row = sheet.getRow(rowNum);
            // 获取当前行的第一列和最后一列的标记
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            if(lastCellNum != 0){
                String[] rowArray = new String[lastCellNum];
                for(int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++){
                    cell = row.getCell(cellNum);
                    // 判断单元格是否有数据
                    if(cell == null){
                        rowArray[cellNum] = null;
                    }else{
                        rowArray[cellNum] = parseCell(cell);
                    }
                }
                resultList.add(rowArray);
            }
        }

        return resultList;
    }

    /**
     * 解析单元格
     * @return String 单元格数据
     */
    private String parseCell(Cell cell){
        String cellStr = null;

        // 判断单元格的类型
        switch(cell.getCellType()){
            case HSSFCell.CELL_TYPE_STRING :
                // 字符串类型单元格
                cellStr = cell.getRichStringCellValue().toString();
                break;
            case HSSFCell.CELL_TYPE_BLANK :
                // 空数据, 标准数据
                cellStr = "";
                break;
            case HSSFCell.CELL_TYPE_NUMERIC :
                // 数学类型. 数学类型包含日期,时间,数字
                // 判断日期[年月日2016-11-17 | 时分10:00]类型
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    // 判断具体类型, 是日期还是时间
                    SimpleDateFormat sdf = null;
                    if(cell.getCellType() == HSSFDataFormat.getBuiltinFormat("h:mm")){
                        // 时间
                        sdf = new SimpleDateFormat("HH:mm");
                    }else{
                        // 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date temp = cell.getDateCellValue();
                    cellStr = sdf.format(temp);
                }else{
                    // 数字
                    double temp = cell.getNumericCellValue();
                    // 数学格式化工具
                    DecimalFormat format = new DecimalFormat();
                    // 查看单元格中的具体样式类型
                    String formatStr = cell.getCellStyle().getDataFormatString();
                    if(formatStr.equals("General")){
                        // 定义格式化正则. 使用具体有效数据进行个时候.且只保留有效数据.
                        format.applyPattern("#");
                    }
                    cellStr = format.format(temp);
                }
                break;
            default :
                cellStr = "";
        }

        return cellStr;
    }
}
