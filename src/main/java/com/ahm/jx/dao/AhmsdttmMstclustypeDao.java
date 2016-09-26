package com.ahm.jx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.sd.model.AhmsdttmMstclustype;


/**
 * Repository : AhmsdttmClusteringType.
 * Author : BeSmart Team
 */

@Repository
public interface AhmsdttmMstclustypeDao extends JpaRepository<AhmsdttmMstclustype, Integer> {

}
