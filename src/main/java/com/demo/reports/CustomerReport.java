package com.demo.reports;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.CustomerContactDetailsDaoInt;
import com.demo.dao.CustomerDaoInt;
import com.demo.service.CustomerContactDetailsServiceInt;
import com.demo.service.CustomerServiceInt;


@Controller
public class CustomerReport {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	
	@Autowired
	private CustomerDaoInt custIntDao;
	@Autowired
	private CustomerServiceInt customerServiceInt;
	@Autowired
	private CustomerContactDetailsServiceInt contactDetailsServiceInt;
	@Autowired
	private CustomerContactDetailsDaoInt customerContactDetailsDaoIntDaoInt;

    @RequestMapping(value = "/customerListDownloadPDF", method = RequestMethod.GET)
    public ModelAndView customerListDownloadPDF() 
		 {
    	logger.debug("Received request to download PDF report");
    	//String customerName = null;
		ModelAndView modelAndView = null;
		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		
		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		//JRDataSource customerContactPerson = customerContactDetailsDaoIntDaoInt.getCustomerContactPersonDetailsDataSource();
		JRDataSource customerList  = custIntDao.getCustomerListDataSource();
		
		// In order to use Spring's built-in Jasper support, 
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("customerListDatasource", customerList);
		
		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/customerList-views.xml
		modelAndView = new ModelAndView("customerListPdfReport",  parameterMap);
		
		
		// Return the View and the Model combined
		return modelAndView;
	}
    
    @RequestMapping(value = "/viewCustomerDownloadPDF", method = RequestMethod.GET)
    public ModelAndView viewCustomerReportPDF(@RequestParam("customerName") String customerName) 
		 {
    	logger.debug("Received request to download PDF report");
		ModelAndView modelAndView = null;
		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		
		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		JRDataSource contactList  = contactDetailsServiceInt.getCustomerContactDetailsDataSource(customerName);
		JRDataSource viewCustomer  = custIntDao.getCustomerDetailsDataSource(customerName);
		
		// In order to use Spring's built-in Jasper support, 
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("viewCustomerDatasource", viewCustomer);
		parameterMap.put("viewCustomerDatasource", contactList);
		
		
		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/viewCustomer-views.xml
		modelAndView = new ModelAndView("viewCustomerPdfReport", parameterMap);
		
		// Return the View and the Model combined
		return modelAndView;
	}
    
}
