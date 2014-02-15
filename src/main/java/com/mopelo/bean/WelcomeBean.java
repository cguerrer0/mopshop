package com.mopelo.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.HorizontalAlignment;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.LegendLayout;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.VerticalAlignment;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.highcharts.theme.Theme;
import com.mopelo.domain.HelloWorld;
import com.mopelo.service.HelloWorldService;
import com.mopelo.service.dto.HelloWorldDTO;
import com.mopelo.util.LoggerUtils;
import com.mopelo.util.MapperUtils;

/**
 * Welcome controller.
 * 
 * @author cguerrero
 */
@ManagedBean
public class WelcomeBean {

	/**
	 * Last name.
	 */
	private String lastName;

	/**
	 * First name.
	 */
	private String firstName;
	
	private HashMap<String, Integer> data1;
	private ArrayList<String> barColor;
	   
	   
	      Options options;
	      Theme myTheme ;


	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldService}
	 */
	@ManagedProperty(value = HelloWorldService.EL_NAME)
	private HelloWorldService helloWorldService;



	/* ************************************ */
	/* Attributes */
	/* ************************************ */

	/** 
	 * List of hellos
	 */
	private List<HelloWorldDTO> listHellos;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	public String createHello() {
		HelloWorldDTO hello = new HelloWorldDTO(firstName,lastName);
		
		helloWorldService.create((HelloWorld) MapperUtils.map(hello, HelloWorld.class));
		return "welcome?faces-redirect=true";
	}

	/**
	 * Retrieve hello dto
	 * 
	 * @return list of hello dto
	 */
	public List<HelloWorldDTO> retrieveList() {
		// Prevent multiple calls from JSF
		if (listHellos == null) {
			LoggerUtils.logDebug("Initialize hello world list for display");
			listHellos = helloWorldService.retrieveAll();
		}
		return listHellos;
	}
	
	public WelcomeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	   @PostConstruct
	   public void init() {
		   data1 = new HashMap<String, Integer>();
		      data1.put("Obama", 349);
		      data1.put("McCain", 163);
		 
		      barColor = new ArrayList<String>();
		      barColor.add("#003366");
		      
		      options = new Options();
		      myTheme = new Theme();

		      options
		          .setChartOptions(new ChartOptions()
		              .setType(SeriesType.LINE));

		      options
		          .setTitle(new Title("My very own chart."));

		      options
		          .setxAxis(new Axis()
		              .setCategories(Arrays
		                  .asList(new String[] { "Jan", "Feb", "Mar", "Apr", "May",
		                      "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" })));

		      options
		          .setyAxis(new Axis()
		              .setTitle(new Title("Temperature (C)")));

		      options
		          .setLegend(new Legend()
		              .setLayout(LegendLayout.VERTICAL)
		              .setAlign(HorizontalAlignment.RIGHT)
		              .setVerticalAlign(VerticalAlignment.TOP)
		              .setX(-10)
		              .setY(100)
		              .setBorderWidth(0));

		      options
		          .addSeries(new SimpleSeries()
		              .setName("Tokyo")
		              .setData(
		                  Arrays
		                      .asList(new Number[] { 7.0, 6.9, 9.5, 14.5, 18.2, 21.5,
		                          25.2, 26.5, 23.3, 18.3, 13.9, 9.6 })));

		      options
		          .addSeries(new SimpleSeries()
		              .setName("New York")
		              .setData(
		                  Arrays
		                      .asList(new Number[] { -0.2, 0.8, 5.7, 11.3, 17.0, 22.0,
		                          24.8, 24.1, 20.1, 14.1, 8.6, 2.5 })));
		      
		     
		   // define the first three colors for all charts
		   myTheme.addColor(new HexColor("#00FF00"));
		   myTheme.addColor(new HexColor("#FF0000"));
		   myTheme.addColor(new HexColor("#0000FF"));
		   // defining the titles
		   //myTheme.setTitle("My Chart");
		   //myTheme.setSubtitle("All charts using this theme will have this subtitle");

	   }



	/**
	 * Throw {@link FacesException}.
	 * 
	 * @return outcome "welcome"
	 */
	public String throwException() {
		throw new FacesException();
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */



	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public HashMap<String, Integer> getData1() {
		System.out.println("Estoy en el metodo haciendo cositas");
		return data1;
	}

	public void setData1(HashMap<String, Integer> data1) {
		this.data1 = data1;
	}

	public ArrayList<String> getBarColor() {
		return barColor;
	}

	public void setBarColor(ArrayList<String> barColor) {
		this.barColor = barColor;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Theme getMyTheme() {
		return myTheme;
	}

	public void setMyTheme(Theme myTheme) {
		this.myTheme = myTheme;
	}
	

}