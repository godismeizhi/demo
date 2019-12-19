package com.example.demo.excel;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelToJson {

    public static void main(String[] args) throws Exception {

        Map<String, List<List<String>>> excelData = ExcelUtil.readExcel("E:\\test.xlsx");


        List<List<String>> infos = excelData.get("Sheet1");
        List<String> infoTitle = infos.get(0);
        infos.remove(0);

        List<Map<String, Object>> outputData = new ArrayList<>();

        for (List<String> infoLine : infos) {

            Map<String, Object> data = new HashMap<>();
            for (int i = 0; i < infoLine.size(); i++) {
                if (i == 0) {
                    data.put(infoTitle.get(i), Integer.valueOf(infoLine.get(i)));
                } else {
                    data.put(infoTitle.get(i), infoLine.get(i));
                }

            }
            outputData.add(data);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(outputData);

        System.out.println("==========" + result);

        FileWriter writer;
        try {
            writer = new FileWriter("E:/result.json");
            writer.write(result);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
