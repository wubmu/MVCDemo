package com.wwwyb.dao.impl;

import com.wwwyb.dao.UserDao;
import com.wwwyb.domain.User;
import com.wwwyb.until.Dom4JUtil;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public class UserDaoDom4impl implements UserDao {

    @Override
    public void addUser(User user) {
        try {
            Document document = Dom4JUtil.getDocument();
            Element root = document.getRootElement();
            root.addElement("user")
                    .addAttribute("username", user.getUsername())
                    .addAttribute("password", user.getPassword())
                    .addAttribute("email", user.getEmail())
                    .addAttribute("birthday", user.getBirthday().toLocaleString());
            Dom4JUtil.write2xml(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findUserByUsername(String username) {
        try {
            Document document = Dom4JUtil.getDocument();
            Node node = document.selectSingleNode("//user[@username='" + username + "']");
            if (node == null)
                return false;
            else
                return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User findUser(String username, String password) {
        try {
            Document document = Dom4JUtil.getDocument();
            Node node = document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");
            if (node == null)
                return null;
            User user = new User();
            user.setUsername(node.valueOf("@username"));
            user.setPassword(node.valueOf("@password"));
            user.setEmail(node.valueOf("@email"));
           // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //String ddd = node.valueOf("@birthday");
            //Date birthday = df.parse(ddd);
            ///user.setBirthday(birthday);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
