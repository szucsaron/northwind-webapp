package com.codecool.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractDao {

    protected final Connection connection;

    AbstractDao(Connection connection) {
        this.connection = connection;
    }


}
