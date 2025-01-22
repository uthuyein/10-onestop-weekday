package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Leave;
import com.jdc.mkt.model.entity.LeavePk;
import com.jdc.mkt.model.input.SearchLeaveDto;
import com.jdc.mkt.model.output.SelectLeaveDto;
import com.jdc.mkt.model.repo.LeaveRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveService {

	private final LeaveRepo repo;	
	
	public List<SelectLeaveDto> search(SearchLeaveDto search) {
		return repo.search(searchFun(search));
	}
	
	private  Function<CriteriaBuilder,CriteriaQuery<SelectLeaveDto>> searchFun(SearchLeaveDto search) {
		
		return cb -> {
			var cq = cb.createQuery(SelectLeaveDto.class);
			var root = cq.from(Leave.class);
			
			SelectLeaveDto.select(cq, root);
			
			cq.where(search.search(cb, cq, root));
			
			return cq;
		};
	}

	public Leave save(Leave leave) {
		return repo.save(leave);
	}
	
	public Leave update( Leave leave) {
		Leave l = repo.findById(leave.getId()).orElseThrow(() -> new RuntimeException("No Leave ID Found"));
		
		l.setLeaveType( null != leave.getLeaveType()? leave.getLeaveType():l.getLeaveType());
		l.setReason(null != leave.getReason()? leave.getReason():l.getReason());
		
		return repo.save(l);
	}
	
	public void delete(LeavePk pk) {
		repo.deleteById(pk);
	}
	
	
	
}
