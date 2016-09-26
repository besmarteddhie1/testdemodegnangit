package com.ahm.jx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahm.sd.model.AhmsdttmMstcluster;


/**
 * Repository : AhmsdttmClustering.
 * Author : BeSmart Team
 */

@Repository
public interface AhmsdttmMstclusterDao extends JpaRepository<AhmsdttmMstcluster, Integer> {
	
	List<AhmsdttmMstcluster> findByIdClusterTypeOrderBySequence(@Param("idClusterType") Integer idClusterType);
	
	AhmsdttmMstcluster findBySequenceAndIdClusterType(Integer sequence, Integer idClusterType);
	
	@Query("select r from AhmsdttmMstcluster r, AhmsdttmMstgeobou g WHERE (g.indexPotensi between r.rangeFrom and r.rangeThru) and (g.idGeo = :idGeo) and (r.idClusterType=2)")
	AhmsdttmMstcluster getGrowthRateOfGeo(@Param("idGeo") String idGeo);

	@Modifying
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.rangeFrom = :value WHERE clus.idRule = :id")
	int updateClRangeFrom(@Param("id") Integer id, @Param("value") Float value);
	
	@Modifying
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.rangeThru = :value WHERE clus.idRule = :id")
	int updateClRangeTo(@Param("id") Integer id, @Param("value") Float value);
	
	@Modifying
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.growthRate = :value WHERE clus.idRule = :id")
	int updateClGrowthRate(@Param("id") Integer id, @Param("value") Float value);
	
	@Modifying
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.upper = :value WHERE clus.idRule = :id")
	int updateClUpper(@Param("id") Integer id, @Param("value") Float value);
	
	@Modifying
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.median = :value WHERE clus.idRule = :id")
	int updateClMedian(@Param("id") Integer id, @Param("value") Float value);
	
	@Modifying 
	@Query("UPDATE AhmsdttmMstcluster clus SET clus.lower = :value WHERE clus.idRule = :id")
	int updateClLower(@Param("id") Integer id, @Param("value") Float value);
	
}
