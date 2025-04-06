import service.ApplicationService;
import service.impl.ApplicationServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ApplicationService applicationService = new ApplicationServiceImpl();
        applicationService.start();


    }




}
