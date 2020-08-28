package com.mysample.jdbcdemorest;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentDBResource {
	
	StudentDBRepository dbRepo = new StudentDBRepository();
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getAllStudents() {
		System.out.println("Calling getAllStudents() from DB:");
		return dbRepo.getStudents();
	}
	
	@GET
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getSpecificStudent(@PathParam("id") int id) {
		System.out.println("Calling getSpecificStudent() from DB:");
		return dbRepo.getStudent(id);
	}
	
	@POST
	@Path("create")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student createStudent(@BeanParam Student stud) {
//		stud.setName("M.Riya");
//		stud.setDob("14-01-2015");
//		stud.setId(100);
//		stud.setStd("1'std");
//		stud.setSubject("English");
//		stud.setMark(75);
		
//		stud.setName("G.Nila");
//		stud.setDob("10-05-2015");
//		stud.setId(101);
//		stud.setStd("UKG");
//		stud.setSubject("English");
//		stud.setMark(70);
		System.out.println("Calling createStudent() into DB:"+stud);
		dbRepo.createStudent(stud);
		return stud;
	}
	
	@PUT
	@Path("update/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student updateStudent(@PathParam("id") int id) {
		Student stud = dbRepo.getStudent(id);
		if(stud == null || stud.getId() == 0) {
			dbRepo.createStudent(stud);
		} else {
			stud.setName("M.Riya");
			stud.setDob("14-01-2015");
			stud.setId(100);
			stud.setStd("1'std");
			stud.setSubject("TAMIL");
			stud.setMark(75);
			dbRepo.updateStudent(stud);
		}
		System.out.println("Calling updateStudent() into DB:"+stud);
		return stud;
	}
	
	@DELETE
	@Path("delete/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student deleteStudent(@PathParam("id") int id) {
		System.out.println("Calling deleteStudent() from DB:"+id);
		Student stud = dbRepo.getStudent(id);
		if(stud.getId() != 0) {
			dbRepo.deleteStudent(id);
		}
		return stud;
		
	}
}
