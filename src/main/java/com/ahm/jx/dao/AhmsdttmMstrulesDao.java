package com.ahm.jx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.model.AhmsdttmMstrules;


/**
 * Repository : AhmjxmstRules.
 * Author : BeSmart Team
 */

@Repository
public interface AhmsdttmMstrulesDao extends JpaRepository<AhmsdttmMstrules, Integer> {

}
