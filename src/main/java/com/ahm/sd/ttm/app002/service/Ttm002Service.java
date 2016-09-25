package com.ahm.sd.ttm.app002.service;


import java.util.List;
import java.util.Map;

import com.ahm.sd.model.AhmsdttmMstcluster;

public interface Ttm002Service {
	
	String editCluster(Map<String, Object> params); 
	
	List<AhmsdttmMstcluster> getClusterProvinsi();
	
	List<AhmsdttmMstcluster> getClusterKab();

}
