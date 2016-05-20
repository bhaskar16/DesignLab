# Tutors and Students
tutorsandstudents.in 1.0 Release Notes

###Introduction
Welcome to Tutors and Students 1.0. Tutors and Students is an online platform which aims to provide an online meeting place for private tutors, students and offline agencies which try to connect tutors and students. This release contains the main functionalities of negotiation, managing tutors, searching tutors, and rating and reviewing the tutors.

Minimum requirements
The requirements required for the release 1.0 are given as follows.

•	JSP

•	MySql

•	Apache Tomcat


###JSP

Jsp Java Version v1.7.0_51

Important: This is the latest version used to support the release 0.1.


###MySql

MySql module v10.1.8


###Apache module

Tomcat v7.0



##Features of this system:

•	System helps the students to search for tutors according to their preferences.

•	System helps the students and independent tutors to negotiate with each other.

•	The agents can negotiate with the students directly for their respective tutors.

•	The students can rate and review the respective tutors.


System helps the students to search for tutors according to their preferences.

The system helps the user to search for their tutors. The parameters used while performing the search operations are discipline, sub-discipline, remuneration, day slot preference, time slot preference, experience preference, age preference, gender preference, batch preference and external agent verification. Based on these parameters the system runs an optimal search algorithm to get the required tutors.


System helps the students and independent tutors to negotiate with each other.

The system allows the students and tutors to negotiate with each other through messages. The negotiation system allows the user to send the messages by using text boxes. It also keeps a record of all the messages exchanged throughout the negotiation process.


The agents can negotiate with the students directly for their respective tutors.

The agents negotiate with the students on behalf of their tutors. The system provides the agents to negotiate with the students so that the tutors and students do not negotiate with each other directly. This solves the problem of students and tutors bypassing the agent as mentioned in the problem statement.


The students can rate and review the respective tutors.

The students can rate and review any tutor registered with the system. The reviews are segregated as verified reviews in case the system has a record of a finalized contract between that student and tutor. All students can view the overall rating and reviews of all tutors on searching. This can help the students judge the tutor better.


##Known issues
1.	Rating and reviewing of Tutors are merged into a single form and not separated. User has to both rate and review the tutor at the same time.

2.	Manual URL manipulation is not protected against.

3.	The graphical priority input box for search is not provided to the user. The priority is hardcoded into the system.

4.	The date of birth field date picker does not function according to HTML5 specifications in Mozilla Firefox.

5.	Profile picture not implemented


##Suggestions for Future versions
1.	Messaging subsystem should use web sockets for dynamic updates.

2.	Notification System needs to be implemented.

3.	Deleted contracts are removed completely from the System. System should maintain a record of cancelled contracts.

4.	Search algorithm may be further refined for more optimized results.
