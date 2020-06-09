package com.ncepu.cloudyispringframeworkdemo.jdbc;

import java.io.Serializable;


/**
 * @author:huangyunyi
 **/
public class User implements Serializable {
   public static final long serialVersionUID = -1L;

   private String username;
   private String accountName;
   private String description;

   public User() {

   }

   public User(String username, String accountName, String description) {
      this.username = username;
      this.accountName = accountName;
      this.description = description;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getAccountName() {
      return accountName;
   }

   public void setAccountName(String accountName) {
      this.accountName = accountName;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
