package com.rns.XCodeX.XCodeX_Product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodexApp{
    public static void main( String[] args )
    {
    	SpringApplication app = new SpringApplication(CodexApp.class);
		app.run(args);
	 }

}
