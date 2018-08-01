package com.create.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.create.dao.UserDao;
import com.create.po.Wx_user;

public class Jdbc_Service implements UserDao {

	static final String DB_URL = "jdbc:mysql://localhost:3306/create_wx?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	static final String user_1 = "root";
	static final String pas = "root";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Jdbc_Service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(Wx_user user) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			// String sql = "insert into wx_user values(2,'clearlove','1995-01-26',200)";//
			// 后期再修改
			String sql = "insert into wx_user(realname,openid,nickname,province,city,sex,headimgurl,unid,org_id,idno,companyId,departId,createtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";// 这句话是传参数是未知的，需要我们进行获取...
			ps = cn.prepareStatement(sql);
			// 这四个函数就是为了获取我们插入的信息...上面采用了直接在sql里写入我们要插入的数据，其实我们也可以在主函数里进行传参...见下面主函数...
			ps.setString(1, user.getRealname());
			ps.setString(2, user.getOpenid());
			ps.setString(3, user.getNickname());
			ps.setString(4, user.getProvince());
			ps.setString(5, user.getCity());
			ps.setInt(6, user.getSex());
			ps.setString(7, user.getHeadimgurl());
			ps.setString(8, user.getUnionid());
			ps.setString(9, user.getOrg_id());
			ps.setString(10, user.getIdno());
			ps.setString(11, user.getCompanyId());
			ps.setString(12, user.getDepartId());
			ps.setTimestamp(13, new java.sql.Timestamp(user.getCreatetime().getTime())); // 转换，将java.util中的Date转换称java.sql中的Date
			int count = ps.executeUpdate();
			if (count == 1) {
				System.out.print("添加成功");
			} else {
				System.out.print("添加不成功");
			}
			ps.close();
			cn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (cn != null) {
						try {
							cn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	@Override
	public List<Wx_user> getUserByOpenId(String openId) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Wx_user> resultWx_user = new ArrayList<Wx_user>();
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			String sql = "select * from wx_user where openId='"+openId+"'";
			// 导入sql语句...
			ps = cn.prepareStatement(sql);
			// 保存执行sql语句后的结果对象...
			rs = ps.executeQuery();
			  while(rs.next()){
				    Wx_user wx_user = new Wx_user();
			        int id = rs.getInt("id");
			        wx_user.setId(id);
			        String openid = rs.getString("openid");
			        if(StringUtils.isNotBlank(openid)) {
			        	wx_user.setOpenid(openid);
			        }
			        String realname = rs.getString("realname");
			        if(StringUtils.isNotBlank(realname)) {
			        	wx_user.setRealname(realname);
			        }
			        String nickname = rs.getString("nickname");
			        if(StringUtils.isNotBlank(nickname)) {
			        	wx_user.setNickname(nickname);
			        }
			        String province = rs.getString("province");
			        if(StringUtils.isNotBlank(province)) {
			        	wx_user.setProvince(province);
			        }
			        String city = rs.getString("city");
			        if(StringUtils.isNotBlank(city)) {
			        	wx_user.setCity(city);;
			        }
			        int sex = rs.getInt("sex");
			        wx_user.setSex(sex);
			        String headimgurl = rs.getString("headimgurl");
			        if(StringUtils.isNotBlank(headimgurl)) {
			        	wx_user.setHeadimgurl(headimgurl);
			        }
			        String unionid = rs.getString("unid");
			        if(StringUtils.isNotBlank(unionid)) {
			        	wx_user.setUnionid(unionid);
			        }
			        String org_id = rs.getString("org_id");
			        if(StringUtils.isNotBlank(org_id)) {
			        	wx_user.setOrg_id(org_id);
			        }
			        String idno = rs.getString("idno");
			        if(StringUtils.isBlank(idno)) {
			        	wx_user.setIdno(idno);
			        }
			        String companyId = rs.getString("companyId");
			        if(StringUtils.isBlank(companyId)) {
			        	wx_user.setCompanyId(companyId);
			        }
			        String departId = rs.getString("departId");
			        if(StringUtils.isBlank(departId)) {
			        	wx_user.setDepartId(departId);
			        }
			        resultWx_user.add(wx_user);
			    }
			  
			ps.close();
			cn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultWx_user;
	}

	@Override
	public Wx_user getUserById(int userid) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			String sql = "select * from wx_user where id=1";
			// 导入sql语句...
			ps = cn.prepareStatement(sql);
			// 保存执行sql语句后的结果对象...
			rs = ps.executeQuery();
			ps.close();
			cn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public int update(Wx_user wx_user) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			String sql = "update wx_user set logointype="+wx_user.getLogintype();
			if(StringUtils.isNotBlank(wx_user.getCountry())) {
				sql += " ,country='"+wx_user.getCountry()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getRealname())) {
				sql += " ,realname='"+wx_user.getRealname()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getEmail())) {
				sql += " ,email='"+wx_user.getEmail()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getPassword())) {
				sql += " ,password='"+wx_user.getPassword()+"'";
			}
			if(wx_user!=null&&wx_user.getBirthday()!=null) {
				sql += " ,password='"+wx_user.getPassword()+"'";
			}
			if(wx_user!=null&&wx_user.getBirthday()!=null) {
				sql += " ,password="+wx_user.getBirthday();
			}
			if(wx_user!=null&&wx_user.getEnterday()!=null) {
				sql += " ,enterday="+wx_user.getEnterday();
			}
			if(wx_user!=null&&wx_user.getRegisterTime()!=null) {
				sql += " ,registerTime="+wx_user.getRegisterTime();
			}
			if(StringUtils.isNotBlank(wx_user.getMobile())) {
				sql += " ,mobile="+wx_user.getMobile();
			}
			if(StringUtils.isNotBlank(wx_user.getIdno())) {
				sql += " ,idno="+wx_user.getIdno();
			}
			if(StringUtils.isNotBlank(wx_user.getUnionid())) {
				sql += " ,unid="+wx_user.getUnionid();
			}
			if(StringUtils.isNotBlank(wx_user.getOrg_id())) {
				sql += " ,org_id="+wx_user.getOrg_id();
			}
			if(StringUtils.isNotBlank(wx_user.getCompanyId())) {
				sql += " ,companyId="+wx_user.getCompanyId();
			}
			if(StringUtils.isNotBlank(wx_user.getDepartId())) {
				sql += " ,org_id="+wx_user.getDepartId();
			}
			if(StringUtils.isNotBlank(wx_user.getOpenid())) {
				sql += " where  openId='"+wx_user.getOpenid()+"'";
			}
			ps = cn.prepareStatement(sql);
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(Wx_user user) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			String sql = "delete from userr where id=1";
			ps = cn.prepareStatement(sql);
			int count = -1;
			count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Wx_user> queryByModel(Wx_user wx_user) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Wx_user> resultWx_user = new ArrayList<Wx_user>();
		try {
			cn = DriverManager.getConnection(DB_URL, user_1, pas);
			String sql = "select * from wx_user where sex="+wx_user.getSex();
			if(StringUtils.isNotBlank(wx_user.getOpenid())) {
				sql += " and openId='"+wx_user.getOpenid()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getCountry())) {
				sql += " and country='"+wx_user.getCountry()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getRealname())) {
				sql += " and realname='"+wx_user.getRealname()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getEmail())) {
				sql += " and email='"+wx_user.getEmail()+"'";
			}
			if(StringUtils.isNotBlank(wx_user.getPassword())) {
				sql += " and password='"+wx_user.getPassword()+"'";
			}
			/*if(wx_user!=null&&wx_user.getBirthday()!=null) {
				sql += " and password='"+wx_user.getPassword()+"'";
			}
			if(wx_user!=null&&wx_user.getBirthday()!=null) {
				sql += " and password="+wx_user.getBirthday();
			}
			if(wx_user!=null&&wx_user.getEnterday()!=null) {
				sql += " and enterday="+wx_user.getEnterday();
			}*/
			if(StringUtils.isNotBlank(wx_user.getMobile())) {
				sql += " and mobile="+wx_user.getMobile();
			}
			if(StringUtils.isNotBlank(wx_user.getIdno())) {
				sql += " and idno="+wx_user.getIdno();
			}
			if(StringUtils.isNotBlank(wx_user.getUnionid())) {
				sql += " and unid="+wx_user.getUnionid();
			}
			if(StringUtils.isNotBlank(wx_user.getOrg_id())) {
				sql += " and org_id="+wx_user.getOrg_id();
			}
			if(StringUtils.isNotBlank(wx_user.getCompanyId())) {
				sql += " and companyId="+wx_user.getCompanyId();
			}
			if(StringUtils.isNotBlank(wx_user.getDepartId())) {
				sql += " and org_id="+wx_user.getDepartId();
			}
			// 导入sql语句...
			ps = cn.prepareStatement(sql);
			// 保存执行sql语句后的结果对象...
			rs = ps.executeQuery();
			  while(rs.next()){
			        int id = rs.getInt("id");
			        wx_user.setId(id);
			        String openid = rs.getString("openid");
			        if(StringUtils.isNotBlank(openid)) {
			        	wx_user.setOpenid(openid);
			        }
			        String realname = rs.getString("realname");
			        if(StringUtils.isNotBlank(realname)) {
			        	wx_user.setRealname(realname);
			        }
			        String nickname = rs.getString("nickname");
			        if(StringUtils.isNotBlank(nickname)) {
			        	wx_user.setNickname(nickname);
			        }
			        String province = rs.getString("province");
			        if(StringUtils.isNotBlank(province)) {
			        	wx_user.setProvince(province);
			        }
			        String city = rs.getString("city");
			        if(StringUtils.isNotBlank(city)) {
			        	wx_user.setCity(city);;
			        }
			        int sex = rs.getInt("sex");
			        wx_user.setSex(sex);
			        String headimgurl = rs.getString("headimgurl");
			        if(StringUtils.isNotBlank(headimgurl)) {
			        	wx_user.setHeadimgurl(headimgurl);
			        }
			        String unionid = rs.getString("unid");
			        if(StringUtils.isNotBlank(unionid)) {
			        	wx_user.setUnionid(unionid);
			        }
			        String org_id = rs.getString("org_id");
			        if(StringUtils.isNotBlank(org_id)) {
			        	wx_user.setOrg_id(org_id);
			        }
			        String idno = rs.getString("idno");
			        if(StringUtils.isBlank(idno)) {
			        	wx_user.setIdno(idno);
			        }
			        String companyId = rs.getString("companyId");
			        if(StringUtils.isBlank(companyId)) {
			        	wx_user.setCompanyId(companyId);
			        }
			        String departId = rs.getString("departId");
			        if(StringUtils.isBlank(departId)) {
			        	wx_user.setDepartId(departId);
			        }
			        resultWx_user.add(wx_user);
			    }
			  
			ps.close();
			cn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultWx_user;
	
	}

}
