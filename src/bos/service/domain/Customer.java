package bos.service.domain;



/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String station;
     private String telephone;
     private String address;
     private String decidedzoneId;


    // Constructors

    /** default constructor */
    public Customer() {
    }

    
    /** full constructor */
    public Customer(Integer id, String name, String station, String telephone, String address, String decidedzoneId) {
    	this.id=id;
        this.name = name;
        this.station = station;
        this.telephone = telephone;
        this.address = address;
        this.decidedzoneId = decidedzoneId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getStation() {
        return this.station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDecidedzoneId() {
        return this.decidedzoneId;
    }
    
    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }
   








}