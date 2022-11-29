package com.codeup.workoutlister.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreventDataLeak {

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection CONNECTION, PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (CONNECTION != null) {
                CONNECTION.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection CONNECTION, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (CONNECTION != null) {
                CONNECTION.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}