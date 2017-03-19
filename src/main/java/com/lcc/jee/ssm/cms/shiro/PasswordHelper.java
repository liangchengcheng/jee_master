package com.lcc.jee.ssm.cms.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.lcc.jee.ssm.cms.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 * Created by asus on 2017/3/19.
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("md5")
    private String algorithmName = "md5";
    @Value("2")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String encryptPassword(String password) {
        String salt = randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(
                algorithmName,
                password,
                salt,
                hashIterations).toHex();
        return newPassword;
    }

    public String encryptPassword(String password, String salt) {
        String newPassword = new SimpleHash(
                algorithmName,
                password,
                salt,
                hashIterations).toHex();
        return newPassword;
    }

    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }

    public static void main(String args[]) {
        PasswordHelper helper = new PasswordHelper();
        String npd = helper.encryptPassword("123", "b429331aa3b95e710bc0f5a766b1a920");
        System.out.println(npd);
    }
}
