# TomcatJndiDataSource
ทดสอบเชื่อมต่อ jdbc กับ mysql database ผ่าน jndi

รันโปรเจกต์อย่างไร?
1. ใช้ Git คัดลอกโปรเจกต์ ด้วยคำสั่ง `git clone https://github.com/proSbeginner/TomcatJndiDataSource`
2. โปรเจกต์สร้างด้วย Maven ดังนั้นสร้้าง .war ด้วยคำสั่ง `maven package`
3. ย้าย .war ที่ได้ไปไว้ใน folder ชื่อ webapps ของ Tomcat
4. แม้ว่าจะไม่มี mysql connector/j (driver) อยู่ในโปรเจกต์ แต่ก็ต้องมี mysql connector/j อยู่ใน lib ของ Tomcat อยู่ดี
5. รัน Tomcat แล้วเรียกไปที่ `http://localhost:8080/TomcatJndiDataSource/test`
