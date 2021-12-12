package com.amaurov.wowguildmanager.dal.interfaces;

import com.amaurov.wowguildmanager.models.Class;

import java.sql.ResultSet;
import java.util.Set;

public interface ClassRepository {
    Set<Class> getAll();
    Class getByID(int id);
}
