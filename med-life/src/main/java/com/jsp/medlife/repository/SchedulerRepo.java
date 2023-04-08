package com.jsp.medlife.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.jsp.medlife.Model.Entities.Schedule;
import com.jsp.medlife.Model.Entities.User;

@Repository
public interface SchedulerRepo extends CrudRepository<Schedule, Integer>
{

//	@Query(value="select * from schedule where doctore_email=?1 ",nativeQuery=true)
//	public List<Schedule> findByDoctore_email(String email);

//	@Query(value="select * from users where user_email in (select user_email from schedule where doctore_email=?1) ",nativeQuery=true)
//	public List<Schedule> findByUser_email(String email);
	
	@Query(value="select * from users,schedule where users.doctore_email=schedule.doctore_email and doctore_email=?1 ",nativeQuery = true)
	public List<Object> findByUser_email(String email);
	
}
