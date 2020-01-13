package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class Template {

    public static void main(String[] args) throws Exception {




        FileWriter fw = new FileWriter("F:\\deleteData\\select.sql");

    }

    private static String getTemplate(String imei, String iccid) {

        String template = "##### IMEI：" + imei + "  ICCID：" + iccid + "\n";
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

    public static String createTemplate(Map<String, String> infos) {

        String template = "use tfso;" + "\n";

        for (Map.Entry<String, String> entry : infos.entrySet()) {
            template += "\n";
            template += "\n";
            template += getTemplate(entry.getKey(), entry.getValue());
        }
        return template;
    }
}
