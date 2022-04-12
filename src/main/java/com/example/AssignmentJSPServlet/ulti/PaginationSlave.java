package com.example.AssignmentJSPServlet.ulti;

import com.example.AssignmentJSPServlet.ulti.Config.ConfigSql;

public class PaginationSlave {
    public static final int pageSize = 5;

    public static String pagination(int pageIndex){
        return ConfigSql.SPACE+ConfigSql.LIMIT+ConfigSql.SPACE+(pageIndex-1)*pageSize+ConfigSql.COMMA+pageSize;
    }

}
