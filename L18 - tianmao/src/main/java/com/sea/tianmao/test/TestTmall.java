package com.sea.tianmao.test;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
    public static void main(String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://111.230.143.15:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8", "root", "Wdh!@#456");
                Statement s = con.createStatement();
        ) {
            for (int i = 1; i <= 10; i++) {
                String sqlFormat = "insert into category values(null,'测试分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }
            System.out.println("已经成功创建10条分类测试数据");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
