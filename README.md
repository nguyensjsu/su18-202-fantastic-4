# su18-202-fantastic-4

### Design Decisions

- Used MVC design pattern
- Using Spring boot to achieve an excutable JAR
- The project consists of 3 jars

1. The Main starbucks-app JAR checked in under artifact is a wrapper on the business/api JAR and persistence JAR. The main JAR has the REST endpoint interface.
2. The Business/API JAR has the actual implementation of the functionality for Create Users, Add and Reload Card, Manage Orders, Manage Payment.
3. Persistence JAR has the database models. These entities represent real world entity like User, Card and Order. MongoDB is used as the database and connections are achieved using Spring Mongo Data.

### Cloud deployment
- Deployment on EC2, AutoScale Group and ELB
- Deployment on GKE

Initial Draft of Architecture Diagram

![alt text](https://s3-us-west-1.amazonaws.com/cloudimages2018/Component+Diagram+Starbucks+App.png)

Updated Architecture Diagram

![alt text](https://s3-us-west-1.amazonaws.com/cloudimages2018/Architecture+Diagram.png)

### CMPE 202 - Project - Team Portion Doc

Team Name	- Fantastic-4
Team Members	
Anushri Srinath Aithal (012506897)
Anu Sebastian (012496276)
Hemambujam Veeraraghavan (012482392)
Saloni Sharad Bhalerao (012466623)

- GitHub Repo	https://github.com/nguyensjsu/su18-202-fantastic-4
- Project Board	https://github.com/nguyensjsu/su18-202-fantastic-4/projects/1
- Project Journal	https://github.com/nguyensjsu/su18-202-fantastic-4/tree/master/team-journal
- Sprint Task Sheet https://docs.google.com/spreadsheets/d/1oJ-Mk4yIKfhXTutCxDLwAGS3t0IP6c7CpRegFZECa_8/edit?ts=5b54d268#gid=1004945973
- Presentation Slide Deck https://docs.google.com/presentation/d/1n_kTZboKZRLarsREojL558hVtR5Rwe3Twpki_T8FKEs/edit?usp=sharing

### Team Member-Contributions
- Project Design and Setup	Anushri Srinath Aithal
- Order Creation API	Anushri Srinath Aithal
- Get Order Details API	Anushri Srinath Aithal
- Update Order Status	Anushri Srinath Aithal
- Code Reviews	Anushri Srinath Aithal
- Unit Test cases for all APIs	Anushri Srinath Aithal
- EC2, Auto Scale Group, ELB Deployment	Anushri Srinath Aithal + Saloni Sharad Bhalerao
- Login API	Saloni Sharad Bhalerao
- Sign Up API	Saloni Sharad Bhalerao
- Manual Testing Login and Sign up APIs	Saloni Sharad Bhalerao
- Add Card API	Anu Sebastian
- Get Card Details API	Anu Sebastian
- Reload Card API	Anu Sebastian
- Manual Testing Card Flows	Anu Sebastian
- Calculate cost API	Hemambujam Veeraraghavan
- Make Payment and Update Card + Orders API	Hemambujam Veeraraghavan
- Manual Testing of Payment Flows	Hemambujam Veeraraghavan
- Docker Cloud Deployment	Hemambujam Veeraraghavan + Anu Sebastian
