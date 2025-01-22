package com.jdc.mkt.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mkt.model.entity.Leave;
import com.jdc.mkt.model.entity.LeavePk;
import com.jdc.mkt.model.input.SearchLeaveDto;
import com.jdc.mkt.model.output.SelectLeaveDto;
import com.jdc.mkt.model.services.LeaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/leave")
public class LeaveManagementApi {

	private final LeaveService service;
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody LeavePk pk) {
		service.delete(pk);
		return new ResponseEntity<>("Delete Leave ID ", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Leave leave) {
		var l = service.update(leave);
		
		return new ResponseEntity<>(
				"Update %s leave of %s".formatted(
				l.getEmployee().getName(),l.getLeaveType().name()),
				HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Leave leave) {
		var l = service.save(leave);
		
		return new ResponseEntity<>("Save %s leave of %s".formatted(
				l.getEmployee().getName(),l.getLeaveType().name()), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SelectLeaveDto>> search(@RequestBody(required = false) SearchLeaveDto search) {
		if(null == search) {
            search = new SearchLeaveDto(0,null,null,null,null);
		}
		return new ResponseEntity<>(service.search(search), HttpStatus.OK);
	}
	
	
}
