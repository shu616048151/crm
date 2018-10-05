package bos.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CustomizableThreadCreator;

import bos.service.CustomerService;
import bos.service.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Customer> findAll() {
		String sql="select * from t_customer";
		List<Customer> customerList= jdbcTemplate.query(sql,  new RowMapper<Customer>(){

			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int id = rs.getInt("id");
			  	String name=  rs.getString("name");
				String  station= rs.getString("station");
				String telephone=  rs.getString("telephone");
				String address=rs.getString("address");
				String decidedzoneId=rs.getString("decidedZone_id");
				Customer customer=new Customer(id, name, station, telephone, address, decidedzoneId);
				return customer;
			}
			
		});
		return customerList;
	}


	public List<Customer> noAssociateCustomer() {
		String sql="select * from t_customer where decidedZone_id is null";
		List<Customer> customerList= jdbcTemplate.query(sql, new RowMapper<Customer>(){

			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int id = rs.getInt("id");
			  	String name=  rs.getString("name");
				String  station= rs.getString("station");
				String telephone=  rs.getString("telephone");
				String address=rs.getString("address");
				String decidedzoneId=rs.getString("decidedZone_id");
				Customer customer=new Customer(id, name, station, telephone, address, decidedzoneId);
				return customer;
			}
			
		});
		return customerList;
	}


	public List<Customer> hasAssociateCustomer(String id) {
		String sql="select * from t_customer where decidedZone_id =?";
		List<Customer> customerList= jdbcTemplate.query(sql, new RowMapper<Customer>(){

			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int id = rs.getInt("id");
			  	String name=  rs.getString("name");
				String  station= rs.getString("station");
				String telephone=  rs.getString("telephone");
				String address=rs.getString("address");
				String decidedzoneId=rs.getString("decidedZone_id");
				Customer customer=new Customer(id, name, station, telephone, address, decidedzoneId);
				return customer;
			}
			
		},id);
		return customerList;
	}


	public void associateCustomer(int[] customerIds, String decidedId) {
		//先清除之前的对应关系
		String sql="update t_customer set decidedZone_id=null where decidedZone_id=?";
		jdbcTemplate.update(sql, decidedId);
		//添加关联关系
		sql="update t_customer set decidedZone_id=? where id=?";
		for (int id : customerIds) {
			jdbcTemplate.update(sql, decidedId,id);
		}
	}


	public Customer findCustomerByTelephone(String telephone) {
		String sql="select * from t_customer where telephone=?";
		List<Customer>  customerList=jdbcTemplate.query(sql, new RowMapper<Customer>(){

			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
			  	String name=  rs.getString("name");
				String  station= rs.getString("station");
				String telephone=  rs.getString("telephone");
				String address=rs.getString("address");
				String decidedzoneId=rs.getString("decidedZone_id");
				Customer customer=new Customer(id, name, station, telephone, address, decidedzoneId);
				return customer;
			}},telephone);
		if (customerList.size()>0&&customerList!=null) {
			return customerList.get(0);
		}
		return null;
	}

	public String findCustomerIdByAddress(String address) {
		String sql="select decidedzone_id  from t_customer where address=?";
		String decidedId = jdbcTemplate.queryForObject(sql, String.class, address);
		return decidedId;
	}

}
