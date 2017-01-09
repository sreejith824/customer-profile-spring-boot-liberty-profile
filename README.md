### Sample REST APIs :

* [Sample 1 - Get all customer]
GET /v1/customerprofile/?page=5&amp;size=5 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 696818d8-e0bf-f9b0-0d9c-dedbc32a27e6

* [Sample 2 - Get all customer]
GET /v1/customerprofile HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: d692d62b-7173-8553-ef2e-6977a96f2585

* [Sample 3 - Create a customer]
POST /v1/customerprofile HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: fbe412cb-bbba-4efb-54d5-0585c8c8a082

{
	"name" : "Test",
	"age" : "12"
}

### Liberty Profile Deployment desscriptor
* [server.xml]
<?xml version="1.0" encoding="UTF-8"?>
<server description="new server">
  <!-- Enable features -->
  <featureManager>
    <feature>adminCenter-1.0</feature>
    <feature>localConnector-1.0</feature>
    <feature>webProfile-7.0</feature>
  </featureManager>
  <!-- Define the host name for use by the collective.
        If the host name needs to be changed, the server should be
        removed from the collective and re-joined. -->
  <variable name="defaultHostName" value="localhost" />
  <!-- Define an Administrator and non-Administrator -->
  <basicRegistry id="basic">
    <user name="admin" password="adminpwd" />
    <user name="nonadmin" password="nonadminpwd" />
  </basicRegistry>
  <!-- Assign 'admin' to Administrator -->
  <administrator-role>
    <user>admin</user>
  </administrator-role>
  <keyStore id="defaultKeyStore" password="Liberty" />
  <httpEndpoint id="defaultHttpEndpoint" host="*" httpPort="9080" httpsPort="9443" />
  <applicationMonitor updateTrigger="mbean" />
  <library id="DB2JCC4Lib">
    <fileset dir="C:/DB2" includes="db2jcc4.jar db2jcc_license_cisuz.jar" />
  </library>
  <dataSource id="CustomerDataSource" jndiName="jdbc/customer" type="javax.sql.XADataSource">
    <jdbcDriver libraryRef="DB2JCC4Lib" javax.sql.XADataSource="com.ibm.db2.jcc.DB2XADataSource" />
    <properties.db2.jcc databaseName="IAALUNOS" serverName="192.168.190.180" portNumber="50000" driverType="4" connectionCloseWithInFlightTransaction="2" user="db2admin" password="db2admin" />
  </dataSource>
  <remoteFileAccess>
    <writeDir>${server.config.dir}</writeDir>
  </remoteFileAccess>
  <application id="customer_profile_war" location="C:\workspaces\was-liberty-profile\spring-boot-projects-pagination\customer-profile\target\customer-profile-1.0-SNAPSHOT.war" name="customer_profile_war" type="war" />
</server>





