package edu.core.etl2.xml;

import edu.core.etl2.common.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Processor processor;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        processor.process("header1", "1a,msg1,10.0");
        System.out.println("----------------------------------");
        processor.process("header2", "2,msg2,20.2");
    }
}
