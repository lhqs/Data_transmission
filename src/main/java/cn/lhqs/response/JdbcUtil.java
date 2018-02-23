package cn.lhqs.response;

import java.sql.*;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-21 18:35
 * description : JDBC工具类
 * version : 1.1
 */
public class JdbcUtil {
    private static Logger logger = Logger.getLogger(JdbcUtil.class);

    private static final String URL = "jdbc:mysql://10.1.3.101/plant";
    private static final String NAME = "root";
    private static final String PASS = "root123";

    /**
     * 插入数据操作
     *
     * @param temperature
     * @param humidity
     * @param create_user
     */
    public static void insert(String temperature, String humidity, String create_user) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, NAME, PASS);
        } catch (Exception e) {
            logger.error("loading出现异常 ：" + e);
        }
        StringBuffer sql = new StringBuffer();
        sql.append("insert into tem_hum_data (temperature , humidity , create_user, create_time )values(?,?,?,sysdate())");
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql.toString());
            psmt.setString(1, temperature);
            psmt.setString(2, humidity);
            psmt.setString(3, create_user);
            psmt.execute();
        } catch (SQLException e) {
            logger.error("insert操作异常 ：" + e);
        } finally {
            try {
                psmt.close();
                con.close();
            } catch (SQLException e) {
                logger.error("msyql关闭操作异常 ：" + e);
            }
        }

    }

    /**
     * insert sql by map
     *
     * @param map
     * @param create_user
     */
    public static void insertMap(Map<String, String> map, String create_user) {
        String tw0 = null, tw1 = null, tw2 = null, tw3 = null, ts0 = null, ts1 = null, ts2 = null, ts3 = null,
                yw0 = null, yw1 = null, yw2 = null, yw3 = null, ph0 = null, ph1 = null, ph2 = null, ph3 = null;
        for (String key : map.keySet()) {
            switch (key) {
                case "T0W":
                    tw0 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "T0S":
                    ts0 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "Y0W":
                    yw0 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "P0H":
                    ph0 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "T1W":
                    tw1 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "T1S":
                    ts1 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "Y1W":
                    yw1 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "P1H":
                    ph1 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "T2W":
                    tw2 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "T2S":
                    ts2 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "Y2W":
                    yw2 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "P2H":
                    ph2 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "T3W":
                    tw3 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "T3S":
                    ts3 = map.get(key).substring(0, map.get(key).length());
                    break;
                case "Y3W":
                    yw3 = map.get(key).substring(0, map.get(key).length() - 1);
                    break;
                case "P3H":
                    ph3 = map.get(key).substring(0, map.get(key).length());
                    break;

                default:
                    logger.info("the map is not suitable");
                    break;

            }
        }
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, NAME, PASS);
        } catch (Exception e) {
            logger.error("loading出现异常 ：" + e);
        }
        StringBuffer sql = new StringBuffer();
        if( tw0 != null || ts0 != null || yw0 != null || ph0 != null ){
            sql.append("insert into node_zero (ground, humidity, temperature, ph, create_user, create_time )values(?,?,?,?,?,sysdate())");
            PreparedStatement psmt = null;
            try {
                psmt = con.prepareStatement(sql.toString());
                psmt.setString(1, tw0);
                psmt.setString(2, ts0);
                psmt.setString(3, yw0);
                psmt.setString(4, ph0);
                psmt.setString(5, create_user);
                psmt.execute();
            } catch (SQLException e) {
                logger.error("insert操作异常 ：" + e);
            } finally {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    logger.error("msyql执行操作异常 ：" + e);
                }
            }
        }
        if( tw1 != null || ts1 != null || yw1 != null || ph1 != null ){
            sql = new StringBuffer();
            sql.append("insert into node_one (ground, humidity, temperature, ph, create_user, create_time )values(?,?,?,?,?,sysdate())");
            PreparedStatement psmt1 = null;
            try {
                psmt1 = con.prepareStatement(sql.toString());
                psmt1.setString(1, tw1);
                psmt1.setString(2, ts1);
                psmt1.setString(3, yw1);
                psmt1.setString(4, ph1);
                psmt1.setString(5, create_user);
                psmt1.execute();
            } catch (SQLException e) {
                logger.error("insert操作异常 ：" + e);
            } finally {
                try {
                    psmt1.close();
                } catch (SQLException e1) {
                    logger.error("msyql执行操作异常 ：" + e1);
                }
            }
        }

        if( tw2 != null || ts2 != null || yw2 != null || ph2 != null ){
            sql = new StringBuffer();
            sql.append("insert into node_two (ground, humidity, temperature, ph, create_user, create_time )values(?,?,?,?,?,sysdate())");
            PreparedStatement psmt2 = null;
            try {
                psmt2 = con.prepareStatement(sql.toString());
                psmt2.setString(1, tw2);
                psmt2.setString(2, ts2);
                psmt2.setString(3, yw2);
                psmt2.setString(4, ph2);
                psmt2.setString(5, create_user);
                psmt2.execute();
            } catch (SQLException e) {
                logger.error("insert操作异常 ：" + e);
            } finally {
                try {
                    psmt2.close();
                } catch (SQLException e2) {
                    logger.error("msyql执行操作异常 ：" + e2);
                }
            }
        }

        if( tw3 != null || ts3 != null || yw3 != null || ph3 != null ){
            sql = new StringBuffer();
            sql.append("insert into node_three (ground, humidity, temperature, ph, create_user, create_time )values(?,?,?,?,?,sysdate())");
            PreparedStatement psmt3 = null;
            try {
                psmt3 = con.prepareStatement(sql.toString());
                psmt3.setString(1, tw3);
                psmt3.setString(2, ts3);
                psmt3.setString(3, yw3);
                psmt3.setString(4, ph3);
                psmt3.setString(5, create_user);
                psmt3.execute();
            } catch (SQLException e) {
                logger.error("insert操作异常 ：" + e);
            } finally {
                try {
                    psmt3.close();
                } catch (SQLException e3) {
                    logger.error("msyql执行操作异常 ：" + e3);
                }
            }
        }

        try {
            con.close();
        } catch (SQLException ee) {
            logger.error("msyql关闭操作异常 ：" + ee);
        }

    }

}
