package com.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Student;

public class StudentDAO {
	
	private Connection conn;

		public StudentDAO(Connection conn) {
			super();
			this.conn = conn;
		}
		
		public boolean addStudent(Student student)
		{
			boolean f=false;
			try {
				String qry="insert into student(name,dob,address,qualification,email) values(?,?,?,?,?)";
				
				PreparedStatement pstmt=conn.prepareStatement(qry);
				
				pstmt.setString(1,student.getFullName());
				pstmt.setString(2,student.getDob());
				pstmt.setString(3,student.getAddress());
				pstmt.setString(4,student.getQualification());
				pstmt.setString(5,student.getEmail());
				
				int i=pstmt.executeUpdate();
				
					if(i==1)
					{
						f=true;
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
			
		}
		
	 public List<Student> getAllStudent()
	 {
		 List<Student> list=new ArrayList<Student>();
		 Student s=null;
		 try {
			  String qry="select * from student";
			  PreparedStatement pstmt=conn.prepareStatement(qry);
			  
			  ResultSet rs=pstmt.executeQuery();
			  while(rs.next())
			  {
				  s=new Student();
				  s.setId(rs.getInt(1));
				  s.setFullName(rs.getString(2));
				  s.setDob(rs.getString(3));
				  s.setAddress(rs.getString(4));
				  s.setQualification(rs.getString(5));
				  s.setEmail(rs.getString(6));
				  list.add(s);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		 
	 }
	 
	public Student getStudentById(int id)
	{
		Student s=null;
		
		 try {
			  String qry="select * from student where id=?";
			  PreparedStatement pstmt=conn.prepareStatement(qry);
			  pstmt.setInt(1,id);
			  
			  ResultSet rs=pstmt.executeQuery();
			  while(rs.next())
			  {
				  s=new Student();
				  s.setId(rs.getInt(1));
				  s.setFullName(rs.getString(2));
				  s.setDob(rs.getString(3));
				  s.setAddress(rs.getString(4));
				  s.setQualification(rs.getString(5));
				  s.setEmail(rs.getString(6));
				  
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean updateStudent(Student student)
	{
		boolean f=false;
		try {
			String qry="update student set name=?,dob=?,address=?,qualification=?,email=? where id=?";
			
			PreparedStatement pstmt=conn.prepareStatement(qry);
			
			pstmt.setString(1,student.getFullName());
			pstmt.setString(2,student.getDob());
			pstmt.setString(3,student.getAddress());
			pstmt.setString(4,student.getQualification());
			pstmt.setString(5,student.getEmail());
			pstmt.setInt(6,student.getId());
			
			int i=pstmt.executeUpdate();
			
				if(i==1)
				{
					f=true;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
  public boolean deleteStudent(int id)
  {
	  boolean f=false;
	  
	  try {
		  String qry="delete from student where id=?";
		  PreparedStatement pstmt=conn.prepareStatement(qry);
		  pstmt.setInt(1,id);
		  
		  int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		
		  
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	  
  }

}
