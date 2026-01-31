# Electronic Medical Record (EMR) System

The EMR System is a web application designed to **digitally manage patient medical records** and streamline healthcare processes. It allows healthcare providers to add patients, record medical history, write diagnoses, create prescriptions, and maintain an overview of patient diseases.

A key feature of this system is the **unique disease identity number** for every diagnosed disease. This unique ID helps patients who have health insurance **easily claim benefits**, and it also facilitates reporting to government authorities through the **FHIR** document.

## Features
- Add and manage patients
- Record detailed medical history
- Write diagnoses and prescriptions
- Maintain disease overview for each patient
- Generate **unique disease identity numbers**
- FHIR document generation for government-level reporting
- Supports health insurance claims using unique disease IDs

## Tech Stack
- Backend: Java, Spring Boot
- Database: MySQL
- Frontend: HTML, CSS, JavaScript


## Setup Instructions

### Backend
Clone the repository:  
```bash
git clone https://github.com/Jerine-Ebenezer/emr.git
mvn clean install
mvn spring-boot:run

