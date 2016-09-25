package com.ahm.sd.ttm.app002.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahm.jx.dao.AhmsdttmMstclusterDao;
import com.ahm.sd.model.AhmsdttmMstcluster;
import com.ahm.sd.ttm.app002.service.Ttm002Service;

@Service
public class Ttm002ServiceImpl implements Ttm002Service {

	@Autowired
	AhmsdttmMstclusterDao clusterRepo;	
	
	@Override
	public String editCluster(Map<String, Object> params) {
		Float xrange;
		Integer pk = Integer.parseInt(params.get("pk").toString());
		Float value = Float.parseFloat(params.get("value").toString());
		String nameD = params.get("name").toString();
		String a = "Failed";
		if (nameD.equals("rangeFrom")){
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			Integer clusterSeq = cluster.getSequence();
			if (cluster.getRangeThru() != null){	
				if (clusterSeq != 1)
				{
					Integer clusterSeqx = clusterSeq-1;
					Integer clusterType = cluster.getIdClusterType();
					AhmsdttmMstcluster clusterx = clusterRepo.findBySequenceAndIdClusterType(clusterSeqx,clusterType);
					xrange = clusterx.getRangeThru();
				}
				else{ xrange = (float) 0;}
				if (cluster.getRangeThru()>value && (xrange<value))
					{
					cluster.setRangeFrom(value);
					clusterRepo.save(cluster);
					//clusterRepo.updateClRangeFrom(pk, value);
					return a="Success";}
				
				}
			else{
				//cluster.set
				cluster.setRangeFrom(value);
				clusterRepo.save(cluster);
				//clusterRepo.updateClRangeFrom(pk, value);
				return a="Success";
			}
			return a ;
		}
		else if (nameD.equals("rangeThru"))
		{
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			Integer clusterSeq = cluster.getSequence();
			Integer clusterTypex = cluster.getIdClusterType();
				if ((clusterSeq !=6 && clusterTypex==1) || (clusterSeq!=5 && clusterTypex==2) )
				{
					Integer clusterSeqx = clusterSeq+1;
					Integer clusterType = cluster.getIdClusterType();
					AhmsdttmMstcluster clusterx = clusterRepo.findBySequenceAndIdClusterType(clusterSeqx,clusterType);
					xrange = clusterx.getRangeFrom();
				}
				else{ xrange = (float) 0;}
			if(xrange==null){clusterRepo.updateClRangeTo(pk, value);return a="Success";}
			else{
				if (cluster.getRangeFrom()<value && (xrange>value || xrange==0 ))
				{			
					cluster.setRangeThru(value);
					clusterRepo.save(cluster);
//						clusterRepo.updateClRangeTo(pk, value);
					return a="Success";}
				}
			return a;
		}
		else if (nameD.equals("lower"))
		{
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			if(cluster.getMedian()>value )
			{
				cluster.setLower(value);
				clusterRepo.save(cluster);
				//clusterRepo.updateClLower(pk, value);
				return a="Success";}
				return a;
			}
		else if (nameD.equals("median"))
		{
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			if(cluster.getUpper()>value && cluster.getLower()<value){
				cluster.setMedian(value);
				clusterRepo.save(cluster);
				//clusterRepo.updateClMedian(pk, value);
				return a="Success";}	
				return a;
		}
		else if (nameD.equals("upper"))	
		{
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			if(cluster.getMedian()<value)
			{
				//clusterRepo.updateClUpper(pk, value);
				cluster.setUpper(value);
				clusterRepo.save(cluster);
				return a="Success";}
				return a;
			}
		else if (nameD.equals("growthRate"))			
			{
			AhmsdttmMstcluster cluster = clusterRepo.findOne(pk);
			cluster.setGrowthRate(value);
			clusterRepo.save(cluster);
			return a="Success";}
		return a;
	}

	@Override
	public List<AhmsdttmMstcluster> getClusterProvinsi() {
		List<AhmsdttmMstcluster> d = clusterRepo.findByIdClusterTypeOrderBySequence(AhmsdttmMstcluster.TYPE_PROVINSI);
		return d;
	}

	@Override
	public List<AhmsdttmMstcluster> getClusterKab() {
		List<AhmsdttmMstcluster> d = clusterRepo.findByIdClusterTypeOrderBySequence(AhmsdttmMstcluster.TYPE_KABUPATEN);
		return d;
	}

}
