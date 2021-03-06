package ren.xiangmu.iiwx.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import ren.xiangmu.iiwx.controller.HomeController;
 
public class MybatisRedisCache implements Cache {
 
	@Autowired
	private static JedisConnectionFactory jedisConnectionFactory;
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
 
    private final String id;
 
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 
    public MybatisRedisCache(final String id) {
    	logger.info("====================MybatisRedisCache=====================");
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }
 
    @Override
    public void clear() {
    	logger.info("====================clear=====================");
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
 
    @Override
    public String getId() {
    	logger.info("====================getId=====================");
        return this.id;
    }
 
    @Override
    public Object getObject(Object key) {
    	logger.info("====================getObject=====================");
        Object result = null;
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(serializer.serialize(key)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
 
    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
 
    @Override
    public int getSize() {
    	logger.info("====================getSize=====================");
        int result = 0;
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
 
    @Override
    public void putObject(Object key, Object value) {
    	logger.info("====================putObject=====================");
        RedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
 
    @Override
    public Object removeObject(Object key) {
    	logger.info("====================removeObject=====================");
        RedisConnection connection = null;
        Object result = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = connection.expire(serializer.serialize(key), 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
 
    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
 
}
