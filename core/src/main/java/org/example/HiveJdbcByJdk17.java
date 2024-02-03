package org.example;

import java.io.IOException;
import java.sql.*;

public class HiveJdbcByJdk17 {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        // 1.加载Kerberos配置文件
        System.setProperty("java.security.auth.login.config", "/home/guzhenzhen/yf-kerberos/test/gss-jaas.conf");
        System.setProperty("sun.security.jgss.debug", "true");
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        System.setProperty("java.security.krb5.conf", "/home/guzhenzhen/yf-kerberos/test/krb5.conf");
        System.setProperty("sun.security.krb5.debug", "true");


        // 2.设置Kerberos认证
//        Configuration configuration = new Configuration();
//        configuration.set("hadoop.security.authentication", "Kerberos");
//        UserGroupInformation.setConfiguration(configuration);
//        UserGroupInformation.loginUserFromKeytab("hive/admin", "/home/guzhenzhen/yf-kerberos/test/hive.keytab");

        // 3.JDBC连接字符串
        String jdbcURL = "jdbc:hive2://yfashmd02.yfco.yanfengco.com:10000/test;principal=hive/_HOST@AUTOEXPR.COM";

        Class.forName("org.apache.hive.jdbc.HiveDriver");

        try {
            // 4.创建Hive连接
            Connection connection = DriverManager.getConnection(jdbcURL, "", "");
            // 5.执行Hive查询
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,name,age FROM student");

            // 6.处理查询结果
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3));
            }

            // 7.关闭连接
            rs.close();
            statement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}