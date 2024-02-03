# kerberos-hive-jdbc
A simple demo that Connected to Kerberos-enabled hive via JDBC directly from JDK8/JDK17
## Usage
- HiveJdbcByJdk8.java: In JDK8 env,you can run directly.
- HiveJdbcByJdk17.java:
  In JDK17 env, you also need to set VM options `--add-exports java.security.jgss/sun.security.krb5=ALL-UNNAMED` !
  Failure to do so will result in the following exception:
  
> Caused by: java.lang.IllegalAccessException: class org.apache.hadoop.security.authentication.util.KerberosUtil
cannot access class sun.security.krb5.Config (in module java.security.jgss)
because module java.security.jgss does not export sun.security.krb5 to unnamed module @770c2e6b
## about blog
It will more detail info in my blog : [https://blog.csdn.net/qq_44831907/article/details/135989049](https://blog.csdn.net/qq_44831907/article/details/135989049)
