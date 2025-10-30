package com.cisco;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cisco.beans.Profile;
import com.cisco.dao.ProfileDao;

public class TestViewControllerService {
	public static void main(String[] args) {
		openUI();
	}
	public static void openUI() {
		Scanner scan = new Scanner(System.in);
		ProfileDao dao = new ProfileDao();
		int option =0;
		//controller logic
		do {
			System.out.println("1: Register 2: Find All 3: Find By ID 4: Update dob by ID 5: Delete by Id -1: Exit");
			option = scan.nextInt();
			switch(option) {
			case 1:
				Profile obj = new Profile();
				System.out.println("enter name");
				String name = scan.next();
				System.out.println("enter Dob in yyyy-mm-dd format");
				LocalDate dob= LocalDate.parse(scan.next());
				obj.setDob(dob);
				Profile created = dao.save(obj);
				System.out.println(created);
				break;
				
				
			case 2:
				List<Profile> list = dao.findAll()	;
				for(Profile profile:list) {
					System.out.println(profile);
				}
				break;
			case 3:
				System.out.println("Enter the id ");
				int id =scan.nextInt();
				Profile profile=dao.findById(id);
				if(profile!=null) {
					System.out.println(profile);
				}else {
					System.err.println("Profile not found");
				}
				break;
			}
			} while(option !=-1) ;
		scan.close();
	}

}
