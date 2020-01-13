package com.example.demo.template;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import java.util.List;

public class Template1 {


    public static void main(String[] args) throws Exception {

        SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMddHHmmss");

        Map<String, List<List<String>>> resultMap = ExcelUtil.readExcel("F:\\deleteData\\data.xlsx");
        List<List<String>> infos = resultMap.get("Sheet1");

        String data = createTemplate(infos, 1);
        FileWriter fw = new FileWriter("F:\\deleteData\\select_" + myFmt.format(new Date()) + ".sql");
        fw.write(data);
        fw.flush();

        String data2 = createTemplate(infos, 2);
        FileWriter fw2 = new FileWriter("F:\\deleteData\\delete_" + myFmt.format(new Date()) + ".sql");
        fw2.write(data2);
        fw2.flush();

    }

    private static String getTemplateSelect(String imei, String iccid, int i) {

        String template = "#####  line:" + i + "  IMEI：" + imei + "  ICCID：" + iccid + "\n";
        template += "\n";
        template += "SELECT * FROM CAR_INFO WHERE IMEI = '" + imei + "';" + "\n";
        template += "SELECT * FROM FAMILY_ACCOUNT WHERE IMEI =  '" + imei + "'" + "\n";
        template += "SELECT * FROM FAMILY_ACCOUNT WHERE IMEI =  '" + imei + "';" + "\n";
        template += "SELECT * FROM OPERATE_LOG WHERE IMEI =  '" + imei + "';" + "\n";
        template += "SELECT * FROM SIM_INFO WHERE ICCID = '" + iccid + "'; " + "\n";
        template += "SELECT * FROM FLOW_GIFT_GET WHERE ICCID = '" + iccid + "';" + "\n";
        template += "SELECT * FROM ORDER_INFO WHERE ICC_ID = '" + iccid + "';" + "\n";
        template += "SELECT * FROM PURCHASE_SUPPLIER WHERE ICCID = '" + iccid + "';" + "\n";
        template += "SELECT * FROM PURCHASE_NI WHERE ICCID = '" + iccid + "';" + "\n";
        template += "SELECT * FROM RECHARGE_INFO WHERE ICCID = '" + iccid + "';" + "\n";
        template += "SELECT * FROM log_open_card WHERE iccid='" + iccid + "';" + "\n";

        return template;
    }

    private static String getTemplateDelete(String imei, String iccid, int i) {

        String template = "#####  line:" + i + "  IMEI：" + imei + "  ICCID：" + iccid + "\n";
        template += "\n";
        template += "DELETE FROM CAR_INFO WHERE IMEI = '" + imei + "';" + "\n";
        template += "DELETE FROM USER_CAR_RELATION WHERE IMEI = '" + imei + "'" + "\n";
        template += "DELETE FROM FAMILY_ACCOUNT WHERE IMEI = '" + imei + "';" + "\n";
        template += "DELETE FROM OPERATE_LOG WHERE IMEI =  '" + imei + "';" + "\n";
        template += "DELETE FROM SIM_INFO WHERE ICCID = '" + iccid + "'; " + "\n";
        template += "DELETE FROM FLOW_GIFT_GET WHERE ICCID = '" + iccid + "';" + "\n";
        template += "DELETE FROM ORDER_INFO WHERE ICC_ID = '" + iccid + "';" + "\n";
        template += "DELETE FROM PURCHASE_SUPPLIER WHERE ICCID = '" + iccid + "';" + "\n";
        template += "DELETE FROM PURCHASE_NI WHERE ICCID = '" + iccid + "';" + "\n";
        template += "DELETE FROM RECHARGE_INFO WHERE ICCID = '" + iccid + "';" + "\n";
        template += "DELETE FROM log_open_card WHERE iccid ='" + iccid + "';" + "\n";

        return template;
    }

    public static String createTemplate(List<List<String>> infos, int type) {

        String template = "use tfso;" + "\n";

        for (int i = 0; i < infos.size(); i++) {

            String imei = infos.get(i).get(0);
            String iccid = infos.get(i).get(1);

            if (StringUtils.isEmpty(imei)) {
                System.out.println("=================参数错误====================");
                return "";
            }

            if (StringUtils.isEmpty(iccid)) {

                System.out.println("=================参数错误====================");
                return "";
            }

            template += "\n";
            template += "\n";
            if (type == 1) {
                template += getTemplateSelect(imei, iccid, i + 1);
            } else {
                template += getTemplateDelete(imei, iccid, i + 1);
            }
        }
        return template;
    }
}
