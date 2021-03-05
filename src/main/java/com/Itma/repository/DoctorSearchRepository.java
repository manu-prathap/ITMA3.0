//package com.Itma.repository;
//
//import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import com.Itma.model.Doctor;
//
//public interface DoctorSearchRepository extends PagingAndSortingRepository<Doctor, String> {
//
//	@Query(value = "SELECT * FROM doctor WHERE MATCH(country, state, district, address, doctor_email, first-name, last_name) AGAINST(?1) ")
//	public List<Doctor> search(String keyword);
//	
//	
//}
