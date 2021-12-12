package com.amaurov.wowguildmanager.dal.interfaces;

import com.amaurov.wowguildmanager.models.Specialization;

import java.util.Set;

public interface SpecRepository {
    Set<Specialization> getAll();
    Specialization getByID(int id);
}
