package com.ahm.jx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.model.AhmsdttmMstruletype;


/**
 * Repository : AhmjxmstRuleType.
 * Author : BeSmart Team
 */

@Repository
public interface AhmsdttmMstruletypeDao extends JpaRepository<AhmsdttmMstruletype, Integer> {
	

}
