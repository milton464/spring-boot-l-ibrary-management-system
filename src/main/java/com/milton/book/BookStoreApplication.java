package com.milton.book;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class BookStoreApplication {
	
	
	public static void main(String[] args) {
	
	//	new File(UploadController.uploadDirectory).mkdir();
		SpringApplication.run(BookStoreApplication.class, args);
		System.out.println("Library Management System");
	
		
//		SimpleDateFormat format = new SimpleDateFormat("dd MM yyy");
//		String d1 = "14 02 2020";
//		String d2 = "21 02 2020";
//		Date date= new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 7);
//		Date modi = cal.getTime();
//		System.out.println("modi: "+modi);
//		try {
//			Date date1= format.parse(d1);
//			Date date2=format.parse(d2);
//			
//			if(date.compareTo(date1)>0) {
//				long diff = date.getTime() - date1.getTime();
//				long d = (diff/(1000*60*60*24));
//				System.out.println("days: "+d);
//			}else if(date.compareTo(date1)<0) {
//				long diff = date.getTime() - date1.getTime();
//				long d = (diff/(1000*60*60*24));
//				System.out.println("days: "+d);
//			}
//			
//			
//			
//			System.out.println("Date: "+date);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
	
	}

}
