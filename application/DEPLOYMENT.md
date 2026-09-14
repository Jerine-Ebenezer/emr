# EMR Project — Deployment Details

## Live Application

Frontend (Vercel):
https://emr-amber-beta.vercel.app/

## Backend

Spring Boot Backend (Render):
https://emr-backend-ni58.onrender.com

## Database

MySQL Database (Aiven):
mysql-149696c6

## Deployment Architecture

Frontend → Vercel
Backend → Render
Database → Aiven MySQL

Frontend
↓
Vercel
↓
Render (Spring Boot)
↓
Aiven (MySQL)
